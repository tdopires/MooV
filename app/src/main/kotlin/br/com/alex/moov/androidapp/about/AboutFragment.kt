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

package br.com.alex.moov.androidapp.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.alex.moov.R
import br.com.alex.moov.androidapp.ApplicationComponent
import br.com.alex.moov.androidapp.base.BaseFragment
import br.com.alex.moov.androidapp.base.di.HasComponent
import br.com.alex.moov.androidapp.base.viewmodel.ViewModel
import br.com.alex.moov.androidapp.base.viewmodel.ViewModel.State
import br.com.alex.moov.androidapp.home.HomeComponent
import br.com.alex.moov.androidapp.logger.EventLogger
import br.com.alex.moov.databinding.FragmentAboutBinding
import javax.inject.Inject


class AboutFragment : BaseFragment() {

  @Inject lateinit var aboutViewModel: AboutViewModel

  @Inject lateinit var eventLogger: EventLogger

  override fun injectDependencies(applicationComponent: ApplicationComponent) {
    val activity = activity
    if (activity is HasComponent<*>) {
      val component = activity.getComponent()
      if (component is HomeComponent) {
        DaggerAboutComponent.builder()
            .homeComponent(component)
            .aboutModule(AboutModule())
            .build()
            .inject(this)
      }
    }
  }

  override fun createAndBindViewModel(root: View, savedViewModelState: State?): ViewModel {
    val binding = FragmentAboutBinding.bind(view)
    binding.viewModel = aboutViewModel
    return aboutViewModel
  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?) = inflater?.inflate(R.layout.fragment_about, container, false)

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    eventLogger.logContentView("About Screen")
  }
}