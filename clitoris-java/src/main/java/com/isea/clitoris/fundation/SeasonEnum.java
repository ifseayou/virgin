package com.isea.clitoris.fundation;

/**
 * @author isea_you
 * @date 2019/10/31
 * @time 11:50
 * @target:
 */
public enum SeasonEnum{
    SPRING("0"),
    SUMMER("1"),
    AUTUMN("2"),
    WINTER("3");
    private String code;
    private SeasonEnum(String code){
        this.code = code;
    }
    public String getCode() {
        return this.code;
    }
}