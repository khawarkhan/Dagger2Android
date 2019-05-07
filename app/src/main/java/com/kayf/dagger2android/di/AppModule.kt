package com.kayf.dagger2android.di

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.kayf.dagger2android.di.auth.AuthViewModelsModule
import com.kayf.dagger2android.utils.Constants
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.random.Random
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


/**
 * Created by Khawar.habib on 2019-05-05.
 */

@Module(includes = [AuthViewModelsModule::class ])
class AppModule {


//    @Provides
//    fun provideAuthApi(retrofit: Retrofit): AuthApi {
//        return retrofit.create(AuthApi::class.java)
//    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    internal fun providesInterceptor(): Interceptor {

        return Interceptor { chain ->
            val request = chain.request()
            println(
                String.format(
                    "\nrequest:\n%s\nheaders:\n%s", request.body().toString(), request.headers()
                )
            )
            chain.proceed(request)
        }
    }

    @Singleton
    @Provides
    internal fun provideRetrofitLogginMechanism(interceptor: Interceptor): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        httpClient.addInterceptor(interceptor)
        return httpClient.build()
    }

    @Singleton
    @Provides
    internal fun provideRequestOptions(): RequestOptions {
        return RequestOptions()
//            .placeholderOf(R.drawable.ic_launcher_background)
//            .error(R.drawable.ic_launcher_background)
    }

    @Singleton
    @Provides
    internal fun providesGlideInstance(application: Application, requestOptions: RequestOptions): RequestManager {
        return Glide.with(application).setDefaultRequestOptions(requestOptions)
    }

    @Singleton
    @Provides
    fun getInteger(): Int {
        return Random.nextInt(10)
    }
}