package com.northernwebtech.comp2430finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.northernwebtech.comp2430finalproject.databinding.FloorplanLayoutBinding

class floorplanFragment : Fragment(R.layout.floorplan_layout), View.OnClickListener {


    private var _binding: FloorplanLayoutBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        _binding = FloorplanLayoutBinding.inflate(inflater, container, false)
        val view = binding!!.root// !! to make sure not null

        binding!!.table1.setOnClickListener(this)
        binding!!.table2.setOnClickListener(this)
        binding!!.table3.setOnClickListener(this)
        binding!!.table4.setOnClickListener(this)
        binding!!.table5.setOnClickListener(this)
        binding!!.table6.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?){
        var result: String
        when (v!!.id){
            R.id.table1 ->{
                result = "Table 1"
                setFragmentResult("tableKey", bundleOf("tableBundle" to result))
                val fManager = requireActivity().supportFragmentManager
                fManager.beginTransaction().replace(R.id.fragmentContainerView, confirmationFragment()).addToBackStack(null).commit()
            }
            R.id.table2 ->{
                result = "Table 2"
                setFragmentResult("tableKey", bundleOf("tableBundle" to result))
                val fManager = requireActivity().supportFragmentManager
                fManager.beginTransaction().replace(R.id.fragmentContainerView, confirmationFragment()).addToBackStack(null).commit()
            }
            R.id.table3 ->{
                result = "Table 3"
                setFragmentResult("tableKey", bundleOf("tableBundle" to result))
                val fManager = requireActivity().supportFragmentManager
                fManager.beginTransaction().replace(R.id.fragmentContainerView, confirmationFragment()).addToBackStack(null).commit()
            }

            R.id.table4 ->{
                result = "Table 4"
                setFragmentResult("tableKey", bundleOf("tableBundle" to result))
                val fManager = requireActivity().supportFragmentManager
                fManager.beginTransaction().replace(R.id.fragmentContainerView, confirmationFragment()).addToBackStack(null).commit()
            }

            R.id.table5 ->{
                result = "Table 5"
                setFragmentResult("tableKey", bundleOf("tableBundle" to result))
                val fManager = requireActivity().supportFragmentManager
                fManager.beginTransaction().replace(R.id.fragmentContainerView, confirmationFragment()).addToBackStack(null).commit()
            }

            R.id.table6 ->{
                result = "Table 6"
                setFragmentResult("tableKey", bundleOf("tableBundle" to result))
                val fManager = requireActivity().supportFragmentManager
                fManager.beginTransaction().replace(R.id.fragmentContainerView, confirmationFragment()).addToBackStack(null).commit()
            }
        }
    }
}