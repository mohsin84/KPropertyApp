package mohsin.reza.propertyapp.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import mohsin.reza.propertyapp.R;
import mohsin.reza.propertyapp.binding.FragmentDataBindingComponent;
import mohsin.reza.propertyapp.databinding.PropertyFragmentBinding;
import mohsin.reza.propertyapp.di.Injectable;
import mohsin.reza.propertyapp.util.AutoClearedValue;
import mohsin.reza.propertyapp.vo.Status;

public class PropertyFragment extends Fragment implements Injectable, PropertyAdapter.OnProItemClickListener {

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    public DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);

    @VisibleForTesting
    public AutoClearedValue<PropertyFragmentBinding> binding;
    AutoClearedValue<PropertyAdapter> adapter;
    private PropertyViewModel propertyViewModel;

    public static PropertyFragment create() {
        PropertyFragment propertyFragment = new PropertyFragment();
        return propertyFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        PropertyFragmentBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.property_fragment, container,
                false, dataBindingComponent);
        binding = new AutoClearedValue<>(this, dataBinding);
        return dataBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        propertyViewModel = ViewModelProviders.of(this, viewModelFactory).get(PropertyViewModel.class);
        PropertyAdapter propertyAdapter = new PropertyAdapter(dataBindingComponent, this);

        binding.get().propertyList.setAdapter(propertyAdapter); //setting adapter for recyclerList
        adapter = new AutoClearedValue<>(this, propertyAdapter);

        binding.get().swiperefresh.setOnRefreshListener(() -> {
            propertyViewModel.setRefresh(true); //To reload data from network otherwise it will just show existing data
            // from viewModel
            adapter.get().replace(null);
            getLiveDataFromViewModel();
        });

        propertyViewModel.setRefresh(false); //This is not a refresh call. So will make network call if data is empty
        binding.get().setCallback(() -> propertyViewModel.setRefresh(true)); //setting callback for retry layout
        binding.get().setLoadingStatus(true);           //To show Progress bar during data load

        getLiveDataFromViewModel();

    }

    private void getLiveDataFromViewModel() {
        propertyViewModel.getPropertyLiveData().observe(this, resourceRows -> { //Observing ViewModel

            binding.get().setResource(resourceRows);    //To decide whether to show retry layput or not
            binding.get().setLoadingStatus(Status.LOADING.equals(resourceRows.status));

            adapter.get().replace(resourceRows.data == null || resourceRows.data.size() == 0 ? null : resourceRows.data);   //replacing recyclerView data after check duplicate
            if (binding.get().swiperefresh.isRefreshing())
                binding.get().swiperefresh.setRefreshing(false);//once data stream is coming stop loading dialog
        });
    }

    @Override
    public void onPropertyClick(String property) {
        if (getActivity() instanceof BackToActivity) {
            ((BackToActivity) getActivity()).onBackToActivity(property);
        }
    }

    public interface BackToActivity {
        void onBackToActivity(String property);
    }
}
