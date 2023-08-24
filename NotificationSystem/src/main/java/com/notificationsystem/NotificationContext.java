package com.notificationsystem;

//Strategy Pattern
public class NotificationContext
{
    private TruncateSubjectLineAdapter subjectLineAdapter;

    public NotificationContext() {
    }

    public void setSubjectLineAdapter(TruncateSubjectLineAdapter adapter) {
        this.subjectLineAdapter = adapter;
    }

    public String formatSubject(String subject) {
        return this.subjectLineAdapter.formatSubject(subject);
    }
}
