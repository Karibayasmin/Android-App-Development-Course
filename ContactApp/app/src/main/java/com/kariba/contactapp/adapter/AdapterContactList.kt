package com.kariba.contactapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kariba.contactapp.databinding.ItemContactLayoutBinding
import com.kariba.contactapp.interfaces.OnItemClickListener
import com.kariba.contactapp.model.Contact

class AdapterContactList : RecyclerView.Adapter<AdapterContactList.AdapterContactListViewHolder>(){

    var listOfContact : ArrayList<Contact> = ArrayList()

    var onItemClick : OnItemClickListener? = null
    fun setContactData(listOfContact : ArrayList<Contact>){
        this.listOfContact = listOfContact
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterContactListViewHolder {
        var itemBinding = ItemContactLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return AdapterContactListViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return listOfContact.size
    }

    override fun onBindViewHolder(holder: AdapterContactListViewHolder, position: Int) {
        holder.bindView(listOfContact[position], onItemClick)
    }

    class AdapterContactListViewHolder(var itemBinding: ItemContactLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bindView(contact: Contact, onItemClick: OnItemClickListener?) {

            itemBinding.textViewName.text = contact.name
            itemBinding.textViewMobileNumber.text = contact.mobileNumber

            itemBinding.cardViewParent.setOnClickListener {
                onItemClick?.onClick(contact)
            }

        }

    }
}