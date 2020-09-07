package com.zabbix.webhook.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zabbix.webhook.vo.Test;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: part
 * @description: JSON操作
 * @author: Administrator
 * @date: 2020-05-28 16:29
 **/
public class JSONUtil {

    /**
     * @Author: Administrator
     * @Description: 字符串转JSON对象
     * @Date: 16:36 2020/5/28
     * @Param: [data, Clzss]
     * @return: T
     * @throw:
     **/
    public static <T> T fastJSONToObject(String data, Class<T> Clzss) {

        try {
            T t = JSON.parseObject(data, Clzss);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author: Administrator
     * @Description: JSONObject转字符串
     * @Date: 8:48 2020/5/29
     * @Param: [jsonObject]
     * @return: java.lang.String
     * @throw:
     **/
    public static String fastJSONObjecrToStr(JSONObject jsonObject) {
        try {
            String string = JSONObject.toJSONString(jsonObject);
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * @Author: Administrator
     * @Description: 对象转JSON字符串
     * @Date: 8:26 2020/5/29
     * @Param: [obj]
     * @return: java.lang.String
     * @throw:
     **/
    public static String obejctToJSONStr(Object obj) {
        try {
            String text = JSON.toJSONString(obj);
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author: Administrator
     * @Description: Objec对象转JSON对象
     * @Date: 3:01 2020/5/29
     * @Param: [object]
     * @return: com.alibaba.fastjson.JSONObject
     * @throw:
     **/
    public static JSONObject objectToJSONObject(Object object) {
        try {

            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(object);
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author: Administrator
     * @Description: 将JSONObject转为实体对象
     * @Date: 8:42 2020/5/29
     * @Param: [data, clzss] JSONObject对象
     * @return: T 实体对象
     * @throw:
     **/
    public static <T> T fastJSONObjectToObject(JSONObject data, Class<T> clzss) {
        try {
            T t = JSONObject.toJavaObject(data, clzss);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author: Administrator
     * @Description: JSON字符串数组转List集合对象
     * @Date: 8:39 2020/5/29
     * @Param: [data, clzss]
     * @return: java.util.List<T>
     * @throw:
     **/
    public static <T> List<T> fastJSONStrToArray(String data, Class<T> clzss) {
        try {
            List<T> t = JSON.parseArray(data, clzss);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author: Administrator
     * @Description:将List<JSONObject>转为List集合对象
     * @Date: 8:44 2020/5/29
     * @Param: [data, clzss]
     * @return: java.util.List<T>
     * @throw:
     **/
    public static <T> List<T> fastJSONToArray(List<JSONObject> data, Class<T> clzss) {
        try {
            List<T> t = new ArrayList<T>();
            for (JSONObject jsonObject : data) {
                t.add(fastJSONObjectToObject(jsonObject, clzss));
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResponseBody fastJSNOStrToObject(String str) {

        try {
            ResponseBody responseBody = JSON.parseObject(str, ResponseBody.class);
            return responseBody;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * @Author: isarookie
     * @Description: json字符串中取出  data
     * @Date: 14:54 2020/6/11
     * @Param: [json, cls]
     * @return: T
     * @throw:
     **/
    public static <T> T getDataByJsonStr(String json,String key,Class<T> cls) {
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject data = jsonObject.getJSONObject(key);
        T t = JSONObject.toJavaObject(data, cls);
        return t;
    }

    /**
     * @Author: isarookie
     * @Description: json字符串中取出 data数组中数据
     * @Date: 14:54 2020/6/11
     * @Param: [clz]
     * @return: java.util.List<T>
     * @throw:
     **/
    public static <T> List<T> getListData(String json,String key,Class<T> clz) {
//        JSONObject jsonObject = JSON.parseObject(json);
//        JSONArray data = jsonObject.getJSONArray(key);

        List<T> list = JSONObject.parseArray(json, clz);

        return list;
    }
}
