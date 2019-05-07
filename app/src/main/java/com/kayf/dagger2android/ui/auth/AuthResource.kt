package com.kayf.dagger2android.ui.auth

/**
 * Created by Khawar.habib on 2019-05-05.
 */

public data class AuthResource<T>(var status: AuthStatus?, var data: T?, var message: String?) {


    public enum class AuthStatus {
        AUTHENTICATED, ERROR, LOADING, NOT_AUTHENTICATED
    }

    companion object {

        @JvmStatic
        fun <T> authenticated(data: T?): AuthResource<T> {
            return AuthResource(AuthStatus.AUTHENTICATED, data, null)
        }

        @JvmStatic
        fun <T> error(msg: String, data: T?): AuthResource<T> {
            return AuthResource(AuthStatus.ERROR, data, msg)
        }

//        @JvmStatic
        fun <T> loading(data: T): AuthResource<T> {
            return AuthResource(AuthStatus.LOADING, data, null)
        }

        @JvmStatic
        fun <T> logout(): AuthResource<T> {
            return AuthResource(AuthStatus.NOT_AUTHENTICATED, null, null)
        }

    }
}
