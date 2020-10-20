package com.kharitonov.gym.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Trainer extends User {
    private List<Training> plannedTrainings;
    private String institution;
    private int graduationYear;
    private String instagramLink;
    private double rating;

    public Trainer() {
        plannedTrainings = new ArrayList<>();
        account = Account.AccountBuilder.anAccount().build();
        account.setRole(UserRole.TRAINER);
    }

    public Trainer(Account account) {
        plannedTrainings = new ArrayList<>();
        account.setRole(UserRole.TRAINER);
        this.account = account;
    }

    public Trainer(Account account, String firstName,
                   String lastName, String phoneNumber) {
        super(account, firstName, lastName, phoneNumber);
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getInstagramLink() {
        return instagramLink;
    }

    public void setInstagramLink(String instagramLink) {
        this.instagramLink = instagramLink;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setPlannedTrainings(List<Training> plannedTrainings) {
        this.plannedTrainings = plannedTrainings;
    }
}
