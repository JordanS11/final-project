package com.northernwebtech.comp2430finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResultListener
import com.northernwebtech.comp2430finalproject.databinding.ConfirmationLayoutBinding
import java.util.*

class confirmationFragment: Fragment(R.layout.confirmation_layout), View.OnClickListener {
    private var _binding: ConfirmationLayoutBinding? = null
    private val binding get() = _binding!!
    var result: String? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = ConfirmationLayoutBinding.inflate(inflater, container, false)
        val view = binding.root
        setFragmentResultListener("tableKey"){
            tableKey, bundle -> result = bundle.getString("tableBundle")
            //table number for removing table availabilty
        }

        setFragmentResultListener("timeKey"){
            timeKey, bundle -> result = bundle.getString("timeBundle")
            binding.timeText.append(result)
        }

        setFragmentResultListener("dayKey"){
            dayKey, bundle -> result = bundle.getString("dayBundle")
            binding.dateText.append(result)
        }


        //binding.dateText.append(result)
        binding.cancelButton.setOnClickListener(this)
        binding.confirmButton.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?){
        when(v!!.id){
            R.id.cancelButton -> {
                val fManager = requireActivity().supportFragmentManager
                fManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                fManager.beginTransaction().replace(R.id.fragmentContainerView, menuFragment()).addToBackStack(null).commit()
            }
            R.id.confirmButton -> {
                val fManager = requireActivity().supportFragmentManager
                fManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        fManager.beginTransaction().replace(R.id.fragmentContainerView, menuFragment()).addToBackStack(null).commit()


            }
        }
    }
}