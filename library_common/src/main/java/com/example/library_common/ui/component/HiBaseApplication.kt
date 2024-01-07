package com.example.library_common.ui.component

import android.app.Application
import com.example.log_library.log.HiConsolePrinter
import com.example.log_library.log.HiFilePrinter
import com.example.log_library.log.HiLogConfig
import com.example.log_library.log.HiLogConfig.JsonParser
import com.example.log_library.log.HiLogManager
import com.google.gson.Gson

/**
 * 项目名称 mukePro
 * 创建人 xiaojinli
 * 创建时间 2024/1/7 17:34
 *
 **/
class HiBaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initLog();
    }

    fun initLog(){
        HiLogManager.init(object : HiLogConfig() {
            override fun injectJsonParser(): JsonParser? {
                return JsonParser { src -> Gson().toJson(src) }
            }

            override fun includeThread(): Boolean {
                return true
            }
        }, HiConsolePrinter(), HiFilePrinter.getInstance(cacheDir.absolutePath, 0))
    }
}