package com.northernwebtech.comp2430finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.northernwebtech.comp2430finalproject.databinding.ConfirmationLayoutBinding
import java.util.*

//layout file added to the Fragment constructor
class confirmationFragment: Fragment(R.layout.confirmation_layout), View.OnClickListener {
    //create the variable used for the view binding within the fragment. Uses a generated Binding class based on the layout file
    private var _binding: ConfirmationLayoutBinding? = null
    private val binding get() = _binding!!
    //variable created for the result listener bundle
    var result: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //inflating the generated class so that it can be used
        _binding = ConfirmationLayoutBinding.inflate(inflater, container, false)
        val view = binding.root

        //listener functions each waiting for specific bundles that have been sent from another fragment
        //these bundles are from the date fragment and floorplan fragment, and are identified by their key names
        //the information in the bundle is set the the result variable and then used for its intended purpose through view binding
        setFragmentResultListener("timeKey"){
            timeKey, bundle -> result = bundle.getString("timeBundle")
            binding.timeText.append(" " + result)
        }

        setFragmentResultListener("dayKey"){
            dayKey, bundle -> result = bundle.getString("dayBundle")
            binding.dateText.append(" " + result)
        }

        setFragmentResultListener("guestKey"){
            guestKey, bundle -> result = bundle.getString("guestBundle")
            binding.guestText.append(" " + result)
            binding.guestText.append(" at ")
        }

        setFragmentResultListener("tableKey"){
            tableKey, bundle -> result = bundle.getString("tableBundle")
            binding.guestText.append(result)
        }

        //setting on click to the buttons, 'this' refers to the included View.OnClickListener in the class
        binding.cancelButton.setOnClickListener(this)
        binding.confirmButton.setOnClickListener(this)

        //show the layout
        return view
    }

    override fun onClick(v: View?){
        //button choice identified by the buttons id
        //both return user to the initial menu screen fragment and clear the back stack
        when(v!!.id){
            R.id.cancelButton -> {
                val fManager = requireActivity().supportFragmentManager
                fManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                fManager.beginTransaction().replace(R.id.fragmentContainerView, menuFragment()).addToBackStack(null).commit()
            }
            R.id.confirmButton -> {
                val time: String  = binding.timeText.text.toString()
                val date: String = binding.dateText.text.toString()
                val guests: String = binding.guestText.text.toString()
                //time, date, and guests info is sent in bundles for the show reservation to receive
                setFragmentResult("timeKeyC", bundleOf("timeBundleC" to time))
                setFragmentResult("dayKeyC", bundleOf("dayBundleC" to date))
                setFragmentResult("guestKeyC", bundleOf("guestBundleC" to guests))

                val fManager = requireActivity().supportFragmentManager
                fManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        fManager.beginTransaction().replace(R.id.fragmentContainerView, menuFragment()).addToBackStack(null).commit()
            }
        }
    }
}