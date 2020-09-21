package com.myspring.beans.aops;

public class MathCalculator {
    public int div(int i, int j){
        System.out.println("div方法执行");
        return i/j;
    }
}
