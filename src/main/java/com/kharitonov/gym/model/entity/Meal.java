package com.kharitonov.gym.model.entity;

public class Meal {
    private int mealId;
    private MealType type;
    private String description;

    public enum MealType {
        BREAKFAST, LUNCH, DINNER, SUPPER
    }
}
