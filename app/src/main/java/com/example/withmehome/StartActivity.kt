package com.example.withmehome;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        Thread.sleep(300)
        setContentView(R.layout.activity_start)

        login_btn.setOnClickListener {
            startActivity(Intent(this@StartActivity,NicknameSetActivity::class.java))
        }
    }
}


