package com.kharitonov.gym.controller.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class CancelButtonTag extends SimpleTagSupport {
    private int trainingId;
    private String tooltip = "cancel";

    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = getJspContext();
        JspWriter out = context.getOut();
        String html = "<form action=\"/mainController\" method=\"post\">\n" +
                "                                                <input type=\"hidden\" name=\"command\" value=\"cancel_training\"/>\n" +
                "                                                <input type=\"hidden\" name=\"trainingId\" value=\"" + trainingId + "\"/>\n" +
                "                                                <button type=\"submit\" rel=\"tooltip\" class=\"btn btn-outline-danger btn-round\" data-toggle=\"tooltip\" title=\"" + tooltip + "\">\n" +
                "                                                    <i class=\"material-icons\">close</i>\n" +
                "                                                </button>\n" +
                "                                            </form>";
        out.write(html);
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }
}
