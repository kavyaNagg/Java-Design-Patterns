package com.notificationsystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.print("========== Notification System ==========\n");
        System.out.print("1. Email \n");
        System.out.print("2. SMS \n");

        Scanner s = new Scanner(System.in);
        Constants constant = new Constants();
        System.out.println("Enter the type of Channel: ");
        String channel = s.nextLine();

        System.out.println("Enter the Subject: ");
        String subject = s.nextLine();

        System.out.println("Enter Message: ");
        String message = s.nextLine();

        Subscriber emailSubscriber = new EmailSubscriber("test@example.com");
        Subscriber emailSubscriber1 = new EmailSubscriber("abc@example.com");
        Subscriber smsSubscriber = new SMSSubscriber("8972132563");
        Subscriber smsSubscriber1 = new SMSSubscriber("9822134563");

        NotificationSystem notificationSystem = NotificationSystem.getInstance();
        notificationSystem.subscribe(emailSubscriber);
        notificationSystem.subscribe(emailSubscriber1);
        notificationSystem.subscribe(smsSubscriber);
        notificationSystem.subscribe(smsSubscriber1);

        NotificationContext context = new NotificationContext();
        context.setSubjectLineAdapter(new TruncateSubjectLineAdapter());

        if (channel.equalsIgnoreCase("email")) {
            notificationSystem.sendNotification(channel, "test@example.com", context.formatSubject(subject), message);
            notificationSystem.sendNotification(channel, "abc@example.com", context.formatSubject(subject), message);
        } else if (channel.equalsIgnoreCase("sms")) {
            notificationSystem.sendNotification(channel, "+1234567890", context.formatSubject(subject), message);
            notificationSystem.sendNotification(channel, "9822134563", context.formatSubject(subject), message);
            notificationSystem.sendNotification(channel, "8972132563", context.formatSubject(subject), message);
        } else {
            System.out.println("Invalid notification channel\nEnter a valid channel!!");
        }

        notificationSystem.unsubscribe(emailSubscriber);
        notificationSystem.unsubscribe(smsSubscriber);
    }
}
