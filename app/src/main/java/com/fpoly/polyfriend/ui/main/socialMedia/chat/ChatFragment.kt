package com.fpoly.polyfriend.ui.main.socialMedia.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fpoly.polyfriend.R
import com.fpoly.polyfriend.core.PolyBaseFragment
import com.fpoly.polyfriend.databinding.FragmentChatBinding

class ChatFragment : PolyBaseFragment<FragmentChatBinding>() {
    override fun invalidate() {
    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentChatBinding {
        return FragmentChatBinding.inflate(layoutInflater)
    }
}