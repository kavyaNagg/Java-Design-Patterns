package com.notificationsystem;

public class SMSSubscriber implements Subscriber
{
    private String phoneNumber;

    public SMSSubscriber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void notify(String channel, String recipient, String subject, String message) {
        if (channel.equalsIgnoreCase("sms") && recipient.equalsIgnoreCase(this.phoneNumber)) {
            System.out.println("SMS Notification sent to " + this.phoneNumber + ": Subject - " + subject + ", Message - " + message);
        }

    }
}
