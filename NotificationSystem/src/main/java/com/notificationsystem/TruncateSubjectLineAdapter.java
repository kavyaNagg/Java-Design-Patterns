package com.notificationsystem;

public class TruncateSubjectLineAdapter {
    public TruncateSubjectLineAdapter() {
    }

    public String formatSubject(String subject) {
        return subject.length() > 20 ? subject.substring(0, 20) + "..." : subject;
    }
}
