package mohsin.reza.propertyapp.ui;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import mohsin.reza.propertyapp.R;
import mohsin.reza.propertyapp.databinding.PropertyItemBinding;
import mohsin.reza.propertyapp.util.Objects;
import mohsin.reza.propertyapp.vo.Property;

public class PropertyAdapter extends DataBoundListAdapter<Property, PropertyItemBinding> {

    private final DataBindingComponent dataBindingComponent;

    public PropertyAdapter(DataBindingComponent dataBindingComponent) {
        this.dataBindingComponent = dataBindingComponent;
    }

    @Override
    protected PropertyItemBinding createBinding(ViewGroup parent) {
        PropertyItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.property_item,
                parent, false, dataBindingComponent);
        return binding;
    }

    @Override
    protected void bind(PropertyItemBinding binding, Property property) {
        binding.setProperty(property);
    }

    @Override
    protected boolean areItemsTheSame(Property oldItem, Property newItem) {//avoid replacing same data
        return Objects.equals(oldItem.pid, newItem.pid);
    }

    @Override
    protected boolean areContentsTheSame(Property oldItem, Property newItem) { //avoid replacing same content
        return Objects.equals(oldItem.title, newItem.title);
    }
}
