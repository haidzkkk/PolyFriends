package com.fpoly.polyfriend.ui.security

import com.fpoly.polyfriend.core.PolyViewEvent

sealed class LoginViewEvent: PolyViewEvent {
    object ReturnFragmentViewEvent : LoginViewEvent()
    data class ToFragmentViewEvent(val id : Int) : LoginViewEvent()
}