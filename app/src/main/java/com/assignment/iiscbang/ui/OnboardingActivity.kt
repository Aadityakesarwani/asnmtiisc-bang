package com.assignment.iiscbang.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.assignment.iiscbang.R
import com.assignment.iiscbang.adapters.OnboardingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.viewPager)
        btnNext = findViewById(R.id.btnNext)

        val onboardingAdapter = OnboardingAdapter(supportFragmentManager)
        viewPager.adapter = onboardingAdapter

        btnNext.setOnClickListener {
            val nextItem = viewPager.currentItem + 1
            if (nextItem < onboardingAdapter.count) {
                viewPager.currentItem = nextItem
            } else {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                if (position == onboardingAdapter.count - 1) {
                    btnNext.text = "Get Started"
                } else {
                    btnNext.text = "Next"
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}
