package com.codekerdos.lld.observer.inventory.notification.publisher;

import com.codekerdos.lld.observer.inventory.notification.subscriber.*;

public interface NotificationSubject {

    void addObserver(NotificationObserver observer);
    void removeObserver(NotificationObserver observer);
    void notifyObserver();

}
