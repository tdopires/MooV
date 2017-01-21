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

package br.com.alex.moov.domain.service

import br.com.alex.moov.api.tmdb.TMDBDApi
import br.com.alex.moov.domain.entity.Movie
import br.com.alex.moov.domain.mapper.MovieMapper
import rx.Single

class MovieService(val imageConfigurationsService: ImageConfigurationsService,
    val tmdbdApi: TMDBDApi, val movieMapper: MovieMapper) {
  fun discoverMovies(): Single<List<Movie>> {
    return imageConfigurationsService.retrieveImageConfigurations()
        .zipWith(tmdbdApi.discoverMovies().map { it.results }, { imageConfigs, tmdbMovies ->
          tmdbMovies.map {
            movieMapper.map(it, imageConfigs)
          }
        })
  }
}