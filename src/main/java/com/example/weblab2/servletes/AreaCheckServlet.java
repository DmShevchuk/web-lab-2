package com.example.weblab2.servletes;

import com.example.weblab2.utils.HitStorage;
import com.example.weblab2.domain.Shoot;
import jakarta.ws.rs.core.MediaType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Сервлет, определяющий попадание/непопадание в область
 * */
@WebServlet(name = "areaCheckServlet", value = "/area-checker")
public class AreaCheckServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON);

        try {
            double x = Double.parseDouble(request.getParameter("x"));
            double y = Double.parseDouble(request.getParameter("y"));
            double r = Double.parseDouble(request.getParameter("r"));

            if (validate(x, y, r)) {
                Shoot shoot = getShotResult(x, y, r);
                HitStorage hitStorage = (HitStorage) getServletContext().getAttribute("hitStorage");
                hitStorage.add(shoot);
//                response.setHeader("Cache-Control", "no-cache");
//                response.setContentType("application/json; charset=UTF-8");
//                response.getWriter().println(
//                        hitStorage.getHitList()
//                                .get(hitStorage.getHitList().size() - 1)
//                                .convertToJson()
//                );
//                response.getWriter().close();
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }else {
                throw new Exception();
            }
        } catch (Exception e) {
            response.setContentType(MediaType.APPLICATION_JSON);
            response.sendError(400, "Некорректные данные");
        }
    }

    private boolean validate(double x, double y, double r) {
        List<Double> rCorrectValues = Arrays.asList(1.0, 1.5, 2.0, 2.5, 3.0);

        return -4 <= x && x <= 4
                && -5 <= y && y <= 5
                && rCorrectValues.contains(r);
    }


    private Shoot getShotResult(double x, double y, double r){
        long startTime = System.nanoTime();

        Shoot shoot = new Shoot();
        shoot.setCurrentTime(LocalDateTime.now());
        shoot.setResult(checkHit(x, y, r));
        shoot.setX(x);
        shoot.setY(y);
        shoot.setR(r);
        shoot.setExecutionTime(System.nanoTime() - startTime);

        return shoot;
    }

    private boolean checkHit(double x, double y, double r){
        return (x >= 0 && y >= 0 && x + y <= r)
                || (x < 0 && y < 0 && x * x + y * y <= r * r)
                || (x > 0 && y < 0 && x <= r && -1 * y <= r);
    }
}