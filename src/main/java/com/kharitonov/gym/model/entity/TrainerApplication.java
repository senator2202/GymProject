package com.kharitonov.gym.model.entity;

import java.sql.Date;

public class TrainerApplication {
    private User user;
    private String institution;
    private int graduationYear;
    private String instagramLink;
    private Date applicationDate;

    private TrainerApplication() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }


    public static final class TrainerApplicationBuilder {
        private User user;
        private String institution;
        private int graduationYear;
        private String instagramLink;
        private Date applicationDate;

        private TrainerApplicationBuilder() {
        }

        public static TrainerApplicationBuilder aTrainerApplication() {
            return new TrainerApplicationBuilder();
        }

        public TrainerApplicationBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public TrainerApplicationBuilder withInstitution(String institution) {
            this.institution = institution;
            return this;
        }

        public TrainerApplicationBuilder withGraduationYear(int graduationYear) {
            this.graduationYear = graduationYear;
            return this;
        }

        public TrainerApplicationBuilder withInstagramLink(String instagramLink) {
            this.instagramLink = instagramLink;
            return this;
        }

        public TrainerApplicationBuilder withApplicationDate(Date applicationDate) {
            this.applicationDate = applicationDate;
            return this;
        }

        public TrainerApplication build() {
            TrainerApplication trainerApplication = new TrainerApplication();
            trainerApplication.setUser(user);
            trainerApplication.setInstitution(institution);
            trainerApplication.setGraduationYear(graduationYear);
            trainerApplication.setInstagramLink(instagramLink);
            trainerApplication.setApplicationDate(applicationDate);
            return trainerApplication;
        }
    }
}
