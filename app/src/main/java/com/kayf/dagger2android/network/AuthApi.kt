package com.kayf.dagger2android.network

import com.kayf.dagger2android.models.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Khawar.habib on 2019-05-05.
 */

interface AuthApi {

    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Flowable<User>
}