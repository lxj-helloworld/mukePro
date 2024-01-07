package com.example.log_library.log;

/**
 * 项目名称 mukeDemo
 * 创建人 xiaojinli
 * 创建时间 2023/12/23 20:56
 **/
public class HiStackTraceFormatter implements HiLogFromatter<StackTraceElement[]> {
    @Override
    public String format(StackTraceElement[] stackTrace) {
        StringBuffer stringBuffer = new StringBuffer(128);
        if (stackTrace == null || stackTrace.length == 0) {
            return "null";
        } else if (stackTrace.length == 1) {
            return "\t - " + stackTrace[0].toString();
        } else {
            for (int i = 0; i < stackTrace.length; i++) {
                if(i == 0){
                    stringBuffer.append("stackTrace : \n");
                }
                if(i != stackTrace.length - 1){
                    stringBuffer.append("\t |- ");
                    stringBuffer.append(stackTrace[i].toString());
                    stringBuffer.append("\n");
                }else{
                    stringBuffer.append("\t -|");
                    stringBuffer.append(stackTrace[i].toString());
                }
            }
        }
        return stringBuffer.toString();
    }
}
