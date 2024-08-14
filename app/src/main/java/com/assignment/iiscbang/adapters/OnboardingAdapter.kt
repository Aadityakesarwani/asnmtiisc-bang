package com.assignment.iiscbang.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.assignment.iiscbang.R
import com.assignment.iiscbang.ui.OnboardingFragment

class OnboardingAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragments = listOf(
        OnboardingFragment.newInstance(R.layout.onboard_frag_1),
        OnboardingFragment.newInstance(R.layout.onboard_frag_2),
    )

    override fun getCount(): Int = fragments.size

    override fun getItem(position: Int): Fragment = fragments[position]
}
