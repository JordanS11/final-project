package com.northernwebtech.comp2430finalproject


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.room.Room


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        val currentFrag = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)

        if(currentFrag == null){//only runs if not active
            val fragment1 = menuFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, fragment1).commit()//show fragment
        }
    }
}