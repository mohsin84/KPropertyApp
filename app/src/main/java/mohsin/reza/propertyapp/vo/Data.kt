package mohsin.reza.propertyapp.vo

import com.google.gson.annotations.SerializedName

data class Data(
        @field:SerializedName("data")
        val data: List<Property>
)
