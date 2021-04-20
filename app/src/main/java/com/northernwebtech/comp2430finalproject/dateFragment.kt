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



class dateFragment : Fragment(R.layout.date_layout), View.OnClickListener, AdapterView.OnItemSelectedListener{
    companion object{
        fun newInstance(): dateFragment{
            return dateFragment()
        }
    }
    private var _binding: DateLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DateLayoutBinding.inflate(inflater, container, false)
        val myView = binding.root

        binding.DateButton.setOnClickListener(this)
        binding.guestSpinner.onItemSelectedListener = this

        ArrayAdapter.createFromResource(
            requireActivity().applicationContext,
            R.array.guests_array,
            android.R.layout.simple_spinner_item
        ).also { adapter -> adapter.setDropDownViewResource(R.layout.guest_spinner)
            binding.guestSpinner.adapter = adapter
        }



            return myView
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        binding.guestNumber.text = parent.getItemAtPosition(pos).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>) {

    }


     override fun onClick(v: View?){
         //at this supported API number, only these deprecated functions were available for getting hour and minute

         var h = binding.timePicker.getCurrentHour()
         if(h > 12){
             h -= 12
         }
         val hour = h.toString()
         val m = binding.timePicker.getCurrentMinute()
         val minute: String
         if(m < 10){
             minute = "0" + m.toString()
         }
         else{
             minute = m.toString()
         }
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
         val guests: String = binding.guestNumber.text.toString()
         //= binding.timePicker[Calendar.HOUR].toString() + ":" + binding.timePicker[Calendar.MINUTE].toString()
         time = hour + ":" + minute
         //date = month + "," + day
         date = month + "," + day
         setFragmentResult("timeKey", bundleOf("timeBundle" to time))
         setFragmentResult("dayKey", bundleOf("dayBundle" to date))
         setFragmentResult("guestKey", bundleOf("guestBundle" to guests))

         val fManager = requireActivity().supportFragmentManager
        fManager.beginTransaction().replace(R.id.fragmentContainerView, floorplanFragment()).addToBackStack(
            null
        ).commit()

    }


}


