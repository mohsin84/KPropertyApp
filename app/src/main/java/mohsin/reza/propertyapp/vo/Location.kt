package mohsin.reza.propertyapp.vo

import com.google.gson.annotations.SerializedName

data class Location(
        @field:SerializedName("id")
        val location_id: Int?,
        @field:SerializedName("address_1")
        val address_1: String,
        @field:SerializedName("address_2")
        val address_2: String,
        @field:SerializedName("suburb")
        val suburb: String, @field:SerializedName("state")
        val state: String,
        @field:SerializedName("postcode")
        val postcode: String,
        @field:SerializedName("country")
        val country: String,
        @field:SerializedName("latitude")
        val latitude: Double?,
        @field:SerializedName("longitude")
        val longitude: Double?,
        @field:SerializedName("full_address")
        val fullAddress: String
)
