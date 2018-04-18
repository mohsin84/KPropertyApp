package mohsin.reza.propertyapp.api;

import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

import retrofit2.Response;

public class ApiResponse<T> { //Wrapper class to abstract retrofit call with body, http return code and error messages
    public final int code;
    @Nullable
    public final T body;
    @Nullable
    public final String errorMessage;

    public ApiResponse(Throwable error) {
        code = 500;
        body = null;
        errorMessage = error.getMessage();
    }

    public ApiResponse(Response<T> response) {
        code = response.code();
        if (response.isSuccessful()) {
            body = response.body();
            errorMessage = null;
        } else {
            String message = null;
            if (response.errorBody() != null) {
                try {
                    message = response.errorBody().string();
                } catch (IOException ignored) {
                    Log.v("ignored", "error while parsing response");
                }
            }
            if (message == null || message.trim().length() == 0) {
                message = response.message();
            }
            errorMessage = message;
            body = null;
        }//end of else
    }

    public boolean isSuccessful() {
        return code >= 200 && code < 300;
    }

}
