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

package br.com.alex.moov.domain.repository

import android.content.SharedPreferences
import br.com.alex.moov.api.tmdb.model.ImageConfigurations
import com.google.gson.Gson
import rx.Single

class PreferenceImageConfigurationsRepository(val preferences: SharedPreferences,
    val gson: Gson) : Repository<ImageConfigurations> {

  companion object {
    val PREFERENCE_KEY_IMAGE_CONFIGURATIONS = "image_configs"
  }

  override fun load(): Single<ImageConfigurations> {
    return Single.just(preferences.getString(PREFERENCE_KEY_IMAGE_CONFIGURATIONS, null))
        .doOnSuccess { if (it == null) throw IllegalArgumentException() }
        .map { gson.fromJson(it, ImageConfigurations::class.java) }
  }

  override fun save(imageConfigurations: ImageConfigurations): Single<Boolean> {
    return Single.just(imageConfigurations)
        .map { gson.toJson(it) }
        .map { preferences.edit().putString(PREFERENCE_KEY_IMAGE_CONFIGURATIONS, it).commit() }
  }
}