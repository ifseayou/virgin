package com.isea.design.factory.easy;

import com.isea.design.factory.easy.pizza.ChinesePizza;
import com.isea.design.factory.easy.pizza.GreekPizza;
import com.isea.design.factory.easy.pizza.Pizza;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/22 9:31
 * @target:
 */

public class SimpleFactory {
    public Pizza createPizza(String orderType){
        Pizza pizza = null;

        System.out.println("开始制作pizza");
        if ("Greek".equals(orderType)){
            pizza = new GreekPizza();
            pizza.setName("制作希腊pizza");
        }else if ("chinese".equals(orderType)){
            pizza = new ChinesePizza();
            pizza.setName("制作中国pizza");
        }
        //如果说有新的pizza，我们只是需要修改简单工厂类即可，不需要修改其他的类
        return pizza;
    }
}
