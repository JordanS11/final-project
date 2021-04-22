package com.northernwebtech.comp2430finalproject



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inflate initial fragment and add it to view
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, menuFragment()).commit()
    }
}