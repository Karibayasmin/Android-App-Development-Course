package com.kariba.photoalbum.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.kariba.photoalbum.R
import com.kariba.photoalbum.databinding.ActivityDetailsBinding
import com.kariba.photoalbum.model.PhotoAlbum

class DetailsActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        var photoAlbum = intent.getSerializableExtra("photo_album") as? PhotoAlbum

        Glide
            .with(this)
            .load(photoAlbum?.downloadUrl)
            .into(binding.imageViewPhoto)

        binding.textViewDownloadUrlValue.text = photoAlbum?.downloadUrl
        binding.textViewWebsiteUrlValue.text = photoAlbum?.url

        binding.textViewDownloadUrlValue.setOnClickListener {
            openBrowser(photoAlbum?.downloadUrl ?: "")
        }

        binding.textViewWebsiteUrlValue.setOnClickListener {
            openBrowser(photoAlbum?.url ?: "")
        }

    }

    fun openBrowser(url : String){

        try {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)

        }catch (e : Exception){

        }

    }

}