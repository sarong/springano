package com.myspring.beans.aops.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspects {
    //抽取公共切面，
    @Pointcut("execution(public int com.myspring.beans.aops.MathCalculator.div(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void logBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("" + joinPoint.getSignature().getName() + "运行。。。@Before:参数列表是：{" + Arrays.asList(args) + "}");
    }

    @After("pointCut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After......");
    }

    @AfterReturning("pointCut()")
    public void logReturing(JoinPoint joinPoint) {
        System.out.println("AfterReturning......");
    }

    @AfterThrowing("pointCut()")
    public void logThrowing(JoinPoint joinPoint) {
        System.out.println("AfterThrowing......");
    }
}
