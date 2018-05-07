package mohsin.reza.propertyapp.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

import mohsin.reza.propertyapp.vo.Property

@Dao
abstract class PropertyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(propertyList: List<Property>)


    @Query("Select * from Property")
    abstract fun loadPropertyList(): LiveData<List<Property>>
}
