package mohsin.reza.propertyapp.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import mohsin.reza.propertyapp.ui.PropertyViewModel
import mohsin.reza.propertyapp.viewmodel.PropertyViewModelFactory

/**
 * ViewModel Module to use ViewModelKey to generate di code for ViewModels and factory
 */

@Suppress("unused")
@Module
internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PropertyViewModel::class)
    abstract fun bindPropertyViewModel(propertyViewModel: PropertyViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(propertyViewModelFactory: PropertyViewModelFactory): ViewModelProvider.Factory
}
