package com.ezgieren.countries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ezgieren.countries.R

class FeedCountryFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*
        val button: Button = view.findViewById(R.id.fragment_feed_county_button)
        button.setOnClickListener {
            val action = FeedCountryFragmentDirections.actionFeedCountryFragmentToDetailCountryFragment()
            findNavController().navigate(action)
        }
        */
    }
}