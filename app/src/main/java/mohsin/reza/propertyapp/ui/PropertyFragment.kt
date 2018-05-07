package mohsin.reza.propertyapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mohsin.reza.propertyapp.AppExecutors
import mohsin.reza.propertyapp.R
import mohsin.reza.propertyapp.binding.FragmentDataBindingComponent
import mohsin.reza.propertyapp.databinding.PropertyFragmentBinding
import mohsin.reza.propertyapp.di.Injectable
import mohsin.reza.propertyapp.util.autoCleared
import mohsin.reza.propertyapp.vo.Status
import javax.inject.Inject

class PropertyFragment : Fragment(), Injectable, PropertyAdapter.OnProItemClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appExecutors: AppExecutors

    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    @VisibleForTesting
    var binding by autoCleared<PropertyFragmentBinding>()

    private var adapter by autoCleared<PropertyAdapter>()

    lateinit var propertyViewModel: PropertyViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.property_fragment, container, false, dataBindingComponent)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        propertyViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(PropertyViewModel::class.java)
        val propertyAdapter = PropertyAdapter(dataBindingComponent, appExecutors, this)

        binding.propertyList.adapter = propertyAdapter //setting adapter for recyclerList
        this.adapter=propertyAdapter

        binding.swiperefresh.setOnRefreshListener {
            propertyViewModel.setRefresh(true) //To reload data from network otherwise it will just show existing data
            // from viewModel
            getLiveDataFromViewModel()
        }

        propertyViewModel.setRefresh(false) //This is not a refresh call. So will make network call if data is empty
        binding.callback = object : RetryCallback {
            override fun retry() {
                propertyViewModel.setRefresh(true)
            }
        }
        binding.loadingStatus = true           //To show Progress bar during data load

        getLiveDataFromViewModel()
    }

    private fun getLiveDataFromViewModel() {
        propertyViewModel.propertyLiveData.observe(this, Observer { resourceRows ->
            binding.resource = resourceRows
            binding.loadingStatus = (Status.LOADING == resourceRows?.status ?: false)

            if (resourceRows?.data != null) {
                adapter.submitList(resourceRows.data)
            }
            else {
                adapter.submitList(emptyList())
            }

            if (binding.swiperefresh.isRefreshing) {
                binding.swiperefresh.isRefreshing = false
            }
        })
    }

    override fun onPropertyClick(property: String) {
        if (activity is BackToActivity) {
            (activity as BackToActivity).onBackToActivity(property)
        }
    }

    interface BackToActivity {
        fun onBackToActivity(property: String)
    }

    companion object {

        fun create(): PropertyFragment {
            return PropertyFragment()
        }
    }
}
