package com.kharitonov.gym.model.entity.functionality;

import com.kharitonov.gym.model.entity.Training;

import java.util.List;

public interface SportFunctionality {
    void doTraining(Training training);

    List<Training> allPlannedTrainings();
}
