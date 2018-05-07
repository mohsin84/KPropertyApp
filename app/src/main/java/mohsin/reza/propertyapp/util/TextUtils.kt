package mohsin.reza.propertyapp.util


import mohsin.reza.propertyapp.vo.Location
import mohsin.reza.propertyapp.vo.Owner

 object TextUtils {

    fun getPropertyAddress(location: Location): String {
        return String.format("%s %s %s", location.address_1, location.address_2, location.fullAddress)
    }

    fun getOwnerFullName(owner: Owner): String {
        return String.format("%s %s", owner.firstName, owner.lastName)
    }
}
