package mohsin.reza.propertyapp.vo


import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Ignore

import com.google.gson.annotations.SerializedName

class Photo (
    @SerializedName("id")
    val photo_id: Int?,
    @SerializedName("default")
    val flag: Boolean?,
    @SerializedName("image")
    @Embedded(prefix = "photo_")
    val image: Avatar?
)
