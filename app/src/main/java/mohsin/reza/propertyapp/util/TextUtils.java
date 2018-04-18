package mohsin.reza.propertyapp.util;


import mohsin.reza.propertyapp.vo.Location;
import mohsin.reza.propertyapp.vo.Owner;

public class TextUtils {

    public static String GetPropertyAddress(Location location) {
        return String.format("%s %s %s", location.address_1, location.address_2, location.fullAddress);
    }

    public static String GetOwnerFullName(Owner owner) {
        return String.format("%s %s", owner.firstName, owner.lastName);
    }
}
