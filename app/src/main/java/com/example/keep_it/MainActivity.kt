package com.example.keep_it

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.support.v4.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        permission_Controller(this).permission()

    }



    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        var count=0
  for ( i in grantResults.indices)
      if(grantResults[i]==PackageManager.PERMISSION_DENIED) {
          count++
          super.onRequestPermissionsResult(requestCode, permissions, grantResults)
      }
        if(count==0)
        {

        }
        else
        {
            permission_Controller(this).showDialog()
//            startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
//                this.data = Uri.fromParts("package", packageName, null)
//            })
        }
    }
}








