package mohsin.reza.propertyapp.vo

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Ignore

import com.google.gson.annotations.SerializedName

data class Owner (
    @SerializedName("id")
    val owner_id: Int?,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("email")
    val email: String?,
    @SerializedName("avatar")
    @Embedded(prefix = "owner_")
    val avatar: Avatar?
)
