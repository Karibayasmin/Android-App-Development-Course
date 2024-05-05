package com.kariba.contactapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.kariba.contactapp.Utils.callFromDial
import com.kariba.contactapp.adapter.AdapterContactList
import com.kariba.contactapp.databinding.ActivityMainLayoutBinding
import com.kariba.contactapp.interfaces.OnItemClickListener
import com.kariba.contactapp.model.Contact

class MainActivity : ComponentActivity() {

    lateinit var binding : ActivityMainLayoutBinding
    lateinit var adapterContactList: AdapterContactList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        setRecyclerView()
        setDataOnClick()

    }

    private fun setDataOnClick() {
        adapterContactList.onItemClick = object : OnItemClickListener{
            override fun onClick(data: Contact) {

                Log.e("onClick", "$data")
                callFromDial(this@MainActivity, data)

            }

        }
    }

    private fun setRecyclerView() {
        var contactList : ArrayList<Contact> = ArrayList()

        contactList.add(Contact("Kariba", "017000000000"))
        contactList.add(Contact("Kariba Yasmin", "017000000001"))
        contactList.add(Contact("Mrs Kariba", "017000000004"))
        contactList.add(Contact("Student 1", "017000000002"))
        contactList.add(Contact("Student 2", "017000000006"))
        contactList.add(Contact("Kariba", "017000000000"))
        contactList.add(Contact("Kariba Yasmin", "017000000001"))
        contactList.add(Contact("Mrs Kariba", "017000000004"))
        contactList.add(Contact("Student 1", "017000000002"))
        contactList.add(Contact("Student 2", "017000000006"))
        contactList.add(Contact("Kariba", "017000000000"))
        contactList.add(Contact("Kariba Yasmin", "017000000001"))
        contactList.add(Contact("Mrs Kariba", "017000000004"))
        contactList.add(Contact("Student 1", "017000000002"))
        contactList.add(Contact("Student 2", "017000000006"))
        contactList.add(Contact("Kariba", "017000000000"))
        contactList.add(Contact("Kariba Yasmin", "017000000001"))
        contactList.add(Contact("Mrs Kariba", "017000000004"))
        contactList.add(Contact("Student 1", "017000000002"))
        contactList.add(Contact("Student 2", "017000000006"))

        adapterContactList = AdapterContactList()

        binding.recyclerView.adapter = adapterContactList
        adapterContactList.setContactData(contactList)
    }
}