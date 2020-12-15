package com.kafka.demo.controller


import com.kafka.demo.loggerResponse.LoggerResponse
import com.kafka.demo.service.ProducerService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiController {

    @Autowired
    lateinit var producerService: ProducerService



    var logger:Logger = LoggerFactory.getLogger(ApiController::class.java)

    @GetMapping("/hello")
    fun doStuff(): String {
        val loggerResponse=LoggerResponse(level = "INFO",level_Color="\uD83D\uDFE2 ", message = "Hello Api Successfully Called")
         producerService.sendLogMessage(loggerResponse)
        return "Message sent succesfully"

    }
}