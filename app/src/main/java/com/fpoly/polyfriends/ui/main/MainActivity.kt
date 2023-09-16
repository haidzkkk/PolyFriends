package com.fpoly.polyfriends.ui.main

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.airbnb.mvrx.viewModel
import com.fpoly.polyfriends.PolyApplication
import com.fpoly.polyfriends.R
import com.fpoly.polyfriends.core.PolyBaseActivity
import com.fpoly.polyfriends.databinding.ActivityMainBinding
import com.fpoly.polyfriends.ui.main.home.HomeViewModel
import com.fpoly.polyfriends.ui.main.home.HomeViewState
import com.fpoly.polyfriends.ui.main.home.TestViewModel
import com.fpoly.polyfriends.ui.main.home.TestViewModelMvRx
import javax.inject.Inject


class MainActivity : PolyBaseActivity<ActivityMainBinding>(), HomeViewModel.Factory {

    @Inject
    lateinit var homeViewModelFactory: HomeViewModel.Factory
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val homeViewModel: HomeViewModel by viewModel()
    private val testViewModel : TestViewModel by lazy{ viewModelProvider.get(TestViewModel::class.java) }
    private val testViewModelMvRx: TestViewModelMvRx by viewModel()

    var doubleClickBack: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as PolyApplication).polyConponent.inject(this)
        super.onCreate(savedInstanceState)
        setupStatusBar()
        setupViewpager()
        listenClickUI()

        Log.e("TAG", "activity: ${homeViewModel.hashCode()}")
        Log.e("TAG", "tesst viewmodel: ${testViewModel.hashCode()}")
        Log.e("TAG", "tesst viewmodel mvrx: ${testViewModelMvRx.hashCode()}")
    }

    override fun getBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    private fun setupStatusBar() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }

    private fun setupViewpager() {
        views.viewpager.apply {
            this.adapter = ViewPaggerAdapter(supportFragmentManager, lifecycle)
            this.isUserInputEnabled = false
            this.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER;
        }
        setStateButtonViewPager(1)
    }

    private fun listenClickUI() {
        views.btnChat.setOnClickListener{
            setStateButtonViewPager(0)
        }
        views.btnHome.setOnClickListener{
            setStateButtonViewPager(1)
        }
        views.btnProfile.setOnClickListener{
            setStateButtonViewPager(2)
        }
    }

    private fun setStateButtonViewPager(s : Int){
        views.viewpager.currentItem = s

        views.btnChat.setImageResource(R.drawable.icons8_chat_100)
        views.btnHome.setImageResource(R.drawable.icons8_home_64)
        views.btnProfile.setImageResource(R.drawable.icons8_user_100)
        if (s == 0){
            views.btnChat.setImageResource(R.drawable.icons8_chat_100_select)
        }else if (s == 1){
            views.btnHome.setImageResource(R.drawable.icons8_home_64_select)
        }else if (s == 2){
            views.btnProfile.setImageResource(R.drawable.icons8_user_100_select)
        }
    }

    override fun onBackPressed() {
        if(views.viewpager.currentItem != 1){
            setStateButtonViewPager(1)
        }else{
            if (doubleClickBack) {
                super.onBackPressed()
            }

            this.doubleClickBack = true
            Toast.makeText(this, "Ấn Back lần nữa để thoát", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({ doubleClickBack = false }, 2000)
        }
    }


    override fun create(initialState: HomeViewState): HomeViewModel {
        return homeViewModelFactory.create(initialState)
    }

}