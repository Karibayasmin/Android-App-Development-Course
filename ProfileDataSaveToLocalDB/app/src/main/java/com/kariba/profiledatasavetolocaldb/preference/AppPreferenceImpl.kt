package com.kariba.profiledatasavetolocaldb.preference

import android.content.Context
import com.kariba.profiledatasavetolocaldb.preference.AppPreference.Companion.SHARED_PREFERENCE_TABLE_NAME

class AppPreferenceImpl(context: Context) : AppPreference {

    var sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_TABLE_NAME, Context.MODE_PRIVATE)
    var editor = sharedPreferences.edit()
    override fun saveString(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    override fun getString(key: String): String {
        return sharedPreferences.getString(key, "") ?: ""
    }

    override fun saveInt(key: String, value: Int) {
        editor.putInt(key, value)
        editor.apply()
    }

    override fun getInt(key: String): Int {
        return sharedPreferences.getInt(key, -1)
    }
}