package com.kayf.dagger2android.di.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kayf.dagger2android.di.ViewModelKey
import com.kayf.dagger2android.di.scopes.AuthScope
import com.kayf.dagger2android.ui.auth.AuthViewModel
import com.kayf.dagger2android.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Khawar.habib on 2019-05-05.
 */

@Module
abstract class AuthViewModelsModule {


    /**
     * AuthViewModelModule's work (instead of creating separate AuthViewModelModule, defined here)
     */
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel
}



