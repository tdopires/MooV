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

package br.com.alex.moov.androidapp.list.tvshow

import android.content.Context
import android.databinding.ViewDataBinding
import android.view.View
import br.com.alex.moov.R
import br.com.alex.moov.androidapp.base.viewmodel.list.RecyclerViewViewModelAdapter
import br.com.alex.moov.databinding.GridItemTvShowBinding
import br.com.alex.moov.domain.entity.TvShow

open class TvShowAdapter(
    context: Context) : RecyclerViewViewModelAdapter<TvShow, TvShowItemViewModel>(
    context) {
  override fun getLayoutRes() = R.layout.grid_item_tv_show

  override fun createItemViewModel() = TvShowItemViewModel()

  override fun createBindingAndSetupViewModel(view: View,
      itemViewModel: TvShowItemViewModel): ViewDataBinding {
    val binding = GridItemTvShowBinding.bind(view)
    binding.viewModel = itemViewModel
    return binding
  }
}