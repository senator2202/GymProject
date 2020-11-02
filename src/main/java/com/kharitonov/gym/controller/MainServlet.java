package com.kharitonov.gym.controller;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.model.pool.impl.BasicConnectionPool;
import com.kharitonov.gym.util.RequestParameterName;
import com.kharitonov.gym.util.SessionAttributeName;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

@WebServlet(urlPatterns = "/mainController")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = processRequest(request);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        request.getSession().setAttribute(SessionAttributeName.PREVIOUS_PAGE, page);
        saveRequestAttributes(request);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = processRequest(request);
        response.sendRedirect(page);
    }

    private String processRequest(HttpServletRequest request) {
        String commandName = request.getParameter(RequestParameterName.COMMAND);
        ActionCommand command = CommandProvider.defineCommand(commandName);
        String page = command.execute(request);
        return page;
    }

    private void saveRequestAttributes(HttpServletRequest request) {
        Enumeration<String> attrNames = request.getAttributeNames();
        Iterator<String> iterator = attrNames.asIterator();
        RequestAttributesWrapper wrapper = new RequestAttributesWrapper();
        while (iterator.hasNext()) {
            String name = iterator.next();
            Object value = request.getAttribute(name);
            wrapper.put(name, value);
        }
        request.getSession().setAttribute(SessionAttributeName.SAVED_ATTRIBUTES, wrapper);
    }

    @Override
    public void init() throws ServletException {
        BasicConnectionPool.getInstance();
    }

    @Override
    public void destroy() {
        BasicConnectionPool.getInstance().destroyPool();
    }
}
