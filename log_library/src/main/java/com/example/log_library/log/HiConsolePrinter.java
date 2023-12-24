package com.example.log_library.log;

import static com.example.log_library.log.HiLogConfig.MAX_LEN;

import android.util.Log;

import androidx.annotation.NonNull;

/**
 * 项目名称 mukeDemo
 * 创建人 xiaojinli
 * 创建时间 2023/12/23 21:08
 **/
public class HiConsolePrinter implements HiLogPrinter {
    @Override
    public void print(@NonNull HiLogConfig config, int level, String tag, @NonNull String printString) {
        int lenth = printString.length();
        int count = lenth / MAX_LEN;
        if (count > 0) {
            int index = 0;
            for (int i = 0; i < count; i++) {
                Log.println(level, tag, printString.substring(index, index + MAX_LEN));
                index = index + MAX_LEN;
            }
            //行数不能整除
            if (index != lenth) {
                Log.println(level,tag,printString.substring(index,lenth));
            }
        }else {
            Log.println(level,tag,printString);
        }
    }
}
