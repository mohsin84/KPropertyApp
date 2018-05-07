package mohsin.reza.propertyapp.vo

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

import com.google.gson.annotations.SerializedName

import java.io.Serializable

@Entity(
        indices = (
           arrayOf(Index(value = "title", unique =true )))
)
//This PoJO is also entity for room database.
data class Property(
        @field:PrimaryKey(autoGenerate = true)
        val pid: Int,    //using auto generated key since id can be same
        @field:SerializedName("id")
        val id: Int?,
        @field:SerializedName("is_premium")
        val isPremium: Boolean,
        @field:SerializedName("state")
        val property_state: String,
        @field:SerializedName("title")
        val title: String,
        @field:SerializedName("bedrooms")
        val bedrooms: Int?,
        @field:SerializedName("bathrooms")
        val bathrooms: Int?,
        @field:SerializedName("carspots")
        val carspots: Int?,
        @field:SerializedName("description")
        val description: String,
        @field:SerializedName("price")
        val price: Double?,
        @field:SerializedName("owner")
        @field:Embedded
        val owner: Owner,
        @field:SerializedName("location")
        @field:Embedded
        val location: Location,
        @field:SerializedName("photo")
        @field:Embedded
        val photo: Photo) : Serializable
