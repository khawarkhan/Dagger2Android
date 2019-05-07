package com.kayf.dagger2android.di

import android.app.Application
import com.kayf.dagger2android.BaseApplication
import com.kayf.dagger2android.SessionManager
import com.kayf.dagger2android.di.auth.AuthModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Khawar.habib on 2019-05-05.
 */


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        AppModule::class,
        AuthModule::class,
        ViewModelFactoryModule::class
    ]
)

interface AppComponent : AndroidInjector<BaseApplication> {

    fun sessionManager(): SessionManager

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}

