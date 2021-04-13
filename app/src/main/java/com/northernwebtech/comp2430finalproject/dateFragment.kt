package com.northernwebtech.comp2430finalproject


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import android.widget.TimePicker
import androidx.core.os.bundleOf
import androidx.core.view.get
import androidx.fragment.app.setFragmentResult
import com.northernwebtech.comp2430finalproject.databinding.DateLayoutBinding
import com.northernwebtech.comp2430finalproject.databinding.MenuLayoutBinding
import java.util.*

class dateFragment : Fragment(R.layout.date_layout), View.OnClickListener{
    companion object{
        fun newInstance(): dateFragment{
            return dateFragment()
        }
    }
    private var _binding: DateLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //val myView = inflater.inflate(R.layout.date_layout, container, false)
        //val tp1 = myView.findViewById<View>(R.id.timePicker) as TimePicker
        //val dateButton = myView.findViewById<View>(R.id.DateButton) as Button
        _binding = DateLayoutBinding.inflate(inflater, container, false)
        val myView = binding.root

        binding.DateButton.setOnClickListener(this)
        //var time: String
        //.setOnTimeChangedListener(TimePicker.OnTimeChangedListener {view: TimePicker?, hourOfDay: Int, minute: Int ->
            //time = "$hourOfDay:$minute"

          //  setFragmentResult("timeKey", bundleOf("timeBundle" to time))
        //})




        return myView
    }


     override fun onClick(v: View?){
         //at this supported API number, only these deprecated functions were available for getting hour and minute
         val h = binding.timePicker.getCurrentHour().toString()
         val m = binding.timePicker.getCurrentMinute().toString()
         var month = binding.datePicker.month.toString()
         when(month){
             "0" -> {
                 month = "January"
             }
             "1" -> {
                 month = "February"
             }
             "2" -> {
                 month = "March"
             }
             "3" -> {
                 month = "April"
             }
             "4" -> {
                 month = "May"
             }
             "5" -> {
                 month = "June"
             }
             "6" -> {
                 month = "July"
             }
             "7" -> {
                 month = "August"
             }
             "8" -> {
                 month = "September"
             }
             "9" -> {
                 month = "October"
             }
             "10" -> {
                 month = "November"
             }
             "11" -> {
                 month = "December"
             }
         }
         val day = binding.datePicker.dayOfMonth.toString()
         val time: String
         val date: String
         //= binding.timePicker[Calendar.HOUR].toString() + ":" + binding.timePicker[Calendar.MINUTE].toString()
         time = h + ":" + m
         //date = month + "," + day
         date = month + "," + day
         setFragmentResult("timeKey", bundleOf("timeBundle" to time))
         setFragmentResult("dayKey", bundleOf("dayBundle" to date))

         val fManager = requireActivity().supportFragmentManager
        fManager.beginTransaction().replace(R.id.fragmentContainerView, floorplanFragment()).addToBackStack(null).commit()

    }


}


