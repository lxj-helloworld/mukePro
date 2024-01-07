package com.example.log_library.log;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * 项目名称 mukeDemo
 * 创建人 xiaojinli
 * 创建时间 2023/12/23 20:11
 * 1、打印堆栈信息
 * ２、File输出
 * 3、模拟控制台
 **/
public class HiLog {

    private static final String HI_LOG_PACKAGENAME;

    static {
        String className = HiLog.class.getName();
        System.out.println(className.lastIndexOf('.'));
        System.out.println(className.length());

        HI_LOG_PACKAGENAME = className.substring(0, className.lastIndexOf('.') + 1);
    }


    public static void v(Object... contents) {
        log(HiLogType.V, contents);
    }

    public static void vt(String tag, Object... contents) {
        log(HiLogType.V, tag, contents);
    }

    public static void d(Object... contents) {
        log(HiLogType.D, contents);
    }

    public static void dt(String tag, Object... contents) {
        log(HiLogType.D, tag, contents);
    }

    public static void i(Object... contents) {
        log(HiLogType.I, contents);
    }

    public static void it(String tag, Object... contents) {
        log(HiLogType.I, tag, contents);
    }

    public static void w(Object... contents) {
        log(HiLogType.W, contents);
    }

    public static void wt(String tag, Object... contents) {
        log(HiLogType.W, tag, contents);
    }

    public static void e(Object... contents) {
        log(HiLogType.E, contents);
    }

    public static void et(String tag, Object... contents) {
        log(HiLogType.E, tag, contents);
    }

    public static void a(Object... contents) {
        log(HiLogType.A, contents);
    }

    public static void at(String tag, Object... contents) {
        log(HiLogType.A, tag, contents);
    }

    public static void log(@HiLogType.TYPE int type, Object... contents) {
        log(type, HiLogManager.getInstance().getHiLogConfig().getGlobalTag(), contents);
    }

    public static void log(@HiLogType.TYPE int type, @NotNull String tag, Object... contents) {
        log(HiLogManager.getInstance().getHiLogConfig(), type, tag, contents);
    }

    public static void log(@NotNull HiLogConfig config, @HiLogType.TYPE int type, @NotNull String tag, Object... contents) {
        if (!config.enable()) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (config.includeThread()) {
            String threadInfo = HiLogConfig.HITHEADFORMATTER.format(Thread.currentThread());
            stringBuffer.append(threadInfo).append("\n");
        }

        if (config.stackTraceDepth() > 0) {
            String stackInfo = HiLogConfig.HISTACKTRACEFORMATTER.format(HiStackTraceUtil.getCroppedRealStackTrace(new Throwable().getStackTrace(), HI_LOG_PACKAGENAME, config.stackTraceDepth()));
            stringBuffer.append(stackInfo).append("\n");
        }

        String body = parseBody(contents, config);
        stringBuffer.append(body);

        List<HiLogPrinter> printers = config.printers() != null ? Arrays.asList(config.printers()) : HiLogManager.getInstance().getPrinterList();
        if (printers != null) {
            for (HiLogPrinter printer : printers) {
                printer.print(config, type, tag, stringBuffer.toString());
            }
        }

    }

    private static String parseBody(@NotNull Object[] contents, @NotNull HiLogConfig config) {
        if (config.injectJsonParser() != null) {
            return config.injectJsonParser().toJson(contents);
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (Object o : contents) {
            stringBuffer.append(o.toString()).append(";");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }
}
