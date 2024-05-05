package com.kariba.profiledatasavetolocaldb.preference

interface AppPreference {
    companion object{
        const val SHARED_PREFERENCE_TABLE_NAME = "profile_db"
        const val NAME = "name"
        const val PROFESSION = "profession"
        const val MOBILE_NUMBER = "mobile_number"
    }

    fun saveString(key : String, value: String)
    fun getString(key : String) : String

    fun saveInt(key: String, value: Int)
    fun getInt(key: String) : Int

}