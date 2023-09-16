package com.fpoly.polyfriends.ui.security

import com.fpoly.polyfriends.core.PolyViewEvent

sealed class LoginViewEvent: PolyViewEvent {
    object ReturnFragmentViewEvent : LoginViewEvent()
    data class ToFragmentViewEvent(val id : Int) : LoginViewEvent()
}