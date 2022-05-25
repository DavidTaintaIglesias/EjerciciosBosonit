//package com.ejercicios.EJKA1.recive;
//
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@PropertySource("kafka.yml")
//@Component
//public class ReciveMessage {
//
//    @KafkaListener(topics = "${message:topic:name:nombre}", groupId = "${message:group:name:nombreGroup}")
//    public void listenTopic1(String message) {
//
//        System.out.println("Recieved message of topic1 in listener: " + message);
//    }
//
//    @KafkaListener(topics = "${message:topic:name2:nombre2}", groupId = "${message:group:name:nombreGroup")
//    public void listenTopic2(String message) {
//
//        System.out.println("Recieved message of topic2 in listener " + message);
//    }
//}
