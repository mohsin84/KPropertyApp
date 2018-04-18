package mohsin.reza.propertyapp.repository;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import mohsin.reza.propertyapp.AppExecutors;
import mohsin.reza.propertyapp.api.ApiResponse;
import mohsin.reza.propertyapp.api.PropertyAppServices;
import mohsin.reza.propertyapp.db.PropertyDB;
import mohsin.reza.propertyapp.db.PropertyDao;
import mohsin.reza.propertyapp.vo.Data;
import mohsin.reza.propertyapp.vo.Property;
import mohsin.reza.propertyapp.vo.Resource;

@Singleton
public class PropertyRepository {

    private final PropertyAppServices propertyAppServices;
    private final AppExecutors appExecutors;
    private final PropertyDB propertyDB;
    private final PropertyDao propertyDao;

    @Inject
    public PropertyRepository(PropertyAppServices propertyAppServices, AppExecutors appExecutors,
                              PropertyDB propertyDB, PropertyDao propertyDao) //here dagger is injecting retrofit.builder instance declared in appmodule
    {
        this.propertyAppServices = propertyAppServices;
        this.appExecutors = appExecutors;
        this.propertyDB = propertyDB;
        this.propertyDao = propertyDao;
    }

    public LiveData<Resource<List<Property>>> getPropertyData(Boolean refresh) {
        return new NetworkBoundResource<List<Property>, Data>(appExecutors) {

            @Override
            protected void saveCallResult(@NonNull Data item) {
                propertyDB.beginTransaction(); //Caching data in Room Database
                try {
                    propertyDao.insert(item.data);
                    propertyDB.setTransactionSuccessful();
                } finally {
                    propertyDB.endTransaction();
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<Property> data) {
                return data == null || data.isEmpty() || refresh; //data is empty or there is a refresh call will fetch from network.
                // Otherwise will get existing values from database and show
            }

            @NonNull
            @Override
            protected LiveData<List<Property>> loadFromDb() {
                return propertyDao.loadPropertyList();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<Data>> createCall() {
                return propertyAppServices.getProperties();    //Loading data from network using injected retrofit  instance
            }
        }.asLiveData();
    }
}
