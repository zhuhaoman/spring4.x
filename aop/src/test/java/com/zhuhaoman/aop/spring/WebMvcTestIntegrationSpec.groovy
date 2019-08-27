package com.zhuhaoman.aop.spring

import com.zhuhaoman.aop.controller.HelloController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Specification
import spock.mock.DetachedMockFactory

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class WebMvcTestIntegrationSpec extends Specification{
    @Autowired
    MockMvc mockMvc

    @Autowired
    HelloController controller

    def "spring context loads for web mvc slice"() {
        given:
        controller.test() >> "aaaaaa"

        expect: "controller is available"
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello world"))
    }

    @TestConfiguration
    static class MockConfig {
        def detachedMockFactory = new DetachedMockFactory()

        @Bean
        HelloController helloController() {
            return detachedMockFactory.Stub(HelloController)
        }
    }
}
