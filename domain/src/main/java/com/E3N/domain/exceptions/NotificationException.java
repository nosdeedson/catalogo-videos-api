package com.E3N.domain.exceptions;

import com.E3N.domain.validation.handler.Notification;

public class NotificationException extends DomainException {

    public NotificationException(String message, final Notification notification) {
        super(message, notification.getErrors());
    }

    public static NotificationException with(final String message, Notification notification) {
        return new NotificationException(message, notification);
    }
}
