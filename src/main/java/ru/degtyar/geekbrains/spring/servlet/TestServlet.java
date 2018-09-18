package ru.degtyar.geekbrains.spring.servlet;


import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/TestServlet")
public class TestServlet extends HttpServlet{


    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        resp.getWriter().print("Get Reguest" + name);
    }
}
