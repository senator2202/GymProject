package com.kharitonov.gym.tag;

import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.Trainer;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ProfileButtonTag extends SimpleTagSupport {
    private User user;
    private String tooltip;

    @Override
    public void doTag() throws JspException, IOException {
        UserRole role = user.getAccount().getRole();
        if (role != UserRole.ADMIN) {
            JspContext context = getJspContext();
            JspWriter out = context.getOut();
            String header;
            String userAttr = userAttributes();
            String childAttr;
            if (user.getAccount().getRole() == UserRole.CLIENT) {
                header = clientHeader();
                childAttr = clientAttributes();
            } else {
                header = trainerHeader();
                childAttr = trainerAttributes();
            }
            String footer = "<i class=\"material-icons\">person</i>\n" +
                    "</button>";
            String html = header + userAttr + childAttr + footer;
            out.write(html);
        }
    }

    private String clientHeader() {
        return " <button type=\"button\" class=\"btn btn-info btn-round\" title=\"" + tooltip + "\" " +
                "data-toggle=\"modal\" data-target=\"#modalClientProfile\"\n";
    }

    private String trainerHeader() {
        return " <button type=\"button\" class=\"btn btn-info btn-round\" title=\"" + tooltip + "\" " +
                "data-toggle=\"modal\" data-target=\"#modalTrainerProfile\"\n";
    }

    private String userAttributes() {
        return "data-lastname=\"" + user.getLastName() + "\"\n" +
                "data-firstname=\"" + user.getFirstName() + "\"\n" +
                "data-userid=\"" + user.getAccount().getId() + "\"\n" +
                "data-imagename=\"" + user.getImageName() + "\"\n" +
                "data-email=\"" + user.getAccount().getEmail() + "\"\n" +
                "data-phone=\"" + user.getPhoneNumber() + "\"\n" +
                "data-role=\"" + user.getAccount().getRole() + "\"\n";
    }

    private String clientAttributes() {
        return "data-moneybalance=\"" + ((Client) user).getMoneyBalance() + "\"\n" +
                "data-personaldiscount=\"" + ((Client) user).getPersonalDiscount() + "\"\n" +
                "data-boughttrainings=\"" + ((Client) user).getBoughtTrainings() + "\">\n";
    }

    private String trainerAttributes() {
        return "data-institution=\"" + ((Trainer) user).getInstitution() + "\"\n" +
                "data-graduationyear=\"" + ((Trainer) user).getGraduationYear() + "\"\n" +
                "data-instagramLink=\"" + ((Trainer) user).getInstagramLink() + "\"\n" +
                "data-rating=\"" + ((Trainer) user).getRating() + "\">\n";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }
}
