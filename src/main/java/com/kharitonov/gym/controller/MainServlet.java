package com.kharitonov.gym.controller;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.provider.CommandProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mainController")
public class MainServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        String commandName = request.getParameter(RequestParameter.COMMAND);
        ActionCommand command = CommandProvider.defineCommand(commandName);
        String page = command.execute(request);
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
