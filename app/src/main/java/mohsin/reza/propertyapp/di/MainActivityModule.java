package mohsin.reza.propertyapp.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import mohsin.reza.propertyapp.MainActivity;
/*
 * Main Activity module with Fragment Builder submodule for Dagger to generate code from
 */

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}
