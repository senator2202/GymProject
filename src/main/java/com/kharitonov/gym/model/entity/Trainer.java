package com.kharitonov.gym.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Trainer extends User {
    private String institution;
    private int graduationYear;
    private String instagramLink;
    private String shortSummary;
    private double rating;

    public Trainer() {
        account = Account.AccountBuilder.anAccount().build();
        account.setRole(UserRole.TRAINER);
    }

    public Trainer(Account account) {
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

    public String getShortSummary() {
        return shortSummary;
    }

    public void setShortSummary(String shortSummary) {
        this.shortSummary = shortSummary;
    }
}
