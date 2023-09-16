package com.fpoly.polyfriends.data.network

import com.fpoly.polyfriends.data.model.User
import io.reactivex.Observable
import retrofit2.http.GET

interface UserApi {

    @GET("user")
    fun getUser(): Observable<List<User>>
}