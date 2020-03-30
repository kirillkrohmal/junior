package ru.job4j.servlet;

import ru.job4j.validator.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JspServlet extends HttpServlet {
    private final Validator validator = Validator.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("haller", this.validator.values());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jspviewer.jsp");

        dispatcher.forward(req, resp);
    }
}
