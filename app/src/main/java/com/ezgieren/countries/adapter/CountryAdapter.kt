package com.ezgieren.countries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ezgieren.countries.R
import com.ezgieren.countries.databinding.ItemCountryRowBinding
import com.ezgieren.countries.model.Country
import com.ezgieren.countries.view.FeedCountryFragmentDirections

class CountryAdapter(private val countries: ArrayList<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(), CountryClickListener {

    class CountryViewHolder(val bindingView: ItemCountryRowBinding) : RecyclerView.ViewHolder(bindingView.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
       // val binding = ItemCountryRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemCountryRowBinding>(inflater, R.layout.item_country_row,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        /*
        holder.bindingView.name.text = countries[position].countryName
        holder.bindingView.region.text = countries[position].countryRegion

        holder.itemView.setOnClickListener {
            val action = FeedCountryFragmentDirections.actionFeedCountryFragmentToDetailCountryFragment(countries[position].uuid)
            it.findNavController().navigate(action)
        }
        holder.bindingView.imageView.downloadFromUrl(
            countries[position].countryImageUrl,
            placeholderProgressBar(holder.itemView.context)
        )
         */
        holder.bindingView.country = countries[position]
        holder.bindingView.listener = this
        holder.bindingView.root.tag = countries[position]  // Set the tag for the root view
    }

    override fun getItemCount() = countries.size

    fun updateCountryList(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    override fun onCountryClicked(view: View) {
        val country = view.tag as Country
        val action = FeedCountryFragmentDirections.actionFeedCountryFragmentToDetailCountryFragment(country.uuid)
        Navigation.findNavController(view).navigate(action)
    }
}