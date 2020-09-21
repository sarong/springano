package com.myspring.beans;

import org.springframework.beans.factory.FactoryBean;

public class ColorFacttoryBean  implements FactoryBean<Color> {

    public Color getObject() throws Exception {
        System.out.println("ColorFactory get Object......");
        return new Color();
    }


    public Class<?> getObjectType() {
        return Color.class;
    }
}
