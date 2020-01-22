package com.isea.design.factory.easy.pizza;

import lombok.Data;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/22 9:31
 * @target:
 */

@Data
public abstract class Pizza {
    private String name;

    // 准备pizza的过程是不一样的，因为要准备不同的源材料
    public abstract void prepare();

    public void bake(){
        System.out.println(this.name + "baking....");
    }

    public void cut(){
        System.out.println(this.name + "cut....");
    }

    public void boxing(){
        System.out.println(this.name + "boxing....");
    }
}
