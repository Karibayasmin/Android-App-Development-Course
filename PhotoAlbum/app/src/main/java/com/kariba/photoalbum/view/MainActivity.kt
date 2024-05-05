package com.kariba.photoalbum.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.kariba.photoalbum.Utils.OnItemClickListener
import com.kariba.photoalbum.adapter.AdapterPhotoAlbum
import com.kariba.photoalbum.databinding.ActivityMainLayoutBinding
import com.kariba.photoalbum.model.PhotoAlbum
import com.kariba.photoalbum.model.PhotoAlbumList
import com.kariba.photoalbum.viewmodel.PhotoAlbumViewModel

class MainActivity : ComponentActivity() {

    lateinit var binding : ActivityMainLayoutBinding

    private val photoAlbumViewModel by viewModels<PhotoAlbumViewModel>()

    lateinit var photoAlbumAdapter : AdapterPhotoAlbum

    var listOfPhoto : ArrayList<PhotoAlbum> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()

        setRecyclerView()

        getPhotoAlbumList()

        setOnclickItem()


    }

    private fun setOnclickItem() {
        photoAlbumAdapter.onItemClick = object : OnItemClickListener{
            override fun onClick(data: PhotoAlbum) {

                Log.e("onClick", "$data")

                val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                val bundle = Bundle()
                bundle.putSerializable("photo_album", data)
                intent.putExtras(bundle)
                startActivity(intent)

            }

        }
    }

    private fun getPhotoAlbumList() {

        photoAlbumViewModel.getPhotoAlbumList(this).observe(this, object : Observer<List<PhotoAlbum>>{
            override fun onChanged(data: List<PhotoAlbum>) {

                listOfPhoto.clear()
                listOfPhoto.addAll(data)

                photoAlbumAdapter.setPhotoAlbumData(listOfPhoto)

            }

        })

    }

    private fun setRecyclerView() {
        photoAlbumAdapter = AdapterPhotoAlbum()
        binding.recyclerViewPhotoAlbum.adapter = photoAlbumAdapter
    }
}