package mohsin.reza.hclpocapp.binding;

import android.databinding.BindingAdapter;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import mohsin.reza.hclpocapp.R;

public class FragmentBindingAdapters {
    final Fragment fragment;

    @Inject
    public FragmentBindingAdapters(Fragment fragment) {
        this.fragment = fragment;
    }

    @BindingAdapter("imageUrl")
    public void bindImage(ImageView imageView, String url) {
        Glide.with(fragment.getActivity().getApplicationContext()).load(url).error(R.drawable.ic_launcher_foreground)
                .override(80, 60).centerCrop().into(imageView);
    }
}
