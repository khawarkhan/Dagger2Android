package com.kayf.dagger2android.di

import androidx.lifecycle.ViewModelProvider
import com.kayf.dagger2android.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

/**
 *
 * This class provides Custom Factory module to support MultiBinding
 *
 * @Inject doesn't work with ViewModel's constructor out of the box, this way we can inject ViewModels
 *
 * Created by Khawar.habib on 2019-05-05.
 */

@Module
abstract class ViewModelFactoryModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(AuthViewModel::class)
//    abstract fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory): ViewModelProvider.Factory

}
