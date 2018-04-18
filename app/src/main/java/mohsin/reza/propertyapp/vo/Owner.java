package mohsin.reza.propertyapp.vo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Ignore;

import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("url")
    public final Integer owner_id;

    @SerializedName("first_name")
    public final String firstName;

    @SerializedName("last_name")
    public final String lastName;

    @SerializedName("email")
    public final String email;

    @SerializedName("avatar")
    @Embedded(prefix = "owner_")
    public final Avatar avatar;

    public Owner(Integer owner_id, String firstName, String lastName, String email, Avatar avatar) {
        this.owner_id = owner_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avatar = avatar;
    }
    @Ignore
    public Owner(Integer owner_id, String firstName, String lastName, String email) { //For testing only
        this.owner_id = owner_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avatar = null;
    }
}
