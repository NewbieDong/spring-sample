package com.github.spring.sample

import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Recover
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

open class A(var msgA: String)
class B(var msgB: String, msgA: String) : A(msgA)
class C(var msgC: String, msgA: String) : A(msgA)

interface RetryService {
    fun greeting(msg: String)
    fun greetingRecover(throwable: Throwable, msg: String)
    fun greetingB(b: B)
    fun greetingC(c: C)
    fun greetings(throwable: Throwable, a: A)

}

@Service
class RetryServiceImpl : RetryService {

    @Retryable(value = [Throwable::class], backoff = Backoff(delay = 2000L))
    override fun greeting(msg: String) {
        println("Hello $msg!, ${LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}")
        throw Exception("error!!!")
    }

    @Recover
    override fun greetingRecover(throwable: Throwable, msg: String) {
        println("greeting ${throwable.message}! msg=$msg")
    }

    @Retryable(value = [Throwable::class], backoff = Backoff(delay = 1000L))
    override fun greetingB(b: B) {
        println("Hello ${b.msgB}!, ${LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}")
        throw Exception("error!!!")
    }

    @Retryable(value = [Throwable::class], backoff = Backoff(delay = 1000L))
    override fun greetingC(c: C) {
        println("Hello ${c.msgC}!, ${LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}")
        throw Exception("error!!!")
    }

    @Recover
    override fun greetings(throwable: Throwable, a: A) {
        println("greeting ${throwable.message}! msg=${a.msgA}")
    }

}

