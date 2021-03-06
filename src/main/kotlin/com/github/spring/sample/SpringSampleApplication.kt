package com.github.spring.sample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.retry.annotation.EnableRetry

@SpringBootApplication
@EnableRetry
@EnableAspectJAutoProxy
class SpringSampleApplication

fun main(args: Array<String>) {
    runApplication<SpringSampleApplication>(*args)
}
