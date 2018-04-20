package mohsin.reza.propertyapp.vo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(indices = {@Index(value = {"title"}, unique = true)})
//This PoJO is also entity for room database.
public class Property implements Serializable{

    @PrimaryKey(autoGenerate = true)
    public final int pid;    //using auto generated key since id can be same

    @SerializedName("id")
    public final Integer id;

    @SerializedName("is_premium")
    public final boolean isPremium;

    @SerializedName("state")
    public final String property_state;

    @SerializedName("title")
    public final String title;

    @SerializedName("bedrooms")
    public final Integer bedrooms;

    @SerializedName("bathrooms")
    public final Integer bathrooms;

    @SerializedName("carspots")
    public final Integer carspots;

    @SerializedName("description")
    public final String description;

    @SerializedName("price")
    public final Double price;

    @SerializedName("owner")
    @Embedded
    public final Owner owner;

    @SerializedName("location")
    @Embedded
    public final Location location;

    @SerializedName("photo")
    @Embedded
    public final Photo photo;

    public Property(int pid, Integer id, boolean isPremium, String property_state, String title, Integer bedrooms, Integer bathrooms,
                    Integer carspots, String description, Double price, Owner owner, Location location, Photo photo) {
        this.pid = pid;
        this.id = id;
        this.isPremium = isPremium;
        this.property_state = property_state;
        this.title = title;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.carspots = carspots;
        this.description = description;
        this.price = price;
        this.owner = owner;
        this.location = location;
        this.photo = photo;
    }
}
