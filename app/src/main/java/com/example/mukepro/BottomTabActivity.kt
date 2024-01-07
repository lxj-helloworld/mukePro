package com.example.mukepro

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.library_ui.tab.bottom.HiTabBottomInfo
import com.example.library_ui.tab.bottom.HiTabBottomLayout
import com.example.log_library.log.HiDisplayUtil

class BottomTabActivity : AppCompatActivity() {
    lateinit var contentTv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_tab)
        contentTv = findViewById(R.id.info_tv)
        initTabBottom()
    }

    private fun initTabBottom() {
        val hiTabBottomLayout: HiTabBottomLayout = findViewById(R.id.bottom_tap_layout)
        hiTabBottomLayout.setTabAlpha(0.85f)
        val bottomInfoList: MutableList<HiTabBottomInfo<*>> = ArrayList()
        val homeInfo = HiTabBottomInfo<String>(
            "首页",
            "fonts/iconfont.ttf",
            getString(R.string.if_home),
            null,
            "#ff656667",
            "#ffd44949",
            HiTabBottomInfo.TabType.ICON
        )
        val infoRecommend = HiTabBottomInfo<String>(
            "收藏",
            "fonts/iconfont.ttf",
            getString(R.string.if_favorite),
            null,
            "#ff656667",
            "#ffd44949",
            HiTabBottomInfo.TabType.ICON
        )

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.fire, null)
        val infoCategory = HiTabBottomInfo<String>(
            "分类",
            bitmap,
            bitmap,
            "#ff656667",
            "#ffd44949",
            HiTabBottomInfo.TabType.BITMAP
        )
        val infoChat = HiTabBottomInfo<String>(
            "推荐",
            "fonts/iconfont.ttf",
            getString(R.string.if_recommend),
            null,
            "#ff656667",
            "#ffd44949",
            HiTabBottomInfo.TabType.ICON
        )
        val infoProfile = HiTabBottomInfo<String>(
            "我的",
            "fonts/iconfont.ttf",
            getString(R.string.if_profile),
            null,
            "#ff656667",
            "#ffd44949",
            HiTabBottomInfo.TabType.ICON
        )
        bottomInfoList.add(homeInfo)
        bottomInfoList.add(infoRecommend)
        bottomInfoList.add(infoCategory)
        bottomInfoList.add(infoChat)
        bottomInfoList.add(infoProfile)
        hiTabBottomLayout.inflateInfo(bottomInfoList)

        hiTabBottomLayout.addTabSelectedChangeLisntener { index, preInfo, nextInfo ->
            Log.i("TAG", "initTabBottom:index = $index  preInfo = $preInfo  nextInfo = $nextInfo")
            contentTv.setText(nextInfo?.name)
        }
        hiTabBottomLayout.defaultSelected(homeInfo)

        //   改变中间tab的高度
        val tabBottom = hiTabBottomLayout.findTab(bottomInfoList[2])
        tabBottom?.apply { resetHeight(HiDisplayUtil.dp2px(66f, resources)) }
    }
}