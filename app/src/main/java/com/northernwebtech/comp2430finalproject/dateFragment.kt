package com.northernwebtech.comp2430finalproject




import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.northernwebtech.comp2430finalproject.databinding.DateLayoutBinding


//layout file added to the Fragment constructor
class dateFragment : Fragment(R.layout.date_layout), View.OnClickListener, AdapterView.OnItemSelectedListener{
    //create the variable used for the view binding within the fragment. Uses a generated Binding class based on the layout file
    private var _binding: DateLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //inflating the generated class so that it can be used
        _binding = DateLayoutBinding.inflate(inflater, container, false)
        val myView = binding.root
        //setting on click to the button, 'this' refers to the included View.OnClickListener in the class
        binding.DateButton.setOnClickListener(this)
        //setting on item selected (similar to on click) for the spinner
        binding.guestSpinner.onItemSelectedListener = this

        //creating the array adapter for the spinner, using the guests array from the guestAmount.xml
        ArrayAdapter.createFromResource(requireActivity().applicationContext, R.array.guests_array, android.R.layout.simple_spinner_item).also {
            //guest spinner styling from guest_spinner layout
            adapter -> adapter.setDropDownViewResource(R.layout.guest_spinner)
            //adapter set to the guest spinner
            binding.guestSpinner.adapter = adapter
        }


            //shows the layout
            return myView
    }
    //selection function for the guest number spinner
    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        //set the chosen value to a hidden text for use by fragment result functions inside of Onclick
        binding.guestNumber.text = parent.getItemAtPosition(pos).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        //nothing
    }


     override fun onClick(v: View?){
         //at this supported API number, only these deprecated functions were available for getting hour and minute
         var h = binding.timePicker.getCurrentHour()
         //format time to a 12 hour format
         if(h > 12){
             h -= 12
         }
         val hour = h.toString()
         val m = binding.timePicker.getCurrentMinute()
         val minute: String
         if(m < 10){
             //time display formatting
             minute = "0" + m.toString()
         }
         else{
             minute = m.toString()
         }
         var month = binding.datePicker.month.toString()
         //months in the picker are set to numeric values, changing to words
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
        //setting chosen dates and times to values to be sent to next fragment
         val day = binding.datePicker.dayOfMonth.toString()
         val time: String
         val date: String
         val guests: String = binding.guestNumber.text.toString()
         //display formatting
         time = hour + ":" + minute
         date = month + "," + day
         //bundles created for a later fragment to receive. identified by the key names, info from values time, date, and guests
         setFragmentResult("timeKey", bundleOf("timeBundle" to time))
         setFragmentResult("dayKey", bundleOf("dayBundle" to date))
         setFragmentResult("guestKey", bundleOf("guestBundle" to guests))

         val fManager = requireActivity().supportFragmentManager
        fManager.beginTransaction().replace(R.id.fragmentContainerView, floorplanFragment()).addToBackStack(null).commit()
    }
}