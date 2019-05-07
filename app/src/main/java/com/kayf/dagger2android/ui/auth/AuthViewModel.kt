package com.kayf.dagger2android.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.kayf.dagger2android.SessionManager
import com.kayf.dagger2android.models.User
import com.kayf.dagger2android.network.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Khawar.habib on 2019-05-05.
 */
class AuthViewModel @Inject constructor(var authApi: AuthApi, var sessionManager: SessionManager) :
    ViewModel() {


    fun observeAuthState(): LiveData<AuthResource<User>> {
        return sessionManager.getAuthUser()
    }

    fun authenticateWithId(userId: Int) {
        sessionManager.authenticateWithId(queryWithUserId(userId))
    }


    fun queryWithUserId(userId: Int): LiveData<AuthResource<User>> {

        return LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(userId)

                .onErrorReturn {
                    User(-1)
                }
                .map {
                    if (it.id == -1) {
                        AuthResource.error("Something went wrong!", User(-1))
                    } else AuthResource.authenticated(it)

                }
                .subscribeOn(Schedulers.io())
        )
    }

}