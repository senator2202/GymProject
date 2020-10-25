package com.kharitonov.gym.controller.tag;

import com.kharitonov.gym.controller.command.SessionAttributeName;
import com.kharitonov.gym.model.entity.User;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class TableUtilityTag extends SimpleTagSupport {
    private String tableId;
    private int order = 0;
    private String direction = "desc";

    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = getJspContext();
        JspWriter out = context.getOut();
        User user = (User) context.findAttribute(SessionAttributeName.USER);
        String locale = user.getAccount().getLocale().getPostfix();
        String script =
                "<script>\n" +
                "   $(document).ready(function () {\n" +
                "       $('#" + tableId + "').DataTable({\n" +
                "       \"order\": [[ " + order + ", \"" + direction +"\" ]],\n" +
                "       \"language\": {\"url\": \"/assets/json/dataTables." + locale + ".json\"}\n" +
                "       });\n" +
                "       $('.dataTables_length').addClass('bs-select');\n" +
                "   });\n" +
                "</script>";
        out.write(script);
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }
}
