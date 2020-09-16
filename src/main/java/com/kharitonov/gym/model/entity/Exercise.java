package com.kharitonov.gym.model.entity;


public class Exercise {
    private ExerciseType type;
    private double weight;

    public enum ExerciseType {
        BENCH_PRESS,
        DEADLIFT,
        SQUATS
    }
}
