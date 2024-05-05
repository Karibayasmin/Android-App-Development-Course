package com.kariba.cardgenerator.activity

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.kariba.cardgenerator.R
import com.kariba.cardgenerator.databinding.ActivityCardPreviewBinding

class CardPreviewActivity : AppCompatActivity() {

    lateinit var binding: ActivityCardPreviewBinding

    var message: String = ""
    var name: String = ""
    var prayMessage: String = ""
    var isColor: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        setDataFromPreviousPage()

    }

    private fun setDataFromPreviousPage() {
        message = intent.extras?.getString("message", "") ?: ""
        name = intent.extras?.getString("name", "") ?: ""
        prayMessage = intent.extras?.getString("pray_message", "") ?: ""
        isColor = intent.extras?.getBoolean("color") ?: true

        binding.textViewMessage.text = message
        binding.textViewPrayMessage.text = prayMessage
        binding.textViewName.text = name

        if(isColor){

            binding.cardViewWishCard.setCardBackgroundColor(getColor(R.color.blue))
            binding.parentLayout.setBackgroundColor(getColor(R.color.blue_transparent))

        }else{

            binding.cardViewWishCard.setCardBackgroundColor(getColor(R.color.pink))
            binding.parentLayout.setBackgroundColor(getColor(R.color.pink_transparent))

        }


        Log.e("CardPreview", "$message, $name, $prayMessage, $isColor")
    }
}