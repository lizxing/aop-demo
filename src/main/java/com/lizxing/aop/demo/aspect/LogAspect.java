package com.lizxing.aop.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 *
 * @author LZX
 */
@Aspect
@Component
public class LogAspect {

//    @Pointcut("execution(public * com.lizxing.aop.demo.controller.*.*(..))")
    @Pointcut(value = "@annotation(com.lizxing.aop.demo.annotation.WritingLog)")
    public void writingLog(){}

    /**
     * 前置通知
     * @param joinPoint
     * @throws Throwable
     */
    @Before("writingLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        System.out.println("被代理方法：" + joinPoint.getSignature().getName());
        System.out.println("前置通知，连接点执行前");
    }

    /**
     * 后置通知
     * @param joinPoint
     */
    @After("writingLog()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("后置通知，连接点执行后");
    }

    /**
     * 返回通知
     * @param joinPoint
     */
    @AfterReturning("writingLog()")
    public void doAfterReturning(JoinPoint joinPoint){
        System.out.println("返回通知，方法退出后执行");
    }

    /**
     * 异常通知
     * @param joinPoint
     */
    @AfterThrowing("writingLog()")
    public void doAfterThrowing(JoinPoint joinPoint){
        System.out.println("异常通知，方法异常后执行");
    }

//    /**
//     * 环绕方法，相当于把整个被代理的目标方法包装起来
//     * @param proceedingJoinPoint
//     * @throws Throwable
//     */
//    @Around("writingLog()")
//    public void doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        try{
//            try{
//                System.out.println("连接点执行前（@Before）");
//                proceedingJoinPoint.proceed();
//            }finally {
//                System.out.println("连接点执行后（@After）");
//            }
//            System.out.println("方法返回后（@AfterReturning）");
//        }catch (Throwable e){
//            System.out.println("方法执行异常（@AfterThrowing）");
//        }
//    }
}
