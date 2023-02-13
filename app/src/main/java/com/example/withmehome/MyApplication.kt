package com.example.withmehome

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "818712b89ed47ae9edee2e90fe16dcdf")
    }
}