package com.isea.clitoris.parseData;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author isea_you
 * @date 2019/9/20
 * @time 20:12
 * @target:
 */
public class GetAboutJson {
    public static void main(String[] args) {
//        String msg = "{\"KEY\":\"11010800000400010000\",\"TIMESTAMP\":1568964834102,\"VALUES\":[{\"DATA\":942.0,\"ITEMCODE\":\"0004\",\"EVT_CLASS\":\"04\",\"EVT_SUBCLASS\":\"LMT_UPER\",\"EVT_LIMIT\":100.0}]}";
        // 这里必须严格满足json的格式
        String msg = "{\"TIMESTAMP\":\"1570870991923\",\"VALUES\":[\"7A07=651\",\"0014=801\",\"0012=400\",\"0004=65\",\"0008=256\",\"0015=559\"],\"KEY\":\"11010800018600050000\"}";
        msg = msg.replace("=", "\":\"").replace("[","{").replace("]","}");
        System.out.println(msg);


        Sensor sensor = JSON.parseObject(msg, Sensor.class);  // 将字符串解析为对象之后的目的就是可以获取到json里面的值。
        System.out.println(sensor);

        System.out.println(sensor.getKey());
        System.out.println(sensor.getTimeStamp());
        List<Metric> values = sensor.getValues();
        System.out.println();
        for (Metric value : values) {
            System.out.println(value.getIndex() + ":" + value.getValue());
        }
        System.out.println(sensor.getValues());
    }
}


class Sensor{
    private String key;
    private String timeStamp;
    private List<Metric> values;

    @Override
    public String toString() {
        return "Sensor{" +
                "key='" + key + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", values=" + values +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<Metric> getValues() {
        return values;
    }

    public void setValues(List values) {
        this.values = values;
    }

    public Sensor(String key, String timeStamp, List values) {
        this.key = key;
        this.timeStamp = timeStamp;
        this.values = values;
    }

    public Sensor() {
    }
}

class Metric{
   private String index;
   private Double value;

    public Metric() {
    }

    public Metric(String index, Double value) {
        this.index = index;
        this.value = value;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Metric{" +
                "index='" + index + '\'' +
                ", value=" + value +
                '}';
    }
}