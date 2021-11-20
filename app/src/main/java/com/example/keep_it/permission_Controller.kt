package com.example.keep_it

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast
class permission_Controller(activity: Activity) {

    val permissionList= listOf<String>(android.Manifest.permission.READ_CONTACTS,android.Manifest.permission.CAMERA)
    private var activity:Activity?=null
   init
   {
       this.activity=activity
   }
    fun checkForPermission(name:String,permission: String,requestCode:Int)
    {
        Toast.makeText(activity as Activity,"check For Permission", Toast.LENGTH_LONG).show()
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {

            when
            {
                ContextCompat.checkSelfPermission(activity as Activity,permission)==PackageManager.PERMISSION_GRANTED->
                {

                    Toast.makeText(activity as Activity,"$name permission granted", Toast.LENGTH_LONG).show()
                }
                activity!!.shouldShowRequestPermissionRationale(permission) ->permission_Controller(activity as Activity).showDialog()
                else ->{
                    ActivityCompat.requestPermissions(activity as Activity,arrayOf(permission),requestCode)}
            }
        }

    }

    fun hasPermissions(context: Context, vararg permission: List<String>):Boolean=permissionList.all {
        ContextCompat.checkSelfPermission(
            activity as Activity,
            it,
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun showDialog() {
        val builder = AlertDialog.Builder(activity)
        builder.apply {
            setMessage("all Permission Access Required")
            setTitle("Permission required")
            setPositiveButton("ok")
            { dialog, which ->
                permission()
            }

        }
        val dialog: AlertDialog = builder.create()
        dialog.show()


    }
    fun permission() {
        var permission = permission_Controller(activity as Activity)
        if (!permission.hasPermissions(activity as Activity, permission.permissionList)) {
            ActivityCompat.requestPermissions(
                activity as Activity,
                permission.permissionList.toTypedArray(),12
            )
        }
    }



}