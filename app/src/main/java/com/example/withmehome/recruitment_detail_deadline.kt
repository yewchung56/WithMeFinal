package com.example.withmehome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar

import com.example.withmehome.databinding.ActivityRecruitmentDetailDeadlineBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_recruitment_detail_deadline.*
import kotlinx.android.synthetic.main.fragment_home.*

class recruitment_detail_deadline : AppCompatActivity() {

    private lateinit var binding: ActivityRecruitmentDetailDeadlineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_recruitment_detail_deadline)
        val toolbar = findViewById<Toolbar>(R.id.sharing_message_toolbar)
        setSupportActionBar(toolbar)
        val actionbar = supportActionBar!!
        actionbar.setDisplayShowTitleEnabled(false)
        actionbar.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_sharing_message_back)

        binding=ActivityRecruitmentDetailDeadlineBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}