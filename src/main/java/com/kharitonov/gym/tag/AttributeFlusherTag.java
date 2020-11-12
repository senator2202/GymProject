package com.kharitonov.gym.tag;

import com.kharitonov.gym.model.validator.ValidationError;
import com.kharitonov.gym.util.SessionAttributeName;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.util.EnumSet;

/**
 * Tag removes context attribiute.
 */
public class AttributeFlusherTag extends SimpleTagSupport {
    private ValidationError error;

    @Override
    public void doTag() {
        JspContext context = getJspContext();
        EnumSet<ValidationError> errorSet =
                (EnumSet<ValidationError>) context.findAttribute(SessionAttributeName.ERROR_SET);
        errorSet.remove(error);
    }

    /**
     * Gets error.
     *
     * @return the error
     */
    public ValidationError getError() {
        return error;
    }

    /**
     * Sets error.
     *
     * @param error the error
     */
    public void setError(ValidationError error) {
        this.error = error;
    }
}
