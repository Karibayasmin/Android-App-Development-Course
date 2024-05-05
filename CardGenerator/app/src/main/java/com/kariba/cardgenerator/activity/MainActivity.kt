package com.kariba.cardgenerator.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Switch
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Switch
import com.kariba.cardgenerator.databinding.ActivityMainLayoutBinding

class MainActivity : ComponentActivity() {

    lateinit var binding : ActivityMainLayoutBinding

    var dataCheckBoxAddYourName : Boolean = false
    var dataCheckBoxPrayMessage : Boolean = false
    var isRadioCheckedBlue : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("MainActivity", "Enter in onCreate")

    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "Enter in onResume")

        toolbarViewShowHide()

        getChechBoxData()

        getRadioButtonData()


        binding.buttonPreview.setOnClickListener {
            if(isValid()){

                var intent = Intent(this, CardPreviewActivity::class.java)
                intent.putExtra("message", binding.editTextYourMessage.text.toString())
                intent.putExtra("name", binding.editTextName.text.toString())
                intent.putExtra("pray_message", binding.editTextPrayMessage.text.toString())
                intent.putExtra("color", isRadioCheckedBlue)
                startActivity(intent)

            }
        }

    }

    fun isValid() : Boolean {

        if(dataCheckBoxAddYourName == true && binding.editTextName.text.isNullOrEmpty()){

            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()

            return false
        }

        if(dataCheckBoxPrayMessage == true && binding.editTextPrayMessage.text.isNullOrEmpty()){

            Toast.makeText(this, "Please enter your pray message", Toast.LENGTH_SHORT).show()

            return false
        }

        return true
    }

    private fun getRadioButtonData() {
        isRadioCheckedBlue = binding.radioBlue.isChecked

        Log.e("radioButton", "0, $isRadioCheckedBlue")

        binding.radioGroupColor.setOnCheckedChangeListener { group, checkedId ->

            when(checkedId){

                binding.radioBlue.id -> {
                    isRadioCheckedBlue = true

                    Log.e("radioButton", "1, $isRadioCheckedBlue")

                }

                binding.radioPink.id -> {
                    isRadioCheckedBlue = false

                    Log.e("radioButton", "2, $isRadioCheckedBlue")

                }

            }

        }
    }

    private fun getChechBoxData() {
        dataCheckBoxAddYourName = binding.checkboxAddYourName.isChecked
        dataCheckBoxPrayMessage = binding.checkboxPrayMessage.isChecked

        binding.checkboxAddYourName.setOnCheckedChangeListener { buttonView, isChecked ->

            if(isChecked){
                dataCheckBoxAddYourName = binding.checkboxAddYourName.isChecked

            }else{
                dataCheckBoxAddYourName = binding.checkboxAddYourName.isChecked
            }

        }

        binding.checkboxPrayMessage.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                dataCheckBoxPrayMessage = binding.checkboxPrayMessage.isChecked

            }else{
                dataCheckBoxPrayMessage = binding.checkboxPrayMessage.isChecked
            }
        }
    }

    private fun toolbarViewShowHide() {
        binding.toolbarHome.imageViewBack.visibility = View.GONE
    }

    override fun onPause() {
        super.onPause()

        Log.d("MainActivity", "Enter in onPause")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("MainActivity", "Enter in onDestroy")
    }
}

