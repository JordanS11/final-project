package com.northernwebtech.comp2430finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResultListener
import com.northernwebtech.comp2430finalproject.databinding.ShowReservationBinding

class ShowReservationFragment: Fragment(R.layout.show_reservation){
    private var _binding: ShowReservationBinding? = null
    private val binding get() = _binding!!
    var result: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = ShowReservationBinding.inflate(inflater, container, false)
        val view = binding.root

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
            binding.guestTextC.append(" at ")
        }

        setFragmentResultListener("tableKeyC") { tableKeyC, bundle ->
            result = bundle.getString("tableBundleC")
            binding.guestTextC.append(result)
        }


        return view
    }

}



