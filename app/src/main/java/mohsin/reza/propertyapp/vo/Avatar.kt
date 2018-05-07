package mohsin.reza.propertyapp.vo

import android.arch.persistence.room.Embedded

import com.google.gson.annotations.SerializedName

data class Avatar(
        @field:SerializedName("url")
        val url: String,
        @field:SerializedName("small")
        @field:Embedded(prefix = "small_")
        val small: Small,
        @field:SerializedName("medium")
        @field:Embedded(prefix = "medium_")
        val medium: Small,
        @field:SerializedName("large")
        @field:Embedded(prefix = "large_")
        val large: Small,
        @field:SerializedName("profile")
        @field:Embedded(prefix = "profile_")
        val profile: Small?
)
