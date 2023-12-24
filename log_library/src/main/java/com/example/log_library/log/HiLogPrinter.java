package com.example.log_library.log;

import org.jetbrains.annotations.NotNull;

/**
 * 项目名称 mukeDemo
 * 创建人 xiaojinli
 * 创建时间 2023/12/23 20:53
 **/
public interface HiLogPrinter {
    void print(@NotNull HiLogConfig config, int level, String tag, @NotNull String printString);
}
