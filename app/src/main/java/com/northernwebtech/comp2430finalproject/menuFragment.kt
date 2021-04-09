package com.northernwebtech.comp2430finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment




class menuFragment : Fragment(R.layout.menu_layout), View.OnClickListener{
    companion object{
        fun newInstance(): menuFragment{
            return menuFragment()
        }
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val myView = inflater.inflate(R.layout.menu_layout, container, false)
        val button = myView.findViewById<View>(R.id.reserveButton) as Button
       button.setOnClickListener(this)

        return myView


    }


    override fun onClick(v: View?){
        val fManager = requireActivity().supportFragmentManager
        fManager.beginTransaction().replace(R.id.fragmentContainerView, dateFragment()).addToBackStack(null).commit()

    }
}