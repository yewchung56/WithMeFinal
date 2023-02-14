package com.example.withmehome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.withmehome.databinding.ActivityLeaveMessageBinding

class LeaveMessageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLeaveMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaveMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLmSend.setOnClickListener {
            startActivity(Intent(this@LeaveMessageActivity, sharing_message::class.java))
        }

        binding.btnLmX.setOnClickListener{
            startActivity(Intent(this@LeaveMessageActivity, sharing_message::class.java))
        }
    }
}