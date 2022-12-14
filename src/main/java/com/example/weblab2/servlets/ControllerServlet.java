package com.example.weblab2.servlets;

import com.example.weblab2.utils.HitStorage;
import com.example.weblab2.utils.LastResultHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Основной сервлет приложения, принимающий все запросы
 * */
@WebServlet(name = "controllerServlet", value = "/main")
public class ControllerServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        getServletContext().setAttribute("hitStorage", new HitStorage());
        getServletContext().setAttribute("lastResultHandler", new LastResultHandler());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String queryParam = request.getParameter("q");

        if ("history".equals(queryParam)){
            getServletContext().getRequestDispatcher("/history").forward(request, response);
            return;
        }

        getServletContext().getRequestDispatcher("/area-checker").forward(request, response);
    }
}
