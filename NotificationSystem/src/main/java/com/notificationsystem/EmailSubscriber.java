package com.notificationsystem;

public class EmailSubscriber implements Subscriber
{
    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    public void notify(String channel, String recipient, String subject, String message) {
        if (channel.equalsIgnoreCase("email") && recipient.equalsIgnoreCase(this.email)) {
            System.out.println("Email Notification sent to " + this.email + ": Subject - " + subject + ", Message - " + message);
        }

    }
}
