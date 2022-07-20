package com.github.spring.sample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 * @author antonynumbpad1@gmail.com
 */
@RestController
class HelloController {

    @GetMapping("/hi")
    fun sayHi() {
        println("Hello World")
    }
}