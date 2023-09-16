package com.fpoly.polyfriend.ui.security

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.activityViewModel
import com.fpoly.polyfriend.R
import com.fpoly.polyfriend.core.PolyBaseFragment
import com.fpoly.polyfriend.databinding.FragmentSigninBinding

class SigninFragment : PolyBaseFragment<FragmentSigninBinding>(){
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSigninBinding {
        return FragmentSigninBinding.inflate(layoutInflater)
    }

    val loginViewModel: LoginViewModel by activityViewModel()

    override fun invalidate() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        views.tvBack.setOnClickListener{
            loginViewModel.handleBackToFragment()
        }
    }

}
