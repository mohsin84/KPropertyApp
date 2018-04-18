package mohsin.reza.propertyapp.vo;


import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Ignore;

import com.google.gson.annotations.SerializedName;

public class Photo {
    @SerializedName("id")
    public final Integer photo_id;

    @SerializedName("default")
    public final Boolean flag;

    @SerializedName("image")
    @Embedded(prefix = "photo_")
    public final Avatar image;

    public Photo(Integer photo_id, Boolean flag, Avatar image) {
        this.photo_id = photo_id;
        this.flag = flag;
        this.image = image;
    }

    @Ignore
    public Photo(Integer photo_id, Boolean flag) {
        this.photo_id = photo_id;
        this.flag = flag;
        this.image = null;
    }
}
