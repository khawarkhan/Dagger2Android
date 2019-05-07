package com.kayf.dagger2android.di.scopes

import javax.inject.Scope
import java.lang.annotation.Documented
import java.lang.annotation.Retention

import java.lang.annotation.RetentionPolicy.RUNTIME

@Scope
@Documented
@Retention(RUNTIME)
annotation class AuthScope
