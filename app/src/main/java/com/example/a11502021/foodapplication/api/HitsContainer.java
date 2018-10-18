package com.example.a11502021.foodapplication.api;

import com.example.a11502021.foodapplication.models.Example;

public class HitsContainer {

    private static Example hits;

    public static void setHits(Example hits) {
        HitsContainer.hits = hits;
    }

    public static Example getHits() {
        return HitsContainer.hits;
    }

}
