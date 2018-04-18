package mohsin.reza.propertyapp.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mohsin.reza.propertyapp.api.PropertyAppServices;
import mohsin.reza.propertyapp.db.PropertyDB;
import mohsin.reza.propertyapp.db.PropertyDao;
import mohsin.reza.propertyapp.util.LiveDataCallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Dagger 2 Module for app. It provide Retrofit instance, Room Database instance and DataAccess Dao instance through out the app for injection
 */

@Module(includes = ViewModelModule.class)
class AppModule {
    @Singleton
    @Provides
    PropertyAppServices provideHclService() {
        return new Retrofit.Builder()
                .baseUrl("http://demo0065087.mockable.io/test/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build()
                .create(PropertyAppServices.class);
    }

    @Singleton
    @Provides
    PropertyDB providesDB(Application application) {
        return Room.databaseBuilder(application, PropertyDB.class, "propertyDb.db").fallbackToDestructiveMigration().build();
    }

    @Singleton
    @Provides
    PropertyDao providePropertyDao(PropertyDB db) {
        return db.propertyDao();
    }
}
