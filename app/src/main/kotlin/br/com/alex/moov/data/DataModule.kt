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

package br.com.alex.moov.data

import br.com.alex.moov.data.tmdb.ApiKeyQualifier
import br.com.alex.moov.data.tmdb.CacheDurationQualifier
import br.com.alex.moov.data.tmdb.TMDBApiKeyHolder
import br.com.alex.moov.data.tmdb.TMDBDApi
import br.com.alex.moov.data.tmdb.TMDBRequestInterceptor
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Singleton

@Module
class DataModule {

  companion object {
    val API_BASE_URL = "https://api.themoviedb.org"
  }

  @Provides @Singleton
  fun provideCache(@CacheDirQualifier cacheDir: File) = Cache(cacheDir, 10 * 1024 * 1024)

  @Provides @Singleton @ApiKeyQualifier
  fun provideApiKey() = TMDBApiKeyHolder().getApiKey()

  @Provides @Singleton @CacheDurationQualifier
  fun provideCacheDuration() = 86400

  @Provides
  fun providesNewGson() = Gson()

  @Provides @Singleton
  fun provideRequestInterceptor(@ApiKeyQualifier apiKey: String,
      @CacheDurationQualifier cacheDuration: Int) = TMDBRequestInterceptor(apiKey, cacheDuration)

  @Provides @Singleton
  fun provideOkHttpClient(cache: Cache, interceptor: TMDBRequestInterceptor): OkHttpClient =
      OkHttpClient().newBuilder()
          .cache(cache)
          .addInterceptor(interceptor)
          .build()

  @Provides @Singleton
  fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
  }

  @Provides @Singleton
  fun providesTMDBDiscoverService(retrofit: Retrofit): TMDBDApi = retrofit.create(
      TMDBDApi::class.java)
}