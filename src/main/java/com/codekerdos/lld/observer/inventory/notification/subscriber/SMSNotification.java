package com.codekerdos.lld.observer.inventory.notification.subscriber;

public class SMSNotification implements NotificationObserver{

    @Override
    public void update(String message){
        System.out.println("SMS Notification: "+message);
    }

}
