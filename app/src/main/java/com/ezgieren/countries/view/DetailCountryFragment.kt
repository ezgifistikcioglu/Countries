package com.ezgieren.countries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ezgieren.countries.R
import com.ezgieren.countries.databinding.FragmentDetailCountryBinding
import com.ezgieren.countries.viewmodel.CountryViewModel

class DetailCountryFragment : Fragment() {

    private lateinit var viewModel: CountryViewModel
    private var countryUuid = 0
    private lateinit var dataBinding: FragmentDetailCountryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail_country, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            countryUuid = DetailCountryFragmentArgs.fromBundle(it).countryUuid
        }

        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom(countryUuid)

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { countryLiveData ->
            countryLiveData?.let {
                dataBinding.selectedCountryDetail = countryLiveData
                /*
                binding.countryName.text = countryLiveData.countryName
                binding.countryRegion.text = countryLiveData.countryRegion
                binding.countryCapital.text = countryLiveData.countryCapital
                binding.countryCurrency.text = countryLiveData.countryCurrency
                binding.countryLanguage.text = countryLiveData.countryLanguage
                context?.let {
                    binding.countryFlagImage.downloadFromUrl(
                        countryLiveData.countryImageUrl,
                        placeholderProgressBar(it)
                    )
                }
                */
            }
        })
    }
}