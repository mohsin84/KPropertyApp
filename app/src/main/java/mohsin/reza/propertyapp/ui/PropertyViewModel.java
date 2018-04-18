package mohsin.reza.propertyapp.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.VisibleForTesting;

import java.util.List;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import mohsin.reza.propertyapp.repository.PropertyRepository;
import mohsin.reza.propertyapp.util.AbsentLiveData;
import mohsin.reza.propertyapp.vo.Property;
import mohsin.reza.propertyapp.vo.Resource;

public class PropertyViewModel extends ViewModel {
    private final MutableLiveData<Boolean> refresh = new MutableLiveData<>();
    private LiveData<Resource<List<Property>>> propertyLiveData;

    @Inject
    public PropertyViewModel(PropertyRepository propertyRepository) {
        propertyLiveData = Transformations.switchMap(refresh, input -> { //Observing change of refresh param to get value from
            // repository and deciding inside repository whether to call from netwok or get from db
            if (input == null) {
                return AbsentLiveData.create();         //if in any case refresh is null will show empty data
            } else
                return propertyRepository.getPropertyData(refresh.getValue()); //Getting data from Repository
        });

    }

    @VisibleForTesting
    public void setRefresh(@Nonnull Boolean refresh) {
        this.refresh.setValue(refresh);             //Setting refresh liveData so that repo call inside PropertyViewModel
        // constructor can make call by listening to the change
    }

    @VisibleForTesting
    public LiveData<Resource<List<Property>>> getPropertyLiveData() {
        return propertyLiveData; //this return live data to observer in Fragment
    }
}
