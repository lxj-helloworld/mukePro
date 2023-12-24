package com.example.log_library.log;

/**
 * 项目名称 mukeDemo
 * 创建人 xiaojinli
 * 创建时间 2023/12/23 20:24
 **/
public abstract class HiLogConfig {
    static int MAX_LEN = 512;
    static HiStackTraceFormatter HISTACKTRACEFORMATTER = new HiStackTraceFormatter();
    static HiTheadFormatter HITHEADFORMATTER = new HiTheadFormatter();

    public JsonParser injectJsonParser() {
        return null;
    }

    public String getGlobalTag() {
        return "HiLog";
    }

    public boolean enable() {
        return true;
    }

    public boolean includeThread(){
        return false;
    }

    public int stackTraceDepth(){
        return 5;
    }

    public HiLogPrinter[] printers(){
        return null;
    }
    public interface JsonParser {
        String toJson(Object src);
    }
}
