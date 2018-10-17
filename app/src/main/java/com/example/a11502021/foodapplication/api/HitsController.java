package com.example.a11502021.foodapplication.api;

import com.example.a11502021.foodapplication.models.Example;

public class HitsController {

    private static Example hits;

    public static void setHits(Example hits) {
        HitsController.hits = hits;
    }

    public static Example getHits() {
        return HitsController.hits;
    }

}
