package com.isea.virgin.web.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/3 22:26
 * @target:
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    ThreadLocal<Long> startTime = new ThreadLocal();

    /**
     * 重用切入点定义
     */
    @Pointcut("execution(* com.isea.virgin.web.company.controller.*.*(..))")
    public void pointCut() {
    }


    /**
     * @param pjp
     * @return
     */
    @Around("pointCut()")
    public Object aroundMethod(ProceedingJoinPoint pjp) {
        try {
            startTime.set(System.currentTimeMillis());
            // 前置
            String methodName = pjp.getSignature().getName();
            String simpleName = pjp.getSignature().getDeclaringType().getSimpleName();
            log.info("LoggingAspect==>the method: " + simpleName + ":" + methodName + "start...");

            // 执行目标方法
            Object result = pjp.proceed();
            // 返回
            return result;
        } catch (Throwable e) {
            e.printStackTrace();
            // 异常通知，暂时不设置
        } finally {
            // 后置
            String functionName = pjp.getSignature().getName();
            String className = pjp.getSignature().getDeclaringType().getSimpleName();
            log.info("LoggingAspect==>the method: " + className + ":" + functionName + "end...");
            long duration = System.currentTimeMillis() - startTime.get();
            String msg = "耗时：" + duration + "毫秒";
            if (duration > 1000) {
                log.warn(functionName +":" + className, msg);
            } else {
                log.info(functionName +":" + className, msg);
            }
        }
        return -1;
    }
}
