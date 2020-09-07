package com.zabbix.webhook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: webhook
 * @description:
 * @author: aRookie
 * @date: 2020-09-07 13:11
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test implements Serializable {

    private static final long serialVersionUID = 10L;

    private String text;
    private Alarm alarm;

    @Override
    public String toString() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"@"+alarm.getHost_ip()+"-------"+
                 "Problem:"+ text + "\n" +
                "\t{" + alarm +"}";
    }
}
