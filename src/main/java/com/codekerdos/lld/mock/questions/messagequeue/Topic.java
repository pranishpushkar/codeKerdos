package com.codekerdos.lld.mock.questions.messagequeue;

import java.util.*;

public class Topic {
    String id;
    String topicName;
    List<Message> publishedMessages;
    Map<String,ConsumerGroup> subscribers;

}
