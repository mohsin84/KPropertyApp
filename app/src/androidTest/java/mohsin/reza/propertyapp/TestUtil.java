package mohsin.reza.propertyapp;


import java.util.ArrayList;
import java.util.List;

import mohsin.reza.propertyapp.vo.Location;
import mohsin.reza.propertyapp.vo.Owner;
import mohsin.reza.propertyapp.vo.Photo;
import mohsin.reza.propertyapp.vo.Property;

public class TestUtil {
    final static int id = 1;

    public static List<Property> createProperties(int count) {
        List<Property> propertyList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Owner owner = new Owner(1 + i, "Adam" + i, "Smith" + i, "abc@gmail.com");
            Photo photo = new Photo(1 + i, false);

            Location location = new Location(1 + i, "71 York Street", "Level 2, Suite 201, SENTIA",
                    "Sydney", "NSW", "2000", "Australia", -33.2719708228076,
                    151.403204079771, "Sydney, NEW SOUTH WALES, 2000, Australia");

            propertyList.add(createProperty(1 + i, 1 + i, i % 2 == 0, "private", "Property " + i,
                    1 + i, 1 + i, 2, "Property description " + i, 100000.00 + i, owner,
                    location, photo));
        }
        return propertyList;
    }

    private static Property createProperty(int pid, Integer id, Boolean isPremium, String property_state, String title,
                                           Integer bedrooms, Integer bathrooms, Integer carspots, String description,
                                           Double price, Owner owner, Location location, Photo photo) {
        return new Property(pid, id, isPremium, property_state, title, bedrooms, bathrooms, carspots, description, price, owner, location, photo);
    }

}
