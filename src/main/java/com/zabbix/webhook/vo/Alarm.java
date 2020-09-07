package com.zabbix.webhook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.annotation.Annotation;

/**
 * @program: webhook
 * @description:
 * @author: aRookie
 * @date: 2020-09-07 12:48
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alarm implements Serializable{
    private static final long serialVersionUID = 1L;
    private String event_id;
    private String group;
    private String host_name;
    private String host_ip;
    private String alarm_time;
    private String trigger_name;
    private String alarm_value;
    private String alarm_type;
    private String alarm_level;
    private String description;

    @Override
    public String toString() {
        return "event_id='" + event_id + '\'' +
                ", group='" + group + '\'' +
                ", host_name='" + host_name + '\'' +
                ", host_ip='" + host_ip + '\'' +
                ", alarm_time='" + alarm_time + '\'' +
                ", trigger_name='" + trigger_name + '\'' +
                ", alarm_value='" + alarm_value + '\'' +
                ", alarm_type='" + alarm_type + '\'' +
                ", alarm_level='" + alarm_level + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
