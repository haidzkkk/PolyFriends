package com.fpoly.polyfriends.ui.security

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.fpoly.polyfriends.data.model.TokenResponse
import com.fpoly.polyfriends.data.model.User

data class LoginViewState(
    var asyncLogin: Async<TokenResponse> = Uninitialized,
    var asyncUserCurrent:Async<User> = Uninitialized
): MvRxState {
    fun isLoading() = asyncLogin is Loading ||  asyncUserCurrent is Loading
}