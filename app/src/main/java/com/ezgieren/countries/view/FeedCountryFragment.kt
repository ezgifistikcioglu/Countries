package com.ezgieren.countries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ezgieren.countries.adapter.CountryAdapter
import com.ezgieren.countries.databinding.FragmentFeedCountryBinding
import com.ezgieren.countries.viewmodel.FeedViewModel

class FeedCountryFragment : Fragment() {
    private lateinit var viewModel: FeedViewModel
    private var _binding: FragmentFeedCountryBinding? = null
    private val binding get() = _binding!!
    private lateinit var countryAdapter: CountryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFeedCountryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        viewModel.refreshFromAPI()

        countryAdapter = CountryAdapter(arrayListOf())

        binding.countryList.layoutManager = LinearLayoutManager(context)
        binding.countryList.adapter = countryAdapter

        binding.swipeRefresh.setOnRefreshListener {
            binding.countryList.visibility = View.GONE
            binding.errorText.visibility = View.GONE
            binding.countryLoading.visibility = View.VISIBLE
            viewModel.refreshData()
            binding.swipeRefresh.isRefreshing = false
        }
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.countries.observe(viewLifecycleOwner, Observer { countries ->
            countries?.let {
                binding.countryList.visibility = View.VISIBLE
                countryAdapter.updateCountryList(countries)
            }
        })

        viewModel.countryError.observe(viewLifecycleOwner, Observer { isError ->
            isError?.let {
                binding.errorText.visibility = if (it) View.VISIBLE else View.GONE
            }
        })

        viewModel.countryLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            isLoading?.let {
                binding.countryLoading.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    binding.errorText.visibility = View.GONE
                    binding.countryList.visibility = View.GONE
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}