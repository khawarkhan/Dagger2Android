package com.kayf.dagger2android.di.auth

import com.kayf.dagger2android.di.scopes.AuthScope
import com.kayf.dagger2android.network.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Khawar.habib on 2019-05-05.
 */
@Module
class AuthModule {

//    @AuthScope
    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }

}