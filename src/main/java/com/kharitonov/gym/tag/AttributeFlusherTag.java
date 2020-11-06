package com.kharitonov.gym.tag;

import com.kharitonov.gym.model.validator.ValidationError;
import com.kharitonov.gym.util.SessionAttributeName;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.EnumSet;

public class AttributeFlusherTag extends SimpleTagSupport {
    private ValidationError error;

    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = getJspContext();
        JspWriter out = context.getOut();
        EnumSet<ValidationError> errorSet =
                (EnumSet<ValidationError>) context.findAttribute(SessionAttributeName.ERROR_SET);
        errorSet.remove(error);
    }

    public ValidationError getError() {
        return error;
    }

    public void setError(ValidationError error) {
        this.error = error;
    }
}
