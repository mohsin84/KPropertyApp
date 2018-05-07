package mohsin.reza.propertyapp.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import mohsin.reza.propertyapp.vo.Property

/*
* Room database entities and dao objects
* */

@Database(
        entities = [Property::class],
        version = 1,
        exportSchema = false
)
abstract class PropertyDB : RoomDatabase() {

    abstract fun propertyDao(): PropertyDao
}
