package mohsin.reza.propertyapp.di

import android.app.Application
import android.arch.persistence.room.Room
import com.android.example.github.util.LiveDataCallAdapterFactory

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import mohsin.reza.propertyapp.api.PropertyAppServices
import mohsin.reza.propertyapp.db.PropertyDB
import mohsin.reza.propertyapp.db.PropertyDao
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Dagger 2 Module for app. It provide Retrofit instance, Room Database instance and DataAccess Dao instance through out the app for injection
 */

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideHclService(): PropertyAppServices {
        return Retrofit.Builder()
                .baseUrl("http://demo0065087.mockable.io/test/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(PropertyAppServices::class.java)
    }

    @Singleton
    @Provides
    fun providesDB(application: Application): PropertyDB {
        return Room.databaseBuilder(application, PropertyDB::class.java, "propertyDb.db")
                .fallbackToDestructiveMigration()
                .build()
    }

    @Singleton
    @Provides
    fun providePropertyDao(db: PropertyDB): PropertyDao {
        return db.propertyDao()
    }
}
