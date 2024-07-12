package com.E3N.domain.validation.handler;

import com.E3N.domain.exceptions.DomainException;
import com.E3N.domain.validation.Error;
import com.E3N.domain.validation.ValidationHandler;

import java.util.ArrayList;
import java.util.List;

public class Notification implements ValidationHandler {

    private final List<Error> errors;

    private Notification(final List<Error> errors) {
        this.errors = errors;
    }

    public static Notification create() {
        return new Notification(new ArrayList<>());
    }

    public static Notification create(final Throwable t) {
        return create(new Error(t.getMessage()));
    }

    public static Notification create(final Error anError) {
        return (Notification) new Notification(new ArrayList<>()).append(anError);
    }

    @Override
    public ValidationHandler append(Error error) {
        this.errors.add(error);
        return this;
    }

    @Override
    public ValidationHandler append(ValidationHandler handler) {
        this.errors.addAll(handler.getErrors());
        return this;
    }

    @Override
    public <T> T validate(Validation<T> validation) {
        try {
            return validation.validate();
        } catch (final DomainException ex) {
            this.errors.addAll(ex.getErrors());
        } catch (final Throwable t) {
            this.errors.add(new Error(t.getMessage()));
        }
        return null;
    }

    @Override
    public List<Error> getErrors() {
        return errors;
    }
}
