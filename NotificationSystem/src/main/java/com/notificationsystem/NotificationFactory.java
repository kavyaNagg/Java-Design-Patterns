package com.notificationsystem;

public class NotificationFactory
{
    private final String channel;

    public NotificationFactory(String channel) {
        this.channel = channel;
    }

    public static Notification createNotification(String channel, String recipient) {
        if (channel.equalsIgnoreCase("email")) {
            return new EmailNotification(recipient);
        } else if (channel.equalsIgnoreCase("sms")) {
            return new SMSNotification(recipient);
        } else {
            throw new IllegalArgumentException("Invalid notification channel");
        }
    }
}
