package mohsin.reza.propertyapp.api;


import android.arch.lifecycle.LiveData;

import mohsin.reza.propertyapp.vo.Data;
import retrofit2.http.GET;

public interface PropertyAppServices {

    @GET("properties")
    LiveData<ApiResponse<Data>> getProperties();
}
