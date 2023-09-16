package com.fpoly.polyfriends.ui.main.home

import com.fpoly.polyfriends.core.PolyViewEvent

sealed class HomeViewEvent : PolyViewEvent {
    object testViewEvent: HomeViewEvent()

}