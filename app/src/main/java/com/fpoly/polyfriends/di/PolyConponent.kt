package com.fpoly.polyfriends.di

import android.content.Context
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.fpoly.polyfriends.PolyApplication
import com.fpoly.polyfriends.di.modules.FragmentModule
import com.fpoly.polyfriends.di.modules.NetworkModule
import com.fpoly.polyfriends.di.modules.ViewModelModule
import com.fpoly.polyfriends.ui.main.MainActivity
import com.fpoly.polyfriends.ui.main.profile.ProfileFragment
import com.fpoly.polyfriends.ui.security.LoginActivity
import com.fpoly.polyfriends.ui.security.LoginFragment
import com.fpoly.polyfriends.ui.security.SplashScreenActivity
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