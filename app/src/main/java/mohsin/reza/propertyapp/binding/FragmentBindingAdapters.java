package mohsin.reza.propertyapp.binding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

public class FragmentBindingAdapters {
    final Fragment fragment;

    @Inject
    public FragmentBindingAdapters(Fragment fragment) {
        this.fragment = fragment;
    }

    @BindingAdapter("imageUrl")
    public void bindImage(ImageView imageView, String url) { //to bind dynamic url in recyclerView
        Glide.with(fragment.getActivity().getApplicationContext())
                .load(url)
                .centerCrop()
                .into(imageView);
    }

    @BindingAdapter("circleImageUrl")
    public void bindCircleImage(ImageView imageView, String url) { //to bind dynamic url in recyclerView
        Context context = fragment.getActivity().getApplicationContext();
        Glide.with(context)
                .load(url)
                .centerCrop()
                .into(imageView);
    }
}
