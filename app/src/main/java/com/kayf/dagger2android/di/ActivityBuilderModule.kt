package com.kayf.dagger2android.di

import com.kayf.dagger2android.di.auth.AuthModule
import com.kayf.dagger2android.di.auth.AuthViewModelsModule
import com.kayf.dagger2android.ui.auth.AuthActivity
import com.kayf.dagger2android.di.scopes.AuthScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Khawar.habib on 2019-05-05.
 */

@Module
abstract class ActivityBuilderModule {

    /**
     * ContributesAndroidInjector works as a subcomponent, any module defined here would have life span of equal
     * to it's activity/fragment's -  if Custom scope is defined i.e @AuthScope
     */
    @AuthScope
    @ContributesAndroidInjector(modules = [AuthViewModelsModule::class, AuthModule::class])
    abstract fun contributeAuthActivity(): AuthActivity
}