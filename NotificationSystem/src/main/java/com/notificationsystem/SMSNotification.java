package com.notificationsystem;

public class SMSNotification implements Notification{
    private String phoneNumber;

    public SMSNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void send(String subject, String message) {
    }
}
