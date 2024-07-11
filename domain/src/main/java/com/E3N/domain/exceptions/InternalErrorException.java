package com.E3N.domain.exceptions;

public class InternalErrorException extends NoStacktraceException {

    protected InternalErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public static InternalErrorException with(final String message) {
        return InternalErrorException.with(message, null);
    }

    public static InternalErrorException with(final String message, final Throwable t) {
        return new InternalErrorException(message, t);
    }
}
