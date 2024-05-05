package com.kariba.photoalbum.network

import com.kariba.photoalbum.model.PhotoAlbumList
import com.kariba.photoalbum.Utils.EndPoint.GET_PHOTO_ALBUM_LIST
import com.kariba.photoalbum.model.PhotoAlbum
import retrofit2.Call
import retrofit2.http.GET

interface ApiHandler {
    @GET(GET_PHOTO_ALBUM_LIST)
    fun getPhotoAlbumList() : Call<List<PhotoAlbum>>
}