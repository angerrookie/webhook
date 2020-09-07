package com.zabbix.webhook.controller;

/**
 * @program: webhook
 * @description: webhook接口
 * @author: aRookie
 * @date: 2020-09-07 11:30
 **/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zabbix.webhook.utils.DataToFile;
import com.zabbix.webhook.utils.JSONUtil;
import com.zabbix.webhook.vo.Alarm;
import com.zabbix.webhook.vo.Test;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/zabbix")
public class WHController {

    @PostMapping("/test")
    public void zabbix(@RequestBody String s) {

        System.out.println(s);
        s = s.replace("\"{","{");
        s = s.replace("}\"","}");
        System.out.println(s);
        JSONObject jsonObject = JSON.parseObject(s);
        Test test = (Test) JSONUtil.fastJSONToObject(JSONUtil.fastJSONObjecrToStr(jsonObject), Test.class);
        DataToFile.write(test);
    }

    public static void main(String[] args) {

        String s = "{\"text\":\"Problem: cpu使用率大于0\",\"alarm\":\"{\"event_id\":\"35813\",\"group\":\"IMP.TEMPLATE.HOST.LINUX\",\"host_name\":\"10.10.49.190\",\"host_ip\":\"10.10.49.190\",\"alarm_time\":\"2020.09.07 17:24:28\",\"trigger_name\":\"cpu使用率大于0\",\"alarm_value\":\"0.25\",\"alarm_type\":\"alarm\",\"alarm_level\":\"Warning\",\"description\":\"\"}\"}";
       /* Test test = JSONUtil.fastJSONToObject(s, Test.class);
        System.out.println(s);
        s.replaceAll("\\\\","");
        System.out.println(s);*/
       s = s.replace("\"{","{");
       s = s.replace("}\"","}");
       System.out.println(s);
        /*int i = s.lastIndexOf('{');
        int x =s.lastIndexOf('}');
        System.out.println(s.substring(0,i-1)+s.substring(i,x-1)+s.substring(x-1,s.length()));*/
    }
}
