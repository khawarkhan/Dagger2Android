package com.kayf.dagger2android.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass
import kotlin.annotation.MustBeDocumented
import kotlin.annotation.Retention

/**
 * Created by Khawar.habib on 2019-05-05.
 */

//@Documented
//@Target({ElementType.METHOD})
//@Retention(RetentionPolicy.RUNTIME)
// public interface ViewModelKey {

//}

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention
@MapKey
 annotation class ViewModelKey(val value: KClass<out ViewModel>)