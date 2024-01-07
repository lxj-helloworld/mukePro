package com.example.log_library.log;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 项目名称 mukeDemo
 * 创建人 xiaojinli
 * 创建时间 2023/12/23 20:25
 **/
public class HiLohManager {
    private HiLogConfig hiLogConfig;
    private static HiLohManager instance;

    private List<HiLogPrinter> printerList = new ArrayList<>();

    public HiLohManager(HiLogConfig config, HiLogPrinter[] printers) {
        this.hiLogConfig = config;
        this.printerList.addAll(Arrays.asList(printers));
    }

    public static HiLohManager getInstance() {
        return instance;
    }

    public static void init(@NotNull HiLogConfig config, HiLogPrinter... printers) {
        instance = new HiLohManager(config, printers);
    }

    public HiLogConfig getHiLogConfig() {
        return this.hiLogConfig;
    }

    public void addPrinters(HiLogPrinter printer){
        this.printerList.add(printer);
    }

    public void removePrinter(HiLogPrinter printer){
        if(printer != null){
            printerList.remove(printer);
        }
    }

    public List<HiLogPrinter> getPrinterList() {
        return printerList;
    }
}
