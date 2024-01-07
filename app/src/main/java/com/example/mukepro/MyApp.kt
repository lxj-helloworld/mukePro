package com.example.mukepro

import android.app.Application
import com.example.log_library.log.HiConsolePrinter
import com.example.log_library.log.HiLogConfig
import com.example.log_library.log.HiLogManager
import com.google.gson.Gson

/**
 * 项目名称 mukeDemo
 * 创建人 xiaojinli
 * 创建时间 2023/12/23 20:50
 *
 **/
public class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        HiLogManager.init(object : HiLogConfig() {

            override fun injectJsonParser(): JsonParser {
                return JsonParser { src -> Gson().toJson(src) }
            }

            override fun getGlobalTag(): String {
                return "HiLog"
            }

            override fun enable(): Boolean {
                return super.enable()
            }
        }, HiConsolePrinter())
    }
}