package mohsin.reza.propertyapp.ui

import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import mohsin.reza.propertyapp.R
import mohsin.reza.propertyapp.binding.FragmentDataBindingComponent
import mohsin.reza.propertyapp.databinding.PropertyFragmentBinding
import mohsin.reza.propertyapp.databinding.TitleFragmentBinding
import mohsin.reza.propertyapp.di.Injectable
import mohsin.reza.propertyapp.util.autoCleared

class TitleFragment : Fragment(), Injectable {

    var binding by autoCleared<TitleFragmentBinding>()
    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<TitleFragmentBinding>(inflater, R.layout.title_fragment,
                container, false, dataBindingComponent)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val property = arguments?.getString("First")
        binding.tproperty = property
    }

    companion object {
        fun create(property: String): TitleFragment {
            val titleFragment = TitleFragment()
            val bundle = Bundle()
            bundle.putString("First", property)
            titleFragment.arguments = bundle
            return titleFragment
        }
    }

}
