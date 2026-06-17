package com.codekerdos.lld.observer.inventory.notification.publisher;

import java.util.ArrayList;
import java.util.List;

import com.codekerdos.lld.observer.inventory.notification.subscriber.*;

public class NotificationSubjectImpl implements NotificationSubject {

    private int iPhoneEighteeCount;

    private List<NotificationObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(NotificationObserver observer){
        observers.add(observer);

    }

    @Override
    public void removeObserver(NotificationObserver observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(){
        for(NotificationObserver observer : observers){
            observer.update("iPhone 18 is available now. Grab yours!!");
        }
    }

    public void setCount(int count){
        this.iPhoneEighteeCount = count;

        if(count >= 100){
            notifyObserver();
        }
        else{
            System.out.println("Inventory too low to send out notifications. Current count: "+count);
        }
    }

}
