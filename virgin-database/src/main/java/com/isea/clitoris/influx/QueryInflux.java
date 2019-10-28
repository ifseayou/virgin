package com.isea.clitoris.influx;

import com.joinbright.iot.base.datasource.influxdb.service.InfluxDBService;
import com.joinbright.pyd.influx.dto.ResultPoint;

import java.util.List;

/**
 * @author isea_you
 * @date 2019/10/24
 * @time 20:21
 * @target:
 */
public class QueryInflux {
    public static void main(String[] args) {
        InfluxDBService pyd = new InfluxDBService("pyd");
        List<ResultPoint> query = pyd.query("select * from e002 limit 2");
        System.out.println(query);
    }
}
