package mohsin.reza.propertyapp.ui;


import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 *  Generic ViewHolder for DataBoundListAdapter
 * */
public class DataBoundViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    public final T binding;

    DataBoundViewHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
