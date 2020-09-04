package com.kharitonov.gym.model.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Training {
    private int trainingId;
    private int trainerId;
    private int clientId;
    private double cost;
    private Date date;
    private Time startTime;
    private Time endTime;
    private List<Exercise> exercises;
}
