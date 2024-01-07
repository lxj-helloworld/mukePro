package com.example.log_library.log;

/**
 * 项目名称 mukeDemo
 * 创建人 xiaojinli
 * 创建时间 2023/12/23 20:56
 **/
public class HiTheadFormatter implements HiLogFromatter<Thread>{

    @Override
    public String format(Thread data) {
        return "Thread: " + data.getName();
    }
}
