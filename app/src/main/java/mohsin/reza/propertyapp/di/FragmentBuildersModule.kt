package mohsin.reza.propertyapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mohsin.reza.propertyapp.ui.PropertyFragment
import mohsin.reza.propertyapp.ui.TitleFragment

/**
 * Dagger Module for Fragment
 */

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributePropertyFragment(): PropertyFragment

    @ContributesAndroidInjector
    abstract fun contributeTitleFragment(): TitleFragment
}
