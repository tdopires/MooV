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
package br.com.moov.moviedetails.domain

internal data class MovieDetail(
    val id: Int,
    val title: String?,
    val posterUrl: String? = null,
    val overview: String? = null,
    val releaseDate: String? = null,
    val genres: List<String> = emptyList(),
    val originalLanguage: String? = null,
    val backdropUrl: String? = null,
    val popularity: Float = 0F,
    val voteAverage: Float = 0F,
    val isBookmarked: Boolean = false
)
