package mohsin.reza.propertyapp.vo;

import android.arch.persistence.room.Embedded;

import com.google.gson.annotations.SerializedName;

public class Avatar {
    @SerializedName("url")
    public final String url;

    @SerializedName("small")
    @Embedded(prefix = "small_")
    public final Small small;

    @SerializedName("medium")
    @Embedded(prefix = "medium_")
    public final Small medium;

    @SerializedName("large")
    @Embedded(prefix = "large_")
    public final Small large;

    @SerializedName("profile")
    @Embedded(prefix = "profile_")
    public final Small profile;

    public Avatar(String url, Small small, Small medium, Small large, Small profile) {
        this.url = url;
        this.small = small;
        this.medium = medium;
        this.large = large;
        this.profile = profile;
    }

}
