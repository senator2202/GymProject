package com.kharitonov.gym.model.validator;

import java.util.EnumSet;
import java.util.Set;

/**
 * The type Validation error set.
 */
public class ValidationErrorSet {
    private static final ValidationErrorSet INSTANCE = new ValidationErrorSet();
    private final EnumSet<ValidationError> errors = EnumSet.noneOf(ValidationError.class);

    private ValidationErrorSet() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ValidationErrorSet getInstance() {
        return INSTANCE;
    }

    /**
     * Add boolean.
     *
     * @param validationError the validation error
     * @return the boolean
     */
    public boolean add(ValidationError validationError) {
        return errors.add(validationError);
    }

    /**
     * Contains boolean.
     *
     * @param error the error
     * @return the boolean
     */
    public boolean contains(ValidationError error) {
        return errors.contains(error);
    }

    /**
     * Clear.
     */
    public void clear() {
        errors.clear();
    }

    /**
     * Gets all and clear.
     *
     * @return the all and clear
     */
    public Set<ValidationError> getAllAndClear() {
        EnumSet<ValidationError> copy = EnumSet.copyOf(errors);
        errors.clear();
        return copy;
    }

}
