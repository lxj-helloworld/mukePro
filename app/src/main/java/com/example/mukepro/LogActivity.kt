package com.example.mukepro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.log_library.log.HiLog
import com.example.log_library.log.HiLogConfig
import com.example.log_library.log.HiLogType
import com.example.log_library.log.HiLohManager
import com.example.log_library.log.HiViewPrinter

class LogActivity : AppCompatActivity() {
    var viewPrinter: HiViewPrinter? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        viewPrinter = HiViewPrinter(this)
        viewPrinter?.viewPrinterProvider!!.showFloatingView()
        findViewById<Button>(R.id.print_log).setOnClickListener {

            HiLohManager.getInstance().addPrinters(viewPrinter)

            HiLog.log(object : HiLogConfig(){
                override fun includeThread(): Boolean {
                    return true
                }

                override fun stackTraceDepth(): Int {
                    return 0
                }
            }, HiLogType.E,"-------","错误信息")
            HiLog.a("99999999999999 ")
        }
    }
}