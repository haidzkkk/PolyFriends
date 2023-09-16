package com.fpoly.polyfriends.ui.security

import com.fpoly.polyfriends.core.PolyViewAction

sealed class LoginViewAction: PolyViewAction {
    object GetUserAction: LoginViewAction()
    data class LoginAction(val userName: String, val password: String): LoginViewAction()
}