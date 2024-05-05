package com.kariba.profiledatasavetolocaldb

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.kariba.profiledatasavetolocaldb.databinding.ActivityMainLayoutBinding
import com.kariba.profiledatasavetolocaldb.preference.AppPreference
import com.kariba.profiledatasavetolocaldb.preference.AppPreference.Companion.MOBILE_NUMBER
import com.kariba.profiledatasavetolocaldb.preference.AppPreference.Companion.NAME
import com.kariba.profiledatasavetolocaldb.preference.AppPreference.Companion.PROFESSION
import com.kariba.profiledatasavetolocaldb.preference.AppPreferenceImpl

class MainActivity : ComponentActivity() {

    lateinit var binding : ActivityMainLayoutBinding
    lateinit var appPreference : AppPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainLayoutBinding.inflate(layoutInflater)
        appPreference = AppPreferenceImpl(this)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        binding.editTextName.setText(appPreference.getString(NAME))
        binding.editTextProfession.setText(appPreference.getString(PROFESSION))
        binding.editTextMobileNumber.setText(appPreference.getString(MOBILE_NUMBER))

        if(appPreference.getString(NAME).isNotEmpty()){
            binding.textViewNameFirstWord.text = appPreference.getString(NAME).get(0).toString()
        }


        binding.buttonSave.setOnClickListener {
            appPreference.saveString(NAME, binding.editTextName.text.toString())
            appPreference.saveString(PROFESSION, binding.editTextProfession.text.toString())
            appPreference.saveString(MOBILE_NUMBER, binding.editTextMobileNumber.text.toString())
        }

    }
}