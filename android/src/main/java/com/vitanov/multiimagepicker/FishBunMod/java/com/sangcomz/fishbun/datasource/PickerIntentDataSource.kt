package com.vitanov.multiimagepicker.FishBunMod.java.com.sangcomz.fishbun.datasource

import com.vitanov.multiimagepicker.FishBunMod.java.com.sangcomz.fishbun.ui.picker.model.AlbumData

interface PickerIntentDataSource {
    fun getAlbumData(): AlbumData?
}