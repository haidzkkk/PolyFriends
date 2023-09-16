package com.fpoly.polyfriend.ui.main.home

import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.fpoly.polyfriend.core.PolyBaseViewModel
import com.fpoly.polyfriend.data.network.RemoteDataSource
import com.fpoly.polyfriend.data.network.UserApi
import com.fpoly.polyfriend.data.repository.TestRepo

class TestViewModelMvRx(state: HomeViewState, private val repo: TestRepo)
    : PolyBaseViewModel<HomeViewState, HomeViewAction, HomeViewEvent>(state) {

    override fun handle(action: HomeViewAction) {
    }

    fun test() = "test"

    companion object : MvRxViewModelFactory<TestViewModelMvRx, HomeViewState> {
        override fun create(viewModelContext: ViewModelContext, state: HomeViewState): TestViewModelMvRx? {
            var repo : TestRepo = TestRepo(RemoteDataSource().buildApi(UserApi::class.java, viewModelContext.activity.applicationContext))
            return TestViewModelMvRx(state, repo)
        }
    }
}