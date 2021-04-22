package com.northernwebtech.comp2430finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.northernwebtech.comp2430finalproject.databinding.FloorplanLayoutBinding

//layout file added to the Fragment constructor
class floorplanFragment : Fragment(R.layout.floorplan_layout), View.OnClickListener {
    //create the variable used for the view binding within the fragment.
    //Uses a generated Binding class based on the layout file
    private var _binding: FloorplanLayoutBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        //inflating the generated class so that it can be used
        _binding = FloorplanLayoutBinding.inflate(inflater, container, false)
        val view = binding!!.root// !! to make sure not null

        //setting on clicks to the tables as buttons, 'this' refers to the included View.OnClickListener in the class
        binding!!.table1.setOnClickListener(this)
        binding!!.table2.setOnClickListener(this)
        binding!!.table3.setOnClickListener(this)
        binding!!.table4.setOnClickListener(this)
        binding!!.table5.setOnClickListener(this)
        binding!!.table6.setOnClickListener(this)

        //shows the layout
        return view
    }

    override fun onClick(v: View?){
        var result: String
        //chosen table button is identified by the buttons id
        //different information is set to the bundle depending on chosen table
        //transaction is then started for the confirmation fragment
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