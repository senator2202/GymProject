package com.kharitonov.gym.model.entity;

import java.sql.Date;

/**
 * The type Trainer application.
 */
public class TrainerApplication {
    private User user;
    private String institution;
    private int graduationYear;
    private String instagramLink;
    private Date applicationDate;

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets institution.
     *
     * @return the institution
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * Sets institution.
     *
     * @param institution the institution
     */
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    /**
     * Gets graduation year.
     *
     * @return the graduation year
     */
    public int getGraduationYear() {
        return graduationYear;
    }

    /**
     * Sets graduation year.
     *
     * @param graduationYear the graduation year
     */
    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    /**
     * Gets instagram link.
     *
     * @return the instagram link
     */
    public String getInstagramLink() {
        return instagramLink;
    }

    /**
     * Sets instagram link.
     *
     * @param instagramLink the instagram link
     */
    public void setInstagramLink(String instagramLink) {
        this.instagramLink = instagramLink;
    }

    /**
     * Gets application date.
     *
     * @return the application date
     */
    public Date getApplicationDate() {
        return applicationDate;
    }

    /**
     * Sets application date.
     *
     * @param applicationDate the application date
     */
    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TrainerApplication that = (TrainerApplication) o;

        if (graduationYear != that.graduationYear) {
            return false;
        }
        if (user != null ? !user.equals(that.user) : that.user != null) {
            return false;
        }
        if (institution != null ? !institution.equals(that.institution) : that.institution != null) {
            return false;
        }
        if (instagramLink != null ? !instagramLink.equals(that.instagramLink) : that.instagramLink != null) {
            return false;
        }
        if (applicationDate != null ? !applicationDate.equals(that.applicationDate) : that.applicationDate != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (institution != null ? institution.hashCode() : 0);
        result = 31 * result + graduationYear;
        result = 31 * result + (instagramLink != null ? instagramLink.hashCode() : 0);
        result = 31 * result + (applicationDate != null ? applicationDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TrainerApplication{");
        sb.append("user=").append(user);
        sb.append(", institution='").append(institution).append('\'');
        sb.append(", graduationYear=").append(graduationYear);
        sb.append(", instagramLink='").append(instagramLink).append('\'');
        sb.append(", applicationDate=").append(applicationDate);
        sb.append('}');
        return sb.toString();
    }
}
