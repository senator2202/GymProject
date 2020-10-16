package com.kharitonov.gym.model.entity;

import java.util.List;

public class Diet {
    private int dietId;
    private DietType type;
    private String dietDescription;

    public enum DietType {
        SLIMMING, WEIGHT_GAIN, KEEPING_SHAPE
    }
}
