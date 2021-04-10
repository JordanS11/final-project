package com.northernwebtech.comp2430finalproject


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import android.widget.TimePicker

class dateFragment : Fragment(R.layout.date_layout), View.OnClickListener{
    companion object{
        fun newInstance(): dateFragment{
            return dateFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val myView = inflater.inflate(R.layout.date_layout, container, false)
        val tp1 = myView.findViewById<View>(R.id.timePicker) as TimePicker
        val dateButton = myView.findViewById<View>(R.id.DateButton) as Button
        dateButton.setOnClickListener(this)





        return myView
    }


    override fun onClick(v: View?){
        val fManager = requireActivity().supportFragmentManager
        fManager.beginTransaction().replace(R.id.fragmentContainerView, floorplanFragment()).addToBackStack(null).commit()

    }
}