package com.fpoly.polyfriends

import android.app.Application
import com.fpoly.polyfriends.di.DaggerPolyConponent
import com.fpoly.polyfriends.di.PolyConponent

class PolyApplication : Application() {

    val polyConponent: PolyConponent by lazy{
        DaggerPolyConponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()

        polyConponent.inject(this)
    }

}