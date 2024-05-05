package com.kariba.photoalbum.Utils

import com.kariba.photoalbum.model.PhotoAlbum

interface OnItemClickListener {
    fun onClick(data: PhotoAlbum)
}