package com.kharitonov.gym.model.entity;

import java.util.List;

public class Diet {
    private int dietId;
    private DietType type;
    private List<Meal> meals;

    public enum DietType {
        SLIMMING, WEIGHT_GAIN, KEEPING_SHAPE;
    }
}
