package mohsin.reza.propertyapp.api


import android.arch.lifecycle.LiveData
import com.android.example.github.api.ApiResponse

import mohsin.reza.propertyapp.vo.Data
import mohsin.reza.propertyapp.vo.Property
import retrofit2.http.GET

interface PropertyAppServices {

    @GET("properties")
    fun getProperties() : LiveData<ApiResponse<Data>>
}
