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
        String msg = "{\"KEY\":\"11010800000400010000\",\"TIMESTAMP\":1568964834102,\"VALUES\":[{\"DATA\":942.0,\"ITEMCODE\":\"0004\",\"EVT_CLASS\":\"04\",\"EVT_SUBCLASS\":\"LMT_UPER\",\"EVT_LIMIT\":100.0}]}";
        System.out.println(msg);

        Object object = JSON.parse(msg);
        System.out.println(object); // 该输出的结果和上面是一样的

        Sensor sensor = JSON.parseObject(msg, Sensor.class);  // 将字符串解析为对象之后的目的就是可以获取到json里面的值。
        System.out.println(sensor);

        System.out.println(sensor.getKey());
        System.out.println(sensor.getTimeStamp());
        JSONArray objects = JSON.parseArray(sensor.getValues().toString());
        System.out.println(objects.get(0)); // 只是打印数组中的某个值

        // 将JavaBean解析为Json文本
        List list = new ArrayList<Metric>();
        list.add(new Metric(1,"aaa","aaa","aaa","aaa",1));
        list.add(new Metric(1,"bbb","bbb","bbb","bbb",1));
        list.add(new Metric(1,"bbb","bbb","bbb","bbb",1));
        Sensor sensor1 = new Sensor("1", "11", list);
        System.out.println(JSON.toJSONString(sensor1));


        System.out.println(objects);  // 下面两个的结果是一样的，将整个数组都打印了
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

    public List getValues() {
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
    private double data;
    private String itemCode;
    private String evt_class;
    private String evt_subclass;
    private String lmt_uper;
    private double evt_limit;

    public Metric() {
    }

    @Override
    public String toString() {
        return "Metric{" +
                "data=" + data +
                ", itemCode='" + itemCode + '\'' +
                ", evt_class='" + evt_class + '\'' +
                ", evt_subclass='" + evt_subclass + '\'' +
                ", lmt_uper='" + lmt_uper + '\'' +
                ", evt_limit=" + evt_limit +
                '}';
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getEvt_class() {
        return evt_class;
    }

    public void setEvt_class(String evt_class) {
        this.evt_class = evt_class;
    }

    public String getEvt_subclass() {
        return evt_subclass;
    }

    public void setEvt_subclass(String evt_subclass) {
        this.evt_subclass = evt_subclass;
    }

    public String getLmt_uper() {
        return lmt_uper;
    }

    public void setLmt_uper(String lmt_uper) {
        this.lmt_uper = lmt_uper;
    }

    public double getEvt_limit() {
        return evt_limit;
    }

    public void setEvt_limit(double evt_limit) {
        this.evt_limit = evt_limit;
    }

    public Metric(double data, String itemCode, String evt_class, String evt_subclass, String lmt_uper, double evt_limit) {
        this.data = data;
        this.itemCode = itemCode;
        this.evt_class = evt_class;
        this.evt_subclass = evt_subclass;
        this.lmt_uper = lmt_uper;
        this.evt_limit = evt_limit;
    }
}