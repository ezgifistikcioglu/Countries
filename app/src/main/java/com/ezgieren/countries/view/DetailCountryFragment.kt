package com.ezgieren.countries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ezgieren.countries.R
import com.ezgieren.countries.databinding.FragmentDetailCountryBinding
import com.ezgieren.countries.viewmodel.CountryViewModel

class DetailCountryFragment : Fragment() {

    private lateinit var viewModel: CountryViewModel

    private var countryUuid = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailCountryBinding.bind(view)

        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom()

        arguments?.let {
            countryUuid = DetailCountryFragmentArgs.fromBundle(it).countryUuid
        }
        observeLiveData(binding)
    }

    private fun observeLiveData(binding: FragmentDetailCountryBinding) {
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { countryLiveData->
            countryLiveData?.let {
                binding.countryName.text = countryLiveData.countryName
                binding.countryRegion.text = countryLiveData.countryRegion
                binding.countryCapital.text = countryLiveData.countryCapital
                binding.countryCurrency.text = countryLiveData.countryCurrency
                binding.countryLanguage.text = countryLiveData.countryLanguage
            }
        })
    }
}