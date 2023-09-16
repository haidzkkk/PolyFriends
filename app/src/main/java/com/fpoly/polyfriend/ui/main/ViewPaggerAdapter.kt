package com.fpoly.polyfriend.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fpoly.polyfriend.ui.main.chat.ChatFragment
import com.fpoly.polyfriend.ui.main.home.HomeFragment
import com.fpoly.polyfriend.ui.main.profile.ProfileFragment

class ViewPaggerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle)
    : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return ChatFragment()
            1 -> return HomeFragment()
            2 -> return ProfileFragment()
        }
        return HomeFragment();
    }

}