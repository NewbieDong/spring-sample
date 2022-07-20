package com.github.spring.sample

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


/**
 *
 * @author antonynumbpad1@gmail.com
 */
@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest @Autowired constructor(val mockMvc: MockMvc) {

    @Test
    fun sayHi() {
        mockMvc.perform(get("/hi"))
            .andExpect(status().is2xxSuccessful)
    }
}