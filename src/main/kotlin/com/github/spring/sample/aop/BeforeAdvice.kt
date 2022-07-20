package com.github.spring.sample.aop

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component

/**
 *
 * @author antonynumbpad1@gmail.com
 */

@Component
@Aspect
class BeforeAdvice {
    @Pointcut("execution(* com.github.spring.sample.HelloController.*(..))")
    fun helloController() {

    }

//    @Before("helloController()")
//    fun before(joinPoint: JoinPoint) {
//        println("BeforeAdvice===========")
//    }

    @Around("helloController()")
    fun around(pjp: ProceedingJoinPoint){
        println("Around Advice before=============>")
        val proceed = pjp.proceed()
        println("Around Advice after=============>")
    }
}

