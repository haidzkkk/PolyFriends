package com.fpoly.polyfriend.ui.main.home

import com.fpoly.polyfriend.core.PolyViewAction

sealed class HomeViewAction: PolyViewAction {
    object TestViewAction: HomeViewAction()
    object GetUserViewAction: HomeViewAction()
}