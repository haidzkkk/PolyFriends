package com.fpoly.polyfriend.data.repository

import com.fpoly.polyfriend.data.model.User
import com.fpoly.polyfriend.data.network.UserApi
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import kotlin.random.Random

class HomeRepository @Inject constructor(
    private val api: UserApi
) {
    private var number = Random.nextInt()

    fun test(): Observable<String> {
        Thread.sleep(2000)
        return Observable.just("Repository test: $number")
    }

    fun getUsers(): Observable<List<User>> = api.getUser().subscribeOn(Schedulers.io())
}