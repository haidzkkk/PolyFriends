package com.fpoly.polyfriends.ultis

import com.fpoly.polyfriends.data.model.TokenResponse
import io.reactivex.Observable

fun getFakeTokenLogin(): Observable<TokenResponse> {
    return Observable.just(TokenResponse("accessToken", "refreshTOken"))
}