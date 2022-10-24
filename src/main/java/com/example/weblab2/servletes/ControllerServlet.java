package com.example.weblab2.servletes;

import com.example.weblab2.utils.HitStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllerServlet", value = "/main")
public class ControllerServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        getServletContext().setAttribute("hitStorage", new HitStorage());
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
