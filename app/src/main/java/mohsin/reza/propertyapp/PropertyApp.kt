package mohsin.reza.propertyapp

import android.app.Activity
import android.app.Application

import javax.inject.Inject

import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import mohsin.reza.propertyapp.di.AppInjector

class PropertyApp : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
        }
        AppInjector.init(this)
    }

    override fun activityInjector()= dispatchingAndroidInjector

}
