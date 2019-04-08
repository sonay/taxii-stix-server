package com.example.taxii.rest.impl.objects;

import lombok.Data;

@Data
public class Range {

    private int from;

    private int to;

    public Range(int from, int to) {
        this.from = from;
        this.to = to;
    }



}
