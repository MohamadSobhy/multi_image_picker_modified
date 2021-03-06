package com.vitanov.multiimagepicker.FishBunMod.java.com.sangcomz.fishbun

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.vitanov.multiimagepicker.FishBunMod.java.com.sangcomz.fishbun.adapter.image.ImageAdapter
import java.lang.ref.WeakReference

class FishBun private constructor(activity: Activity?, fragment: Fragment?) {

    private val _activity: WeakReference<Activity?> = WeakReference(activity)
    private val _fragment: WeakReference<Fragment?> = WeakReference(fragment)

    val fishBunContext: FishBunContext get() = FishBunContext()

    fun setImageAdapter(imageAdapter: ImageAdapter): FishBunCreator {
        val fishton = Fishton.apply {
            refresh()
            Fishton.imageAdapter = imageAdapter
        }
        return FishBunCreator(this, fishton)
    }

    companion object {
        const val FISHBUN_REQUEST_CODE = 27
        const val INTENT_PATH = "intent_path"

        @JvmStatic
        fun with(activity: Activity) = FishBun(activity, null)

        @JvmStatic
        fun with(fragment: Fragment) = FishBun(null, fragment)
    }

    inner class FishBunContext {
        private val activity = _activity.get()
        private val fragment = _fragment.get()
        fun getContext(): Context =
            activity ?: fragment?.context ?: throw NullPointerException("Activity or Fragment Null")

        fun startActivityForResult(intent: Intent, requestCode: Int) {
            when {
                activity != null -> activity.startActivityForResult(intent, requestCode)
                fragment != null -> fragment.startActivityForResult(intent, requestCode)
                else -> throw NullPointerException("Activity or Fragment Null")
            }
        }
    }
}


