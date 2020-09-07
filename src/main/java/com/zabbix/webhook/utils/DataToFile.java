package com.zabbix.webhook.utils;

import com.zabbix.webhook.vo.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: webhook
 * @description: alarm file
 * @author: aRookie
 * @date: 2020-09-07 14:22
 **/
public class DataToFile {

    public static void write(Test test) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd");
        String fileNmae = "G:/"+simpleDateFormat.format(new Date())+"@"+test.getAlarm().getHost_ip();
        // 获取要写入的文件对象
        FileWriter fw = null;
        try {
            //追加写入内容
            fw = new FileWriter(fileNmae,true);
            BufferedWriter bw = new BufferedWriter(fw);
            // 往文件中写入内容（支持转义符）
            bw.write(test.toString());
            // 往文件中写入换行
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String variable(String s) {

        s = s.replaceAll("\\\\","").replace("\"{","{").replace("}\"","\"}");
        return s;
    }

    public static boolean check(String sgin) {

        return false;
    }

}
