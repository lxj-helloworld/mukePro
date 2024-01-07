package com.example.mukepro

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import com.example.library_common.ui.component.HiBaseActivity
import com.example.mukepro.logic.MainActivityLogic
import com.example.mukepro.logic.MainActivityLogic.ActivityProvider
import org.devio.hi.library.util.HiStatusBar

class MainActivity : HiBaseActivity(), ActivityProvider {
    private lateinit var activityLogic: MainActivityLogic
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityLogic = MainActivityLogic(this, savedInstanceState)

        HiStatusBar.setStatusBar(this, false, getColor(R.color.purple_500), false)
    }

}