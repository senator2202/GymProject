package com.kharitonov.gym.controller.tag;

import com.kharitonov.gym.controller.command.RequestAttributeName;
import com.kharitonov.gym.controller.command.SessionAttributeName;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MessageTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = getJspContext();
        JspWriter out = context.getOut();
        StringBuilder html = new StringBuilder();
        if (context.findAttribute(SessionAttributeName.INCORRECT_LOGIN_PASSWORD) !=null) {
            html.append("\n<script>$('#modalLogin').modal('show');</script>");
            context.removeAttribute(SessionAttributeName.INCORRECT_LOGIN_PASSWORD);
        }
        if (context.findAttribute(RequestAttributeName.CONFIRMED_ACCOUNT) !=null) {
            html.append("\n<script>$('#modalConfirmed').modal('show');</script>");
            context.removeAttribute(RequestAttributeName.CONFIRMED_ACCOUNT);
        }
        if (context.findAttribute(RequestAttributeName.CONFIRMATION_SENT) !=null) {
            html.append("\n<script>$('#modalConfirmationSent').modal('show');</script>");
            context.removeAttribute(RequestAttributeName.CONFIRMATION_SENT);
        }
        if (context.findAttribute(SessionAttributeName.LOGIN_EMAIL_EXISTS) !=null) {
            html.append("\n<script>$('#modalLogin').modal('show'); $('#tab-2').click();</script>");
            context.removeAttribute(SessionAttributeName.LOGIN_EMAIL_EXISTS);
        }
        if (context.findAttribute(SessionAttributeName.ACCESS_ERROR) !=null) {
            html.append("\n<script>$('#modalAccessError').modal('show');</script>");
            context.removeAttribute(SessionAttributeName.ACCESS_ERROR);
        }
        if (context.findAttribute(SessionAttributeName.LOW_BALANCE) !=null) {
            html.append("\n<script>$('#modalLowBalance').modal('show');</script>");
            context.removeAttribute(SessionAttributeName.LOW_BALANCE);
        }
        if (context.findAttribute(SessionAttributeName.USER) == null) {
            html.append("\n<script>\n" +
                    "   $('#scheduleRef').on('click', function (e) {\n" +
                    "       e.preventDefault();\n" +
                    "       $('#needLogin').css('display', 'inline');\n" +
                    "       $('#modalLogin').on('hidden.bs.modal', function () {\n" +
                    "           $('#needLogin').css('display', 'none');\n" +
                    "       })\n" +
                    "       $('#modalLogin').modal('show');\n" +
                    "   });\n" +
                    "\t</script>");
        }
        out.write(html.toString());
    }
}
