package com.fpoly.polyfriend.ui.security

import com.fpoly.polyfriend.core.PolyViewAction
import com.fpoly.polyfriend.core.PolyViewEvent
import com.fpoly.polyfriend.ui.main.home.HomeViewAction

sealed class LoginViewAction: PolyViewAction {
    object GetUserAction: LoginViewAction()
    data class LoginAction(val userName: String, val password: String): LoginViewAction()
}