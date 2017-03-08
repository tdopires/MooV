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

package br.com.alex.moov.androidapp.base.di

import android.content.Context
import br.com.alex.moov.androidapp.base.AttachedActivity
import dagger.Module
import dagger.Provides
import org.mockito.Mockito.mock
import javax.inject.Singleton


@Module
class TestApplicationModule {

  @Provides
  @Singleton
  fun provideAppContext(): Context = mock(Context::class.java)

  @Provides
  @Singleton
  fun provideAttachedActivity(): AttachedActivity = mock(AttachedActivity::class.java)
}