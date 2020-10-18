package com.kharitonov.gym.model.entity;

public class Diet {
    private int dietId;
    private DietType type;
    private String dietDescription;

    public enum DietType {
        SLIMMING, WEIGHT_GAIN, KEEPING_SHAPE
    }
}
