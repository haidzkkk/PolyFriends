package com.fpoly.polyfriend.di

import android.content.Context
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.fpoly.polyfriend.PolyApplication
import com.fpoly.polyfriend.di.modules.FragmentModule
import com.fpoly.polyfriend.di.modules.NetworkModule
import com.fpoly.polyfriend.di.modules.ViewModelModule
import com.fpoly.polyfriend.ui.main.MainActivity
import com.fpoly.polyfriend.ui.main.profile.ProfileFragment
import com.fpoly.polyfriend.ui.security.LoginActivity
import com.fpoly.polyfriend.ui.security.LoginFragment
import com.fpoly.polyfriend.ui.security.SplashScreenActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [
    ViewModelModule::class,
    NetworkModule::class,
    FragmentModule::class
])
interface PolyConponent {

    fun inject(application: PolyApplication)
    fun inject(activity: SplashScreenActivity)
    fun inject(activity: MainActivity)
    fun inject(activity: LoginActivity)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: ProfileFragment)

    fun fragmentFactory(): FragmentFactory
    fun viewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): PolyConponent
    }
}