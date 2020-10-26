package com.kharitonov.gym.controller.tag;

import com.kharitonov.gym.controller.command.RequestAttributeName;
import com.kharitonov.gym.controller.command.SessionAttributeName;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MessageTag extends SimpleTagSupport {
    private static final String BLANK = "";

    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = getJspContext();
        JspWriter out = context.getOut();
        String html = BLANK;
        if (context.findAttribute(SessionAttributeName.INCORRECT_LOGIN_PASSWORD) !=null) {
            html = "<script>$('#modalLogin').modal('show');</script>";
            context.removeAttribute(SessionAttributeName.INCORRECT_LOGIN_PASSWORD);
        } else if (context.findAttribute(RequestAttributeName.CONFIRMED_ACCOUNT) !=null) {
            html = "<script>$('#modalConfirmed').modal('show');</script>";
            context.removeAttribute(RequestAttributeName.CONFIRMED_ACCOUNT);
        } else if (context.findAttribute(RequestAttributeName.CONFIRMATION_SENT) !=null) {
            html = "<script>$('#modalConfirmationSent').modal('show');</script>";
            context.removeAttribute(RequestAttributeName.CONFIRMATION_SENT);
        } else if (context.findAttribute(SessionAttributeName.LOGIN_EMAIL_EXISTS) !=null) {
            html = "<script>$('#modalLogin').modal('show'); $('#tab-2').click();</script>";
            context.removeAttribute(SessionAttributeName.LOGIN_EMAIL_EXISTS);
        } else if (context.findAttribute(SessionAttributeName.ACCESS_ERROR) !=null) {
            html = "<script>$('#modalAccessError').modal('show');</script>";
            context.removeAttribute(SessionAttributeName.ACCESS_ERROR);
        }
        out.write(html);
    }
}
