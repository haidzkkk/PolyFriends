package com.fpoly.polyfriends.ui.main.home

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.fpoly.polyfriends.data.model.User

data class HomeViewState(
    var test : Async<String> = Uninitialized,
    var users : Async<List<User>> = Uninitialized
): MvRxState {
}