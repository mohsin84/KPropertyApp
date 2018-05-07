package mohsin.reza.propertyapp.binding

import android.support.v4.app.Fragment
import android.databinding.DataBindingComponent

/**
 * Created by inteliment on 4/05/2018.
 */
class FragmentDataBindingComponent(fragment: Fragment) : DataBindingComponent {
    private val adapter = FragmentBindingAdapters(fragment)

    override fun getFragmentBindingAdapters() = adapter
}