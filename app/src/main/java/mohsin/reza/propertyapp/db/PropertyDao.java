package mohsin.reza.propertyapp.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import mohsin.reza.propertyapp.vo.Property;

@Dao
public abstract class PropertyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(List<Property> propertyList);


    @Query("Select * from Property")
    public abstract LiveData<List<Property>> loadPropertyList();
}
