package com.cris.myapplication

import android.content.Context
import android.widget.Toast

class Utils {
    //palabra reservada
    companion object{
        fun showToast(context: Context, msn: String){
            Toast.makeText(context,msn,Toast.LENGTH_LONG).show()
        }
    }
}