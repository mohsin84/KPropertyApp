package mohsin.reza.propertyapp.repository

import android.arch.lifecycle.LiveData
import com.android.example.github.api.ApiResponse

import javax.inject.Inject
import javax.inject.Singleton

import mohsin.reza.propertyapp.AppExecutors
import mohsin.reza.propertyapp.api.PropertyAppServices
import mohsin.reza.propertyapp.db.PropertyDB
import mohsin.reza.propertyapp.db.PropertyDao
import mohsin.reza.propertyapp.vo.Data
import mohsin.reza.propertyapp.vo.Property
import mohsin.reza.propertyapp.vo.Resource

@Singleton
class PropertyRepository @Inject constructor(
        private val propertyAppServices: PropertyAppServices,
        private val appExecutors: AppExecutors,
        private val propertyDB: PropertyDB,
        private val propertyDao: PropertyDao) //here dagger is injecting retrofit.builder instance declared in appmodule
{
    fun getPropertyData(refresh: Boolean?): LiveData<Resource<List<Property>>> {
        return object : NetworkBoundResource<List<Property>, Data>(appExecutors) {

            override fun saveCallResult(item: Data) {
                propertyDB.beginTransaction() //Caching data in Room Database
                try {
                    propertyDao.insert(item.data)
                    propertyDB.setTransactionSuccessful()
                } finally {
                    propertyDB.endTransaction()
                }
            }

            override fun shouldFetch(data: List<Property>?): Boolean {
                return data == null || data.isEmpty() || refresh!! //data is empty or there is a refresh call will fetch from network.
                // Otherwise will get existing values from database and show
            }

            override fun loadFromDb() = propertyDao.loadPropertyList()

            override fun createCall() = propertyAppServices.getProperties()    //Loading data from network using injected retrofit  instance

        }.asLiveData()
    }
}
