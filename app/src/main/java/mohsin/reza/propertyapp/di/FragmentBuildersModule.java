package mohsin.reza.propertyapp.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import mohsin.reza.propertyapp.ui.PropertyFragment;

/**
 * Dagger Module for Fragment
 * ***/

@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract PropertyFragment contributePropertyFragment();
}
