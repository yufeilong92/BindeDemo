package com.yfl.mybinde

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.yfl.mybinde.databinding.ActivityMainBinding
import com.yfl.myservice.IMyAidlInterface

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        mainBinding.btnBinde.setOnClickListener {
            Toast.makeText(this@MainActivity,"获取数据",Toast.LENGTH_SHORT).show()
            val intent = Intent()
            intent.setAction("com.yfl.myservice.MyService")
            intent.setPackage("com.yfl.myservice")
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
          val  mIMybinde = IMyAidlInterface.Stub.asInterface(p1)
            val data1 =mIMybinde.data
            mainBinding.tvContext.text=data1
        }

        override fun onServiceDisconnected(p0: ComponentName?) {

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection)
    }
}