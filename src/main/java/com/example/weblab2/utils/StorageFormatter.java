package com.example.weblab2.utils;

import com.example.weblab2.domain.HitStorage;
import com.example.weblab2.domain.Shoot;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class StorageFormatter {
    public static String getRows(HitStorage hitStorage) {
        List<Shoot> hitList = hitStorage.getHitList();
        ListIterator<Shoot> hitListIterator = hitList.listIterator(hitList.size());
        StringBuilder rows = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        while (hitListIterator.hasPrevious()) {
            Shoot shoot = hitListIterator.previous();
            rows.append("<tr>")
                    .append("<td>").append(String.format("%.2f", shoot.getX())).append("</td>")

                    .append("<td>").append(String.format("%.2f", shoot.getY())).append("</td>")

                    .append("<td>").append(String.format("%.1f", shoot.getR())).append("</td>")

                    .append("<td>")
                    .append(shoot.isResult() ? "<span style='color: green'>HIT" : "<span style='color: red'>MISS")
                    .append("</span>")
                    .append("</td>")

                    .append("<td>").append(formatter.format(shoot.getCurrentTime())).append("</td>")

                    .append("<td>").append(shoot.getExecutionTime()).append("</td>")

                    .append("</td>");
        }
        return rows.toString();
    }

    public static Set<String> getJson(HitStorage hitStorage) {
        Set<String> jsonShootList = new HashSet<>();
        hitStorage.getHitList().forEach(hit -> {
            String jsonHit = null;
            try {
                jsonHit = hit.convertToJson();
            } catch (IOException ignored) {}
            jsonShootList.add(jsonHit);
        });
        return jsonShootList;
    }
}
