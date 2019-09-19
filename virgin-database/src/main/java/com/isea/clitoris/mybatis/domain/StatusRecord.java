package com.isea.clitoris.mybatis.domain;

/**
 * @author isea_you
 * @date 2019/9/18
 * @time 10:12
 * @target:
 */
public class StatusRecord {
    private String id;
    private String timeStamp;
    private String info;
    private int step;

    public StatusRecord(String id, String timeStamp, String info, int step) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.info = info;
        this.step = step;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public StatusRecord() {
    }
}
