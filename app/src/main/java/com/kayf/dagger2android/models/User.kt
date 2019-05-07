package com.kayf.dagger2android.models

/**
 * Created by Khawar.habib on 2019-05-05.
 */

data class User(var id: Int? = null, var name: String? = null, var email: String? = null, var website: String? = null) {
    constructor(userId: Int) : this(userId, null, null, null)
}