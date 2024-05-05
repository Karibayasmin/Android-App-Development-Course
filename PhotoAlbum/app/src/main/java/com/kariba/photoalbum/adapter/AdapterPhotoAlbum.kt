package com.kariba.photoalbum.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kariba.photoalbum.Utils.OnItemClickListener
import com.kariba.photoalbum.databinding.ItemPhotoAlbumBinding
import com.kariba.photoalbum.model.PhotoAlbum

class AdapterPhotoAlbum : RecyclerView.Adapter<AdapterPhotoAlbum.PhotoAlbumViewHolder>() {

    var listOfPhoto : ArrayList<PhotoAlbum> = ArrayList()
    lateinit var context: Context

    var onItemClick : OnItemClickListener? = null
    fun setPhotoAlbumData(listOfPhoto : ArrayList<PhotoAlbum>){
        this.listOfPhoto = listOfPhoto
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAlbumViewHolder {
        context = parent.context
        val itemBinding = ItemPhotoAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PhotoAlbumViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return listOfPhoto.size
    }

    override fun onBindViewHolder(holder: PhotoAlbumViewHolder, position: Int) {
        holder.bindView(listOfPhoto[position], context, onItemClick)
    }

    class PhotoAlbumViewHolder(var itemBinding: ItemPhotoAlbumBinding) : RecyclerView.ViewHolder(itemBinding.root){

        fun bindView(photoAlbum: PhotoAlbum, context: Context, onItemClick: OnItemClickListener?) {

            itemBinding.textViewAuthorName.text = photoAlbum.author

            Glide
                .with(context)
                .load(photoAlbum.downloadUrl)
                .into(itemBinding.imageView)

            itemBinding.parentLayout.setOnClickListener {
                onItemClick?.onClick(photoAlbum)
            }


        }
    }
}