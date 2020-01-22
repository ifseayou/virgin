package com.isea.design.factory.easy;

import com.isea.design.factory.easy.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/22 9:49
 * @target:
 */
public class OrderPizza  {

    Pizza pizza = null;
    SimpleFactory simpleFactory;

    public OrderPizza(SimpleFactory simpleFactory) {
        setFactory(simpleFactory);
    }

    private void setFactory(SimpleFactory simpleFactory) {
        String orderType = ""; //

        this.simpleFactory = simpleFactory; //

        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);

            //输出pizza
            if(pizza != null) { //
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.boxing();
            } else {
                System.out.println("订购pizza失败");
                break;
            }
        }while(true);
    }

    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}