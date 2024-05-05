package com.kariba.contactapp.interfaces

import com.kariba.contactapp.model.Contact

interface OnItemClickListener {
    fun onClick(data : Contact)
}