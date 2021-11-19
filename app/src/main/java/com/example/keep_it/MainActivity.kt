package com.example.keep_it

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun checkPermission()
    {

    }
   override fun onRequestPermissionsResult(requestCode:Int ,permissions: Array<String>,
                                           grantResults: IntArray)
   {

   }
}