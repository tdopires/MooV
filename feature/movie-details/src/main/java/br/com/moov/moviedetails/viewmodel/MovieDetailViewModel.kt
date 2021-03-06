/*
 * Copyright 2020 Alex Almeida Tavella
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.moov.moviedetails.viewmodel

import br.com.core.android.BaseViewModel
import br.com.core.android.UiEvent
import br.com.core.android.UiModel
import br.com.moov.bookmark.movie.BookmarkMovieUseCase
import br.com.moov.bookmark.movie.UnBookmarkMovieUseCase
import br.com.moov.moviedetails.domain.GetMovieDetailUseCase
import br.com.moov.moviedetails.domain.MovieDetail
import javax.inject.Inject

internal class MovieDetailViewModel @Inject constructor(
    private val getMovieDetail: GetMovieDetailUseCase,
    private val bookmarkMovie: BookmarkMovieUseCase,
    private val unBookmarkMovie: UnBookmarkMovieUseCase
) : BaseViewModel<MovieDetailUiEvent, MovieDetailUiModel>() {

    override suspend fun processUiEvent(uiEvent: MovieDetailUiEvent) {
        when (uiEvent) {
            is MovieDetailUiEvent.EnterScreen -> {
                handleEnterScreen(uiEvent)
            }
            is MovieDetailUiEvent.MovieFavoritedUiEvent -> {
                handleMovieFavorited(uiEvent)
            }
        }
    }

    private suspend fun handleEnterScreen(uiEvent: MovieDetailUiEvent.EnterScreen) {
        emitUiModel(MovieDetailUiModel(loading = true))
        val result = runCatching {
            getMovieDetail(uiEvent.movieId)
        }
        emitUiModel(
            MovieDetailUiModel(
                loading = false, movie = result.getOrNull(),
                error = result.exceptionOrNull()
            )
        )
    }

    private suspend fun handleMovieFavorited(uiEvent: MovieDetailUiEvent.MovieFavoritedUiEvent) {
        val result = runCatching {
            if (uiEvent.favorited) {
                bookmarkMovie(uiEvent.movie.id)
                uiEvent.movie.copy(isBookmarked = true)
            } else {
                unBookmarkMovie(uiEvent.movie.id)
                uiEvent.movie.copy(isBookmarked = false)
            }
        }
        emitUiModel(
            MovieDetailUiModel(
                movie = result.getOrNull(),
                error = result.exceptionOrNull()
            )
        )
    }
}

internal class MovieDetailUiModel(
    val loading: Boolean = false,
    val movie: MovieDetail? = null,
    error: Throwable? = null
) : UiModel(error)

internal sealed class MovieDetailUiEvent : UiEvent() {
    class EnterScreen(val movieId: Int) : MovieDetailUiEvent()
    data class MovieFavoritedUiEvent(
        val movie: MovieDetail,
        val favorited: Boolean
    ) : MovieDetailUiEvent()
}
