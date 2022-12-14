package com.example.weblab2.servlets;

import com.example.weblab2.utils.HitStorage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет для удаления всех данных о выстрелах
 * */
@WebServlet(name = "clearHistoryServlet", value = "/history")
public class ClearHistoryServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HitStorage hitStorage = (HitStorage) getServletContext().getAttribute("hitStorage");
        hitStorage.clear();
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
