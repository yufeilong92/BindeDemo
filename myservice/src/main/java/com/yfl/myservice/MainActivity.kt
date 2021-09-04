package com.yfl.myservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yfl.myservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        mainBinding.btnStartService.setOnClickListener {
            Toast.makeText(this@MainActivity,"启动服务", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MyService::class.java)
            startService(intent)
        }
    }
}