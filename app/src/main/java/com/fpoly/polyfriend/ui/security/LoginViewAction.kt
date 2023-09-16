package com.fpoly.polyfriend.ui.security

import com.fpoly.polyfriend.core.PolyViewAction

sealed class LoginViewAction: PolyViewAction {
    object GetUserAction: LoginViewAction()
    data class LoginAction(val userName: String, val password: String): LoginViewAction()
}