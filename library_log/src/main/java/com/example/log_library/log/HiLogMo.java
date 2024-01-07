package com.example.log_library.log;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * 项目名称 mukeDemo
 * 创建人 xiaojinli
 * 创建时间 2023/12/23 22:18
 **/
public class HiLogMo {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.CHINA);

    public long timeMillis;
    public int level;
    public String tag;
    public String log;

    public HiLogMo(long timeMillis, int level, String tag, String log) {
        this.timeMillis = timeMillis;
        this.level = level;
        this.tag = tag;
        this.log = log;
    }

    public String flattenedLog(){
        return getFlattered() + "\n" + log;
    }

    public String getFlattered(){
        return format(timeMillis) + "|" + level + "|" + tag +"|:";
    }

    public String format(long timeMillis){
        return sdf.format(timeMillis);
    }


}
