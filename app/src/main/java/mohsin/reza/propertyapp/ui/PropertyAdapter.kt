package mohsin.reza.propertyapp.ui

import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.example.github.ui.common.DataBoundListAdapter
import mohsin.reza.propertyapp.AppExecutors

import mohsin.reza.propertyapp.R
import mohsin.reza.propertyapp.databinding.PropertyItemBinding
import mohsin.reza.propertyapp.util.Objects
import mohsin.reza.propertyapp.vo.Property

class PropertyAdapter(
        private val dataBindingComponent: DataBindingComponent,
        appExecutors: AppExecutors,
        private val listener: OnProItemClickListener
) : DataBoundListAdapter<Property, PropertyItemBinding>(
        appExecutors = appExecutors,
        diffCallback = object : DiffUtil.ItemCallback<Property>() {
            override fun areItemsTheSame(oldItem: Property, newItem: Property): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Property, newItem: Property): Boolean {
                return oldItem.description == newItem.description
            }
        }
) {

    override fun createBinding(parent: ViewGroup): PropertyItemBinding {
        val binding = DataBindingUtil.
                inflate<PropertyItemBinding>(
                        LayoutInflater.from(parent.context),
                        R.layout.property_item,
                        parent,
                        false,
                        dataBindingComponent
                )
        binding.root.setOnClickListener { view -> listener.onPropertyClick(binding.property?.title?:"") }
        return binding
    }

    override fun bind(binding: PropertyItemBinding, property: Property) {
        binding.property = property
    }

    interface OnProItemClickListener {
        fun onPropertyClick(property: String)
    }
}
