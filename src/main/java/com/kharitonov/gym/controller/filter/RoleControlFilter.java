package com.kharitonov.gym.controller.filter;

import com.kharitonov.gym.controller.command.CommandType;
import com.kharitonov.gym.controller.command.NavigationPath;
import com.kharitonov.gym.controller.command.RequestParameterName;
import com.kharitonov.gym.controller.command.SessionAttributeName;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebFilter(urlPatterns = {"/mainController"})
public class RoleControlFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(RoleControlFilter.class);
    private static final Map<String, List<UserRole>> CONTROL_MAP;

    static {
        CONTROL_MAP = new HashMap<>();
        CONTROL_MAP.put(CommandType.ADD_FEEDBACK.toString().toLowerCase(),
                Arrays.asList(UserRole.TRAINER, UserRole.CLIENT, UserRole.GUEST));
        CONTROL_MAP.put(CommandType.ADD_TRAINING.toString().toLowerCase(),
                Arrays.asList(UserRole.CLIENT));
        CONTROL_MAP.put(CommandType.APPROVE_TRAINER_APPLICATION.toString().toLowerCase(),
                Arrays.asList(UserRole.ADMIN));
        CONTROL_MAP.put(CommandType.BUY_TRAININGS.toString().toLowerCase(),
                Arrays.asList(UserRole.CLIENT));
        CONTROL_MAP.put(CommandType.CANCEL_TRAINING.toString().toLowerCase(),
                Arrays.asList(UserRole.TRAINER, UserRole.CLIENT));
        CONTROL_MAP.put(CommandType.CHANGE_ADMIN_LOCALE.toString().toLowerCase(),
                Arrays.asList(UserRole.ADMIN));
        CONTROL_MAP.put(CommandType.CONFIRM_ACCOUNT.toString().toLowerCase(),
                Arrays.asList(UserRole.TRAINER, UserRole.CLIENT, UserRole.GUEST, UserRole.ADMIN));
        CONTROL_MAP.put(CommandType.INVALID.toString().toLowerCase(),
                Arrays.asList(UserRole.TRAINER, UserRole.CLIENT, UserRole.GUEST, UserRole.ADMIN));
        CONTROL_MAP.put(CommandType.LOGIN.toString().toLowerCase(),
                Arrays.asList(UserRole.GUEST));
        CONTROL_MAP.put(CommandType.LOGOUT.toString().toLowerCase(),
                Arrays.asList(UserRole.TRAINER, UserRole.CLIENT, UserRole.ADMIN));
        CONTROL_MAP.put(CommandType.MAKE_DEPOSIT.toString().toLowerCase(),
                Arrays.asList(UserRole.CLIENT));
        CONTROL_MAP.put(CommandType.OPEN_ABOUT.toString().toLowerCase(),
                Arrays.asList(UserRole.TRAINER, UserRole.CLIENT, UserRole.GUEST, UserRole.ADMIN));
        CONTROL_MAP.put(CommandType.OPEN_ACCOUNT_DATA.toString().toLowerCase(),
                Arrays.asList(UserRole.TRAINER, UserRole.CLIENT));
        CONTROL_MAP.put(CommandType.OPEN_ADMIN_FEEDBACKS.toString().toLowerCase(),
                Arrays.asList(UserRole.ADMIN));
        CONTROL_MAP.put(CommandType.OPEN_ADMIN_MAIN.toString().toLowerCase(),
                Arrays.asList(UserRole.ADMIN));
        CONTROL_MAP.put(CommandType.OPEN_ADMIN_REGISTRATIONS.toString().toLowerCase(),
                Arrays.asList(UserRole.ADMIN));
        CONTROL_MAP.put(CommandType.OPEN_CONTACTS.toString().toLowerCase(),
                Arrays.asList(UserRole.TRAINER, UserRole.CLIENT, UserRole.GUEST, UserRole.ADMIN));
        CONTROL_MAP.put(CommandType.OPEN_HOME.toString().toLowerCase(),
                Arrays.asList(UserRole.TRAINER, UserRole.CLIENT, UserRole.GUEST, UserRole.ADMIN));
        CONTROL_MAP.put(CommandType.ADD_FEEDBACK.toString().toLowerCase(),
                Arrays.asList(UserRole.TRAINER, UserRole.CLIENT, UserRole.GUEST));
        CONTROL_MAP.put(CommandType.OPEN_PERSONAL_DATA.toString().toLowerCase(),
                Arrays.asList(UserRole.TRAINER, UserRole.CLIENT));
        CONTROL_MAP.put(CommandType.OPEN_PERSONAL_FINANCE.toString().toLowerCase(),
                Arrays.asList(UserRole.CLIENT));
        CONTROL_MAP.put(CommandType.OPEN_PORTFOLIO.toString().toLowerCase(),
                Arrays.asList(UserRole.TRAINER, UserRole.CLIENT, UserRole.GUEST, UserRole.ADMIN));
        CONTROL_MAP.put(CommandType.OPEN_SCHEDULE.toString().toLowerCase(),
                Arrays.asList(UserRole.TRAINER, UserRole.CLIENT));
        CONTROL_MAP.put(CommandType.REFUSE_TRAINER_APPLICATION.toString().toLowerCase(),
                Arrays.asList(UserRole.ADMIN));
        CONTROL_MAP.put(CommandType.REGISTER.toString().toLowerCase(),
                Arrays.asList(UserRole.GUEST));
        CONTROL_MAP.put(CommandType.SEND_TRAINER_APPLICATION.toString().toLowerCase(),
                Arrays.asList(UserRole.CLIENT));
        CONTROL_MAP.put(CommandType.UPDATE_ACCOUNT_DATA.toString().toLowerCase(),
                Arrays.asList(UserRole.TRAINER, UserRole.CLIENT));
        CONTROL_MAP.put(CommandType.UPDATE_PERSONAL_DATA.toString().toLowerCase(),
                Arrays.asList(UserRole.TRAINER, UserRole.CLIENT));
        CONTROL_MAP.put(CommandType.UPDATE_TRAINING_DESCRIPTION.toString().toLowerCase(),
                Arrays.asList(UserRole.TRAINER));
        CONTROL_MAP.put(CommandType.UPLOAD_IMAGE.toString().toLowerCase(),
                Arrays.asList(UserRole.TRAINER, UserRole.CLIENT));
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if (!response.isCommitted()) {
            String command = request.getParameter(RequestParameterName.COMMAND);
            if (isValidCommand(command)) {
                HttpSession session = request.getSession();
                List<UserRole> roles = CONTROL_MAP.get(command);
                User user = (User) session.getAttribute(SessionAttributeName.USER);
                UserRole role = user == null ? UserRole.GUEST : user.getAccount().getRole();
                if (!roles.contains(role)) {
                    LOGGER.warn("Filter interception: '{}' attempted to execute '{}' command ", role, command);
                    response.sendRedirect(request.getContextPath() + NavigationPath.INDEX);
                } else {
                    String url = request.getRequestURI();
                    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                    dispatcher.forward(request, response);
                }
            } else {
                LOGGER.warn("Filter interception: attemption to execute invalid command!");
                RequestDispatcher dispatcher = request.getRequestDispatcher(NavigationPath.INVALID);
                dispatcher.forward(request, response);
            }
            chain.doFilter(request, response);
        }
    }

    private boolean isValidCommand(String command) {
        return command != null && CONTROL_MAP.containsKey(command);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
