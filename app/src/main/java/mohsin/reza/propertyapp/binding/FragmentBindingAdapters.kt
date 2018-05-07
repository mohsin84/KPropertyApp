package mohsin.reza.propertyapp.binding

import android.content.Context
import android.databinding.BindingAdapter
import android.support.v4.app.Fragment
import android.widget.ImageView

import com.bumptech.glide.Glide

import javax.inject.Inject

class FragmentBindingAdapters @Inject constructor(internal val fragment: Fragment) {

    @BindingAdapter("imageUrl")
    fun bindImage(imageView: ImageView, url: String) { //to bind dynamic url in recyclerView
        Glide.with(fragment.activity!!.applicationContext)
                .load(url)
                .into(imageView)
    }

    @BindingAdapter("circleImageUrl")
    fun bindCircleImage(imageView: ImageView, url: String) { //to bind dynamic url in recyclerView
        val context = fragment.activity!!.applicationContext
        Glide.with(context)
                .load(url)
                .into(imageView)
    }
}
