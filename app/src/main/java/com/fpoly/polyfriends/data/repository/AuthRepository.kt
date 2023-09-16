package com.fpoly.polyfriends.data.repository

import com.fpoly.polyfriends.data.model.TokenResponse
import com.fpoly.polyfriends.data.network.AuthApi
import com.fpoly.polyfriends.ultis.getFakeTokenLogin
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class AuthRepository(
    private val api: AuthApi,
) {
    fun login(userName: String, password: String): Observable<TokenResponse>
            = getFakeTokenLogin().subscribeOn(Schedulers.io())
}