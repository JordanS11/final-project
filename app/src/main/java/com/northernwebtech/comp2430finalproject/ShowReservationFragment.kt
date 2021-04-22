package com.northernwebtech.comp2430finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResultListener
import com.northernwebtech.comp2430finalproject.databinding.ShowReservationBinding

//layout file added to the Fragment constructor
class ShowReservationFragment: Fragment(R.layout.show_reservation){
    //create the variable used for the view binding within the fragment. Uses a generated Binding class based on the layout file
    private var _binding: ShowReservationBinding? = null
    private val binding get() = _binding!!
    //variable created for the result listener bundle
    var result: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //inflating the generated class so that it can be used
        _binding = ShowReservationBinding.inflate(inflater, container, false)
        val view = binding.root
        //listener functions each waiting for specific bundles that are sent from another fragment
        //these bundles are from the Confirmation Fragment and are identified by the key names
        //the information in the bundle is set the the result variable and then used for its intended purpose through view binding
        setFragmentResultListener("timeKeyC") { timeKeyC, bundle ->
            result = bundle.getString("timeBundleC")
            binding.timeTextC.text = result
        }

        setFragmentResultListener("dayKeyC") { dayKeyC, bundle ->
            result = bundle.getString("dayBundleC")
            binding.dateTextC.text = result
        }

        setFragmentResultListener("guestKeyC") { guestKeyC, bundle ->
            result = bundle.getString("guestBundleC")
            binding.guestTextC.text = result
        }

        setFragmentResultListener("tableKeyC") { tableKeyC, bundle ->
            result = bundle.getString("tableBundleC")
            binding.guestTextC.append(result)
        }

        //shows the layout
        return view
    }

}



