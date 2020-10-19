package com.kharitonov.gym.controller.tag;

import com.kharitonov.gym.controller.command.SessionAttributeName;
import com.kharitonov.gym.model.entity.User;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class PaginationTag extends SimpleTagSupport {
    private String tableId;

    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = getJspContext();
        JspWriter out = context.getOut();
        User user = (User) context.findAttribute(SessionAttributeName.USER);
        String locale = user.getAccount().getLocale().getPostfix();
        String script = "<script>\n" +
                "                           $(document).ready(function () {\n" +
                "                           $('#" + tableId + "').DataTable({\n" +
                "                            \"scrollX\": false,\n" +
                "                            \"language\": {\"url\": \"/assets/json/dataTables." + locale + ".json\"}\n" +
                "                          });\n" +
                "                          $('.dataTables_length').addClass('bs-select');\n" +
                "                        });\n" +
                "                      </script>";
        out.write(script);
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }
}
