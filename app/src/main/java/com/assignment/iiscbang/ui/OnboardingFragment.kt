package com.assignment.iiscbang.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class OnboardingFragment : Fragment() {

    companion object {
        fun newInstance(layoutResId: Int): OnboardingFragment {
            val fragment = OnboardingFragment()
            val args = Bundle()
            args.putInt("layoutResId", layoutResId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutResId = arguments?.getInt("layoutResId")
        return inflater.inflate(layoutResId ?: 0, container, false)
    }
}
