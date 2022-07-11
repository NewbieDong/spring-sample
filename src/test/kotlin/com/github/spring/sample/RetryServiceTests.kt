package com.github.spring.sample

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

/**
 *
 * @author antonynumbpad1@gmail.com
 */
@SpringBootTest
class RetryServiceTests @Autowired constructor(private val retryService: RetryService) {

    @Test
    internal fun `test greeting retry`() {
//        retryService.greeting("Kotlin")
//        retryService.greetingB(B("B", "A"))
        retryService.greetingC(C("C", "A"))
    }
}