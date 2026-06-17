package com.codekerdos.lld.observer.inventory.notification;

import com.codekerdos.lld.observer.inventory.notification.publisher.NotificationSubjectImpl;
import com.codekerdos.lld.observer.inventory.notification.subscriber.CallNotification;
import com.codekerdos.lld.observer.inventory.notification.subscriber.EmailNotification;
import com.codekerdos.lld.observer.inventory.notification.subscriber.NotificationObserver;

public class Driver {

    public static void main(String[] args) {

        NotificationObserver email = new EmailNotification();
        NotificationObserver call = new CallNotification();
        NotificationObserver sms = new CallNotification();

        NotificationSubjectImpl publisher = new NotificationSubjectImpl();
        publisher.addObserver(email);
        publisher.addObserver(call);
        publisher.addObserver(sms);

        publisher.setCount(1000);

        
    }

}
