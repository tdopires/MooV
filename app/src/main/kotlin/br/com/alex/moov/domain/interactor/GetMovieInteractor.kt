/*
 *     Copyright 2017 Alex Almeida Tavella
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package br.com.alex.moov.domain.interactor

import br.com.alex.moov.data.tmdb.TMDBDApi
import br.com.alex.moov.domain.entity.Movie
import br.com.alex.moov.domain.mapper.MovieMapper
import io.reactivex.Single
import io.reactivex.functions.BiFunction

class GetMovieInteractor(
    private val tmdbdApi: TMDBDApi,
    private val getImageConfigurationsInteractor: GetImageConfigurationsInteractor,
    private val movieMapper: MovieMapper) {
  fun execute(movieId: Int): Single<Movie> {
    return getImageConfigurationsInteractor.execute()
        .zipWith(tmdbdApi.getMovie(movieId),
            BiFunction { imageConfigs, tmdbMovie -> movieMapper.map(tmdbMovie, imageConfigs) })
  }
}