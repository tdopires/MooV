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
package br.com.moov.app

import android.content.Context
import br.com.bookmark.movie.BookmarkExposedModule
import br.com.core.tmdb.TmdbModule
import br.com.moov.dibridge.CoreComponent
import br.com.moov.moviedetails.di.MovieDetailsExposedModule
import br.com.moov.movies.di.MoviesExposedModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        MoviesExposedModule::class,
        MovieDetailsExposedModule::class,
        BookmarkExposedModule::class,
        TmdbModule::class
    ]
)
@Singleton
interface AppComponent : CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}
