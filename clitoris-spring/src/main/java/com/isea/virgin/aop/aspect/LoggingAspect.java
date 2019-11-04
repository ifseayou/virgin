package com.isea.virgin.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author isea_you
 * @date 2019/11/4
 * @time 17:09
 * @target: 日志切面类LoggingAspect
 */

@Component // 交给spring管理
@Aspect // 标记为切面，切面（类）是由切点构成（方法）；
@Order(1) // 当有多个切面的时候，可以定义顺序
public class LoggingAspect {


    /**
     * 重用切入点定义
     */
    @Pointcut("execution(* com.isea.virgin.aop.service.*.*(..))")
    public void pointCut() {
    }

    /**
     * 第一个 * 任意修饰符，任意返回值
     * 第二个 * 该包的任意类
     * 第三个 * 任意方法
     * .. 任意参数
     *
     * @param joinPoint 连接点，可以获取到目标对象方法相关的信息
     */
    @Before("execution(* com.isea.virgin.aop.service.*.*(..))") // 这个就是切入点表达式
    public void beforeMethod(JoinPoint joinPoint) {
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取方法参数
        Object[] args = joinPoint.getArgs();

        // 前置逻辑
        System.out.println("LoggingAspect==>the method: " + methodName + " begin with " + Arrays.asList(args));
    }

    /**
     * 1)	后置通知：后置通知是在连接点完成之后执行的，即连接点返回结果或者抛出异常的时候
     * （不管是否发生异常都会执行，但是一旦发生异常，获取不到返回结果）
     *
     * @param joinPoint
     */
    @After("pointCut()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        // 后置逻辑
        System.out.println("LoggingAspect==>the method: " + methodName + " end");
    }

    /**
     * 只在连接点返回的时候(正常执行完毕)记录日志
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "execution(* com.isea.virgin.aop.service.*.*(..))", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 返回通知中的逻辑
        System.out.println("LoggingAspect==>the method: " + methodName + " end with the result " + result);
    }


    /**
     * ：只在连接点抛出异常时才执行异常通知
     *
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "execution(* com.isea.virgin.aop.service.*.*(..))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, ArithmeticException ex) {
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 返回通知中的逻辑
        System.out.println("LoggingAspect==>the method: " + methodName + " have exception : " + ex);
    }

    /**
     * @param proceedingJoinPoint
     * @return
     */
    @Around("pointCut()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            // 前置

            // 执行目标方法
            Object result = proceedingJoinPoint.proceed();
            // 返回
            return result;
        } catch (Throwable e) {
            e.printStackTrace();
            // 异常通知
        } finally {
            // 后置
        }
        return -1;
    }
}
