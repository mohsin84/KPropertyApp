package mohsin.reza.propertyapp.ui;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mohsin.reza.propertyapp.R;
import mohsin.reza.propertyapp.binding.FragmentDataBindingComponent;
import mohsin.reza.propertyapp.databinding.TitleFragmentBinding;
import mohsin.reza.propertyapp.di.Injectable;
import mohsin.reza.propertyapp.util.AutoClearedValue;

public class TitleFragment extends Fragment implements Injectable {

    public AutoClearedValue<TitleFragmentBinding> binding;
    DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);

    public static TitleFragment create(String property) {
        TitleFragment titleFragment = new TitleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("First", property);
        titleFragment.setArguments(bundle);
        return titleFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TitleFragmentBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.title_fragment, container,
                false, dataBindingComponent);
        binding = new AutoClearedValue<>(this, dataBinding);
        return dataBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String property = getArguments().getString("First");
        binding.get().setTproperty(property);
    }

}
