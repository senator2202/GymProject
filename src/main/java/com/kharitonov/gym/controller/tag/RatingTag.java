package com.kharitonov.gym.controller.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class RatingTag extends SimpleTagSupport {
    private double value = 0;
    private String id="";

    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = getJspContext();
        JspWriter out = context.getOut();
        double result = roundValue();
        StringBuilder sb = new StringBuilder("<div class=\"simple-rating star-rating\">\n");
        int i = 1;
        for (; i < result; i++) {
            sb.append("   <i class=\"fa fa-star\"></i>\n");
        }
        if (i != result) {
            sb.append("   <i class=\"fa fa-star-half-o\"></i>\n");
        } else {
            sb.append("   <i class=\"fa fa-star\"></i>\n");
        }
        for (int j = i + 1; j <= 5; j++) {
            sb.append("   <i class=\"fa fa-star-o\"></i>\n");
        }
        sb.append("</div>");
        out.write(sb.toString());
    }

    private double roundValue() {
        double result = Math.round(value * 2) / 2.0;
        return (result > 0 && result <= 5) ? result : 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
