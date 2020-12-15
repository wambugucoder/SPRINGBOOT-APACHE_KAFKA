package com.kafka.demo.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.kafka.demo.loggerResponse.LoggerResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate

@Service
class ProducerService {
    @Autowired
    lateinit var objectMapper: ObjectMapper

   // @Value("\${real.time.logs.topic}")
    val topic:String =  "Real-Time-Logs"

    var logger:Logger =LoggerFactory.getLogger(ProducerService::class.java)

    @Autowired
    lateinit var kafkaTemplate: KafkaTemplate<String, String>


    fun sendLogMessage(loggerResponse: LoggerResponse){
        logger.info("Log Stream Sent to Apache Kafka")
        val res=objectMapper.writeValueAsString(loggerResponse)
        kafkaTemplate.send(topic, res)
    }
}