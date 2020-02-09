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
package br.com.moov.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.moov.dibridge.coreComponent

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val moviesNavigator = coreComponent().moviesNavigator()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        moviesNavigator.openMoviesScreen(supportFragmentManager, R.id.container)
    }
}