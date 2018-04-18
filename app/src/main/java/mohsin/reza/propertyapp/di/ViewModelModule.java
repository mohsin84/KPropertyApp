package mohsin.reza.propertyapp.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import mohsin.reza.propertyapp.ui.PropertyViewModel;
import mohsin.reza.propertyapp.viewmodel.PropertyViewModelFactory;

/**
 * ViewModel Module to use ViewModelKey to generate di code for ViewModels and factory
 **/

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PropertyViewModel.class)
    abstract ViewModel bindPropertyViewModel(PropertyViewModel propertyViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(PropertyViewModelFactory propertyViewModelFactory);
}
