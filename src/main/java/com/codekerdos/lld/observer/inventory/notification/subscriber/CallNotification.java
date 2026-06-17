package com.codekerdos.lld.observer.inventory.notification.subscriber;

public class CallNotification implements NotificationObserver {

    @Override
    public void update(String message){
        System.out.println("Call Notification: "+message);
    }

}
