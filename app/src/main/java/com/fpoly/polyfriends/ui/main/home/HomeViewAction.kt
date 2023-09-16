package com.fpoly.polyfriends.ui.main.home

import com.fpoly.polyfriends.core.PolyViewAction

sealed class HomeViewAction: PolyViewAction {
    object TestViewAction: HomeViewAction()
    object GetUserViewAction: HomeViewAction()
}