package com.example.weblab2.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HitStorage implements Serializable {
    private List<Shoot> hitList = Collections.synchronizedList(new LinkedList<>());

    public void add(Shoot shoot) {
        hitList.add(shoot);
    }

    public void clear() {
        hitList.clear();
    }
}