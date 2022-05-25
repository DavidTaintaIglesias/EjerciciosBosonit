//package com.ejercicios.EJKA1.controller;
//
//import com.ejercicios.EJKA1.send.SendMessages;
//import io.swagger.annotations.Api;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@Api(tags = "EJKA1")
//@RequestMapping("/EJKA1")
//public class KafkaController {
//
//    @Autowired
//    SendMessages sendMessages;
//
//    @PostMapping("/add/{topic}")
//    public void addIdCustomer (@PathVariable String topic, @RequestBody String body) {
//
//        sendMessages.sendMessage(topic, body);
//    }
//}
