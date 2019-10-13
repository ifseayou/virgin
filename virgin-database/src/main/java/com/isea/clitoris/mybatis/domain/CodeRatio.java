package com.isea.clitoris.mybatis.domain;

/**
 * @author isea_you
 * @date 2019/10/13
 * @time 9:27
 * @target:
 */
public class CodeRatio {
    private String code; // 编码
    private Double ratio; // 倍率
    private Integer status; // 状态

    public CodeRatio() {
    }

    @Override
    public String toString() {
        return "CodeRatio{" +
                "code='" + code + '\'' +
                ", ratio=" + ratio +
                ", status=" + status +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public CodeRatio(String code, Double ratio, Integer status) {
        this.code = code;
        this.ratio = ratio;
        this.status = status;
    }
}
