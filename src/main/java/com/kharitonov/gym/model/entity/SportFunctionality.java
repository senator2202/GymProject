package com.kharitonov.gym.model.entity;

import java.util.List;

public interface SportFunctionality {
    void doTraining(Training training);

    List<Training> allPlannedTrainings();
}
