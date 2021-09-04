package com.yfl.myservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return myBinder
    }

    override fun onCreate() {
        super.onCreate()
    }
    private var myBinder = object : IMyAidlInterface.Stub() {
        override fun getData(): String {
            return "服务端数据"
        }
    }
}