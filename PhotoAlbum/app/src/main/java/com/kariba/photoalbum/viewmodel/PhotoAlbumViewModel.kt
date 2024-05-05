package com.kariba.photoalbum.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kariba.photoalbum.model.PhotoAlbum
import com.kariba.photoalbum.model.PhotoAlbumList
import com.kariba.photoalbum.network.ApiClient
import com.kariba.photoalbum.network.ApiHandler
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable
import java.util.ArrayList

class PhotoAlbumViewModel : ViewModel() {

    var photoAlbumMutableLiveData = MutableLiveData<List<PhotoAlbum>>()

    fun getPhotoAlbumList(context: Context) : LiveData<List<PhotoAlbum>>{
        photoAlbumMutableLiveData = MutableLiveData()

        fetchPhotoAlbumList(context)

        return photoAlbumMutableLiveData
    }

    private fun fetchPhotoAlbumList(context: Context) {

        var call = ApiClient.retrofit.create(ApiHandler::class.java).getPhotoAlbumList()

        call.enqueue(object : Callback<List<PhotoAlbum>> {
            override fun onResponse(
                call: Call<List<PhotoAlbum>>,
                response: Response<List<PhotoAlbum>>
            ) {
                if(response.code() == 200){
                    setPhotoAlbumListData(response.body() ?: ArrayList())
                }
            }

            override fun onFailure(call: Call<List<PhotoAlbum>>, t: Throwable) {
                Log.e("photoAlbum", "${t.message}")
                Toast.makeText(context, "Something went wrong, Please try again ${t.message}", Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun setPhotoAlbumListData(data : List<PhotoAlbum>) {
        photoAlbumMutableLiveData.value = data
    }
}