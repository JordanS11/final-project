package com.northernwebtech.comp2430finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.northernwebtech.comp2430finalproject.databinding.MenuLayoutBinding


class menuFragment : Fragment(R.layout.menu_layout), View.OnClickListener{
    companion object{
        fun newInstance(): menuFragment{
            return menuFragment()
        }
    }
    private var _binding: MenuLayoutBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //val myView = inflater.inflate(R.layout.menu_layout, container, false)
        //val button = myView.findViewById<View>(R.id.reserveButton) as Button
       // val checkResButton = myView.findViewById<View>(R.id.myReservationButton) as Button
       _binding = MenuLayoutBinding.inflate(inflater, container, false)
        val myView = binding.root

        binding.reserveButton.setOnClickListener(this)
        binding.myReservationButton.setOnClickListener(this)
        return myView


    }


    override fun onClick(v: View?){
        val fManager = requireActivity().supportFragmentManager
        when(v!!.id) {
            R.id.reserveButton -> {

                fManager.beginTransaction().replace(R.id.fragmentContainerView, dateFragment()).addToBackStack(null).commit()
            }
            R.id.myReservationButton -> {
                fManager.beginTransaction().replace(R.id.fragmentContainerView, ShowReservationFragment()).addToBackStack(null).commit()
            }
        }
    }
}