package com.vitanov.multiimagepicker.FishBunMod.java.com.sangcomz.fishbun.ui.album.listener

import com.vitanov.multiimagepicker.FishBunMod.java.com.sangcomz.fishbun.ui.album.model.Album

interface AlbumClickListener {
    fun onAlbumClick(position: Int, album: Album)
}