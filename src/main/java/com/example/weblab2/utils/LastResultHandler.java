package com.example.weblab2.utils;

import com.example.weblab2.domain.Shoot;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class LastResultHandler {
    private Shoot shoot;

    public String formatShoot(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return "<tr>" +
                "<td>" + String.format("%.2f", shoot.getX()) + "</td>" +
                "<td>" + String.format("%.2f", shoot.getY()) + "</td>" +
                "<td>" + String.format("%.1f", shoot.getR()) + "</td>" +
                "<td>" +
                (shoot.isResult() ? "<span style='color: green'>HIT" : "<span style='color: red'>MISS") +
                "</span>" +
                "</td>" +
                "<td>" + formatter.format(shoot.getCurrentTime()) + "</td>" +
                "<td>" + shoot.getExecutionTime() + "</td>" +
                "</td>";
    }
}
