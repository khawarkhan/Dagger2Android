package com.kayf.dagger2android

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.kayf.dagger2android.models.User
import com.kayf.dagger2android.ui.auth.AuthResource
import java.security.CodeSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Khawar.habib on 2019-05-05.
 */

@Singleton
class SessionManager @Inject constructor() {

    private val TAG = "SessionManager"

    var cachedUser: MediatorLiveData<AuthResource<User>> = MediatorLiveData()

    fun authenticateWithId(source: LiveData<AuthResource<User>>) {

//        todo check this place
        cachedUser.value = AuthResource.loading(User(-1))
        cachedUser.addSource(source) { userAuthResource ->
            cachedUser.value = userAuthResource
            cachedUser.removeSource(source)
        }
    }

    fun logOut() {
        Log.d(TAG, "logOut: logging out...")
        cachedUser.value = AuthResource.logout()
    }


    fun getAuthUser(): LiveData<AuthResource<User>> {
        return cachedUser
    }
}