package mohsin.reza.hclpocapp.ui;


import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;


public class DataBoundViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    public final T binding;

    DataBoundViewHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
