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

import javax.servlet.http.HttpServletRequest;

import static com.zabbix.webhook.utils.DataToFile.check;

@RestController
@CrossOrigin
@RequestMapping("/zabbix")
public class WHController {

    @PostMapping("/test")
    public void zabbix(@RequestBody String s,HttpServletRequest request) {

        String sgin = request.getHeader("sgin");
        /*
         * 做签名认证  防止恶意数据轰炸
         * 转换成JSON、实体类对象 以便后续操作
         */
        if (check(sgin)) {
            JSONObject jsonObject = JSON.parseObject(DataToFile.variable(s));
            Test test = (Test) JSONUtil.fastJSONToObject(JSONUtil.fastJSONObjecrToStr(jsonObject), Test.class);
            // 序列化 和 字符流写入文件
            DataToFile.write(test);
        }
    }
}
