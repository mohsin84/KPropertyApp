package mohsin.reza.propertyapp.vo;

import com.google.gson.annotations.SerializedName;

public class Small {
    @SerializedName("url")
    public final String url;

    public Small(String url) {
        this.url = url;
    }
}
