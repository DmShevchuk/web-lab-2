package com.example.weblab2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Shoot {
    private double x;
    private double y;
    private double r;
    private boolean result;
    @JsonIgnore
    private LocalDateTime currentTime;
    private long executionTime;

    public String convertToJson() throws IOException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return objectWriter.writeValueAsString(this);
    }
}
