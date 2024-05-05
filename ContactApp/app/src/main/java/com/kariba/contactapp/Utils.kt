package com.kariba.contactapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.kariba.contactapp.model.Contact

object Utils {

    fun callFromDial(context: Context, data: Contact) {
        try {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${data.mobileNumber}")
            context.startActivity(intent)
        }catch (e : Exception){
            Toast.makeText(context, "No sim found", Toast.LENGTH_SHORT).show()
        }
    }

}