package mohsin.reza.propertyapp.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.support.annotation.VisibleForTesting
import javax.inject.Inject

import mohsin.reza.propertyapp.repository.PropertyRepository
import mohsin.reza.propertyapp.util.AbsentLiveData
import mohsin.reza.propertyapp.vo.Property
import mohsin.reza.propertyapp.vo.Resource

class PropertyViewModel @Inject
constructor(propertyRepository: PropertyRepository) : ViewModel() {
    private val refresh = MutableLiveData<Boolean>()
    @get:VisibleForTesting
    //this return live data to observer in Fragment
    val propertyLiveData: LiveData<Resource<List<Property>>>

    init {
        propertyLiveData = Transformations.switchMap(refresh) { //Observing change of refresh param to get value from
            input ->
            // repository and deciding inside repository whether to call from netwok or get from db
            if (input == null) {
                 AbsentLiveData.create()       //if in any case refresh is null will show empty data
            } else
                 propertyRepository.getPropertyData(refresh.value) //Getting data from Repository
        }

    }

    @VisibleForTesting
    fun setRefresh(refresh: Boolean) {
        this.refresh.value = refresh             //Setting refresh liveData so that repo call inside PropertyViewModel
        // constructor can make call by listening to the change
    }
}
