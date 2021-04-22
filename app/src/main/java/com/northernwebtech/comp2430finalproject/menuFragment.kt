package com.northernwebtech.comp2430finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.northernwebtech.comp2430finalproject.databinding.MenuLayoutBinding

//layout file added to the Fragment constructor
class menuFragment : Fragment(R.layout.menu_layout), View.OnClickListener{
    //create the variable used for the view binding within the fragment. uses a generated Binding class based on the layout file
    private var _binding: MenuLayoutBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //inflating the generated class so that it can be used
       _binding = MenuLayoutBinding.inflate(inflater, container, false)
        val myView = binding.root
        //setting on clicks to the buttons, 'this' refers to the included View.OnClickListener in the class
        binding.reserveButton.setOnClickListener(this)
        binding.myReservationButton.setOnClickListener(this)
        //shows the layout
        return myView
    }


    override fun onClick(v: View?){
        //set fragment manager to a val
        val fManager = requireActivity().supportFragmentManager
        when(v!!.id) {
            R.id.reserveButton -> {
                //when the reserve button is clicked, the transaction begins for the next step, choosing a date fragment
                //current fragment is also added to the back stack
                fManager.beginTransaction().replace(R.id.fragmentContainerView, dateFragment()).addToBackStack(null).commit()
            }
            R.id.myReservationButton -> {
                //if checking reservation button is clicked, the transaction for the show reservation fragment begins
                //current fragment is also added to the back stack
                fManager.beginTransaction().replace(R.id.fragmentContainerView, ShowReservationFragment()).addToBackStack(null).commit()
            }
        }
    }
}