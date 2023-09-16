package com.fpoly.polyfriend.data.repository

import com.fpoly.polyfriend.data.model.TokenResponse
import com.fpoly.polyfriend.data.network.AuthApi
import com.fpoly.polyfriend.ultis.getFakeTokenLogin
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class AuthRepository(
    private val api: AuthApi,
) {
    fun login(userName: String, password: String): Observable<TokenResponse>
            = getFakeTokenLogin().subscribeOn(Schedulers.io())
}