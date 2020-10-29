package com.kharitonov.gym.validator;

import java.util.EnumSet;

public class ValidationErrorSet {
    private static final ValidationErrorSet INSTANCE = new ValidationErrorSet();
    private final EnumSet<ValidationError> errors = EnumSet.noneOf(ValidationError.class);

    private ValidationErrorSet() {
    }

    public static ValidationErrorSet getInstance() {
        return INSTANCE;
    }

    public boolean add(ValidationError validationError) {
        return errors.add(validationError);
    }

    public boolean contains(ValidationError error) {
        return errors.contains(error);
    }

    public void clear() {
        errors.clear();
    }

    public EnumSet<ValidationError> getAllAndClear() {
        EnumSet<ValidationError> copy = EnumSet.copyOf(errors);
        errors.clear();
        return copy;
    }
}
