package com.kharitonov.gym.controller.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class PaginationTag  extends SimpleTagSupport {
    private String tableId;

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        String script =
                "<script src=\"/assets/js/jquery-3.3.1.min.js\"></script>\n" +
                "<script src=\"/assets/js/plugins/jquery.dataTables.min.js\"></script>\n" +
                "<script>\n" +
                "   $(document).ready(function () {\n" +
                "   $('#" + tableId + "').DataTable({\n" +
                        "\"scrollX\": false\n" +
                        "});\n" +
                "       $('.dataTables_length').addClass('bs-select');\n" +
                "   });\n" +
                "</script>";
        out.write(script);
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }
}
