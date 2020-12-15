package com.kafka.demo.loggerResponse


import java.io.Serializable
import java.time.LocalDateTime

class LoggerResponse(
    var timeStamp:LocalDateTime= LocalDateTime.now(),
    var level: String,
    var level_Color:String,
    var message:String,
    var logger_name:String="org.apache.kafka.clients.Metadata"
) :Serializable{


}
