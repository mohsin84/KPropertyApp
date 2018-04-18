package mohsin.reza.propertyapp.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("data")
    public final List<Property> data;

    public Data(List<Property> data) {
        this.data = data;
    }
}
