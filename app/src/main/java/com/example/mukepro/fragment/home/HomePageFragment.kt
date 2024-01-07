package com.example.mukepro.fragment.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.library_common.ui.component.HiBaseFragment
import com.example.mukepro.R
import com.example.mukepro.RefreshDemoActivity


class HomePageFragment : HiBaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_home_page
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        initView()
        return layoutView
    }
    fun initView(){
        layoutView.findViewById<TextView>(R.id.click_me).setOnClickListener {
            startActivity(Intent(activity,RefreshDemoActivity::class.java))
        }
    }
}