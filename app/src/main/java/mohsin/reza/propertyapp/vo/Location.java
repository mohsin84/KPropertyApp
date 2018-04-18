package mohsin.reza.propertyapp.vo;

import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("id")
    public final Integer location_id;

    @SerializedName("address_1")
    public final String address_1;

    @SerializedName("address_2")
    public final String address_2;

    @SerializedName("suburb")
    public final String suburb;

    @SerializedName("state")
    public final String state;

    @SerializedName("postcode")
    public final String postcode;

    @SerializedName("country")
    public final String country;

    @SerializedName("latitude")
    public final Double latitude;

    @SerializedName("longitude")
    public final Double longitude;

    @SerializedName("full_address")
    public final String fullAddress;

    public Location(Integer location_id, String address_1, String address_2, String suburb, String state, String postcode, String country, Double latitude, Double longitude, String fullAddress) {
        this.location_id = location_id;
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.suburb = suburb;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.fullAddress = fullAddress;
    }
}
