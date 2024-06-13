package com.ezgieren.countries.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ezgieren.countries.databinding.ItemCountryRowBinding
import com.ezgieren.countries.model.Country
import com.ezgieren.countries.view.FeedCountryFragmentDirections

class CountryAdapter(private val countries: ArrayList<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(val binding: ItemCountryRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.binding.name.text = countries[position].countryName
        holder.binding.region.text = countries[position].countryRegion

        holder.itemView.setOnClickListener {
            val action = FeedCountryFragmentDirections.actionFeedCountryFragmentToDetailCountryFragment()
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = countries.size

    fun updateCountryList(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }
}