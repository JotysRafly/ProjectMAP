package com.example.projectmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import android.widget.Button

class OnboardingActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var finishButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.viewPager)
        finishButton = findViewById(R.id.btnFinish)

        val adapter = OnboardingAdapter(this)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // Tampilkan tombol Finish hanya di halaman terakhir (index 2)
                finishButton.visibility = if (position == 2) Button.VISIBLE else Button.GONE
            }
        })

        finishButton.setOnClickListener {
            // Pindah ke halaman Sign In saat "Finish" ditekan
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish() // Menutup OnboardingActivity
        }
    }
}