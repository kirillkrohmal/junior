package ru.job4j.servlet;

import ru.job4j.model.Hall;
import ru.job4j.validator.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class AddServlet extends HttpServlet {
    private final Validator validator = Validator.getInstance();
    private AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jspcreate.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validator.save(new Hall(atomicInteger.getAndIncrement(), req.getParameter("rows"), req.getParameter("columns")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/list"));
    }
}
