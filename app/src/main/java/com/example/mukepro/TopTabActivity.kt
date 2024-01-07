package com.example.mukepro

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.library_ui.tab.common.IHiTabLayout
import com.example.library_ui.tab.top.HiTabTopInfo
import com.example.library_ui.tab.top.HiTabTopLayout

class TopTabActivity : AppCompatActivity() {
    var tabsStr = arrayOf(
        "热门",
        "服装",
        "数码",
        "鞋子",
        "零食",
        "家电",
        "汽车",
        "百货",
        "家居",
        "装修",
        "运动"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_tab)
        initTabTop()
    }

    private fun initTabTop() {
        val hiTabTopLayout: HiTabTopLayout = findViewById(R.id.tab_top_layout)
        val infoList: MutableList<HiTabTopInfo<*>> = ArrayList<HiTabTopInfo<*>>()
        val defaultColor = resources.getColor(R.color.tabBottomDefaultColor)
        val tintColor = resources.getColor(R.color.tabBottomTintColor)
        for (s in tabsStr) {
            val info: HiTabTopInfo<*> = HiTabTopInfo<Int>(s, defaultColor, tintColor)
            infoList.add(info)
        }
        hiTabTopLayout.inflateInfo(infoList)
        hiTabTopLayout.addTabSelectedChangeLisntener { index, preInfo, nextInfo ->
            Toast.makeText(this@TopTabActivity, nextInfo.name, Toast.LENGTH_SHORT).show()
        }
        hiTabTopLayout.defaultSelected(infoList[0])
    }
}