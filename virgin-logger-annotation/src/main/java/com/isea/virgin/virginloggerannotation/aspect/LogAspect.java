package com.isea.virgin.virginloggerannotation.aspect;

import com.isea.virgin.virginloggerannotation.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author isea_you
 * @date 2019/9/25
 * @time 14:34
 * @target: 参考：https://www.cnblogs.com/sword-successful/p/10850168.html 的代码实现boot + 注解 + AOP
 * 改造之后是基于*/


@Aspect  // 作用是把当前类标识为一个切面供容器读取
@Order(5)  // @Order注解主要用来控制配置类的加载顺序
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    ThreadLocal<Long> startTime = new ThreadLocal();


    @Pointcut("@annotation(com.isea.virgin.virginloggerannotation.annotation.Log)")
    public void log() {
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        Object result = joinPoint.proceed();
//        System.out.println("耗时：" + (System.currentTimeMillis() - startTime.get()));
        logger.info("耗时：" + (System.currentTimeMillis() - startTime.get()));

        return result;
//        logger.info(joinPoint.getSignature().getName());
//        return joinPoint.proceed();
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("==================Start=================");
        startTime.set(System.currentTimeMillis());
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();

//        System.out.println("==================Start=================");
//        System.out.println("Description：" + getLogValue(joinPoint));
//        System.out.println("Method：" + request.getMethod());

        //打印controller全路径及method
//        System.out.println("Class Method：" + joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
//        System.out.println("请求参数：" + new Gson().toJson(joinPoint.getArgs()));
        logger.info("Class Method：" + joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());

    }

    private String getLogValue(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        Log logger = method.getAnnotation(Log.class);

        return logger.value();
    }

    @After("log()")
    public void doAfter() {
//        System.out.println();
//        logger.info(String.valueOf(System.currentTimeMillis() - startTime.get()));
        logger.info("==================End=================");
//        System.out.println("==================End=================");
    }
}
