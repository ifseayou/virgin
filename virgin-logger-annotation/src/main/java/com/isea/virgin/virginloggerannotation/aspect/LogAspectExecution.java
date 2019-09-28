package com.isea.virgin.virginloggerannotation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author isea_you
 * @date 2019/9/25
 * @time 14:34
 * @target:
 */
@Aspect  // 作用是把当前类标识为一个切面供容器读取
@Order(5)  // @Order注解主要用来控制配置类的加载顺序
@Component
public class LogAspectExecution {

    private final Logger logger = LoggerFactory.getLogger(LogAspectExecution.class);
    ThreadLocal<Long> startTime = new ThreadLocal();


    //    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void log() {
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        Object result = joinPoint.proceed();
        logger.info("耗时：" + (System.currentTimeMillis() - startTime.get()));
        return result;

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("==================Start=================");
        startTime.set(System.currentTimeMillis());
        logger.info("Class Method：" + joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());

    }

    @After("log()")
    public void doAfter() {
        logger.info("==================End=================");
    }
}