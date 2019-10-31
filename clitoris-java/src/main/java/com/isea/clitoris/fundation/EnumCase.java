package com.isea.clitoris.fundation;

/**
 * @author isea_you
 * @date 2019/9/19
 * @time 17:22
 * @target:
 */
public class EnumCase {
    public static void main(String[] args) {
        SeasonEnum sea = SeasonEnum.AUTUMN;
        switch (sea){
            case AUTUMN:
                System.out.println("秋天");
                break;
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case WINTER:
                System.out.println("冬天" );
                break;
        }
        System.out.println(sea.getCode());
    }
}


