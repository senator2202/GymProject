package com.kharitonov.gym.model.entity;

import java.sql.Date;

public class TrainerApplication {
    private int userId;
    private String firstName;
    private String lastName;
    private String institution;
    private int graduationYear;
    private String instagramLink;
    private Date applicationDate;

    private TrainerApplication() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        private int id;
        private String firstName;
        private String lastName;
        private String institution;
        private int graduationYear;
        private String instagramLink;
        private Date applicationDate;

        private TrainerApplicationBuilder() {
        }

        public static TrainerApplicationBuilder aTrainerApplication() {
            return new TrainerApplicationBuilder();
        }

        public TrainerApplicationBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public TrainerApplicationBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public TrainerApplicationBuilder withLastName(String lastName) {
            this.lastName = lastName;
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
            trainerApplication.setUserId(id);
            trainerApplication.setFirstName(firstName);
            trainerApplication.setLastName(lastName);
            trainerApplication.setInstitution(institution);
            trainerApplication.setGraduationYear(graduationYear);
            trainerApplication.setInstagramLink(instagramLink);
            trainerApplication.setApplicationDate(applicationDate);
            return trainerApplication;
        }
    }
}
