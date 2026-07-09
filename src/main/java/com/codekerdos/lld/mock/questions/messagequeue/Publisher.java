package com.codekerdos.lld.mock.questions.messagequeue;

public class Publisher {

    String id;
    Broker broker;

    void publish(String topicId, String message){
        broker = new Broker();
        broker.publish(topicId,message);
    }

}
