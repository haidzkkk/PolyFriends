package com.fpoly.polyfriend.ui.main.home

import com.fpoly.polyfriend.core.PolyViewEvent

sealed class HomeViewEvent : PolyViewEvent {
    object testViewEvent: HomeViewEvent()

}