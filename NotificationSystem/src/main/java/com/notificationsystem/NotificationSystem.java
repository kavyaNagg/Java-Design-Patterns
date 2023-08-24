package com.notificationsystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NotificationSystem {
    private static NotificationSystem instance = null;
    private List<Subscriber> subscribers = new ArrayList();

    private NotificationSystem() {
    }

    //Singleton Pattern
    public static NotificationSystem getInstance() {
        if (instance == null) {
            instance = new NotificationSystem();
        }
        return instance;
    }

    public void sendNotification(String channel, String recipient, String subject, String message) {
        Notification notification = NotificationFactory.createNotification(channel, recipient);
        notification.send(subject, message);
        this.notifySubscribers(channel, recipient, subject, message);
    }

    public void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    private void notifySubscribers(String channel, String recipient, String subject, String message) {
        Iterator var = this.subscribers.iterator();

        while(var.hasNext()) {
            Subscriber subscriber = (Subscriber)var.next();
            subscriber.notify(channel, recipient, subject, message);
        }
    }
}
