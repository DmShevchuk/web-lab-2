package com.example.weblab2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllerServlet", value = "/main")
public class ControllerServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getParameter("x"));
        System.out.println(request.getParameter("y"));
        System.out.println(request.getParameter("r"));
    }
}
