package com.notificationsystem;

public interface Subscriber {
    void notify(String channel, String recipient, String subject, String message);
}
