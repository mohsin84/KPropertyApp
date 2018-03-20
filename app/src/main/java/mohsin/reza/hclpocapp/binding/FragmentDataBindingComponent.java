package mohsin.reza.hclpocapp.binding;

import android.databinding.DataBindingComponent;
import android.support.v4.app.Fragment;


public class FragmentDataBindingComponent implements DataBindingComponent {
    private final FragmentBindingAdapters adapters;

    public FragmentDataBindingComponent(Fragment fragment) {
        this.adapters = new FragmentBindingAdapters(fragment);
    }

    @Override
    public FragmentBindingAdapters getFragmentBindingAdapters() {
        return adapters;
    }
}
