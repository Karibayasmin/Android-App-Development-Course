package com.kariba.photoalbum.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PhotoAlbumList (

    var photoAlbumData : PhotoAlbumData? = PhotoAlbumData()

) : Serializable {

    data class PhotoAlbumData(

        var listOfPhoto : ArrayList<PhotoAlbum> = ArrayList()

    ) : Serializable
}

data class PhotoAlbum(
    @SerializedName("id")
    var id : String? = "",

    @SerializedName("author")
    var author : String? = "",

    @SerializedName("width")
    var width : Int? = 0,

    @SerializedName("height")
    var height : Int? = 0,

    @SerializedName("url")
    var url : String? = "",

    @SerializedName("download_url")
    var downloadUrl : String? = ""

) : Serializable