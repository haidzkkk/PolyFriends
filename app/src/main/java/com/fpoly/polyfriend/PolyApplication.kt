package com.fpoly.polyfriend

import android.app.Application
import com.fpoly.polyfriend.di.DaggerPolyConponent
import com.fpoly.polyfriend.di.PolyConponent

class PolyApplication : Application() {

    val polyConponent: PolyConponent by lazy{
        DaggerPolyConponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()

        polyConponent.inject(this)
    }

}