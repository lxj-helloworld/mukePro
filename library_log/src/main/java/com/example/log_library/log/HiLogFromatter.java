package com.example.log_library.log;

/**
 * 项目名称 mukeDemo
 * 创建人 xiaojinli
 * 创建时间 2023/12/23 20:55
 **/
public interface HiLogFromatter<T> {
    String format(T data);
}
