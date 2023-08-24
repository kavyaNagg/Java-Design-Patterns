package com.notificationsystem;

public class EmailNotification implements Notification {
    private String email;

    public EmailNotification(String email) {
        this.email = email;
    }

    public void send(String subject, String message) {
    }
}
