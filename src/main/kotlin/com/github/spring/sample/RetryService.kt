package com.github.spring.sample

import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Recover
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

interface RetryService {
    fun greeting(msg: String)
    fun greetingRecover(throwable: Throwable, msg: String)
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

}
