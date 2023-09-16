package com.fpoly.polyfriend.ui.security

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fpoly.polyfriend.PolyApplication
import com.fpoly.polyfriend.R
import com.fpoly.polyfriend.core.PolyBaseActivity
import com.fpoly.polyfriend.data.network.SessionManager
import com.fpoly.polyfriend.databinding.ActivitySplashScreenBinding
import com.fpoly.polyfriend.ultis.changeLangue
import com.fpoly.polyfriend.ultis.changeMode
import javax.inject.Inject

class SplashScreenActivity : PolyBaseActivity<ActivitySplashScreenBinding>(){
    override fun getBinding(): ActivitySplashScreenBinding {
        return ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    @Inject
    public lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as PolyApplication).polyConponent.inject(this)
        super.onCreate(savedInstanceState)

        configData()

        Thread{
            Thread.sleep(2000)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }.start()
    }

    private fun configData() {
        sessionManager.fetchDarkMode().let {   changeMode(it ?: false) }
        sessionManager.fetchLanguage().let { changeLangue(resources, it ?: "en") }
    }
}