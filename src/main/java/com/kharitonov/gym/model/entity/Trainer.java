package com.kharitonov.gym.model.entity;

import com.kharitonov.gym.model.builder.AccountBuilder;

/**
 * The type Trainer.
 */
public class Trainer extends User {
    private String institution;
    private int graduationYear;
    private String instagramLink;
    private String shortSummary;
    private double rating;

    /**
     * Instantiates a new Trainer.
     */
    public Trainer() {
        account = AccountBuilder.anAccount().build();
        account.setRole(UserRole.TRAINER);
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
     * Gets rating.
     *
     * @return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Gets short summary.
     *
     * @return the short summary
     */
    public String getShortSummary() {
        return shortSummary;
    }

    /**
     * Sets short summary.
     *
     * @param shortSummary the short summary
     */
    public void setShortSummary(String shortSummary) {
        this.shortSummary = shortSummary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Trainer trainer = (Trainer) o;

        if (graduationYear != trainer.graduationYear) {
            return false;
        }
        if (Double.compare(trainer.rating, rating) != 0) {
            return false;
        }
        if (institution != null ? !institution.equals(trainer.institution) : trainer.institution != null) {
            return false;
        }
        if (instagramLink != null ? !instagramLink.equals(trainer.instagramLink) : trainer.instagramLink != null) {
            return false;
        }
        if (shortSummary != null ? !shortSummary.equals(trainer.shortSummary) : trainer.shortSummary != null) {
            return false;
        }
        return super.equals((User) o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (institution != null ? institution.hashCode() : 0);
        result = 31 * result + graduationYear;
        result = 31 * result + (instagramLink != null ? instagramLink.hashCode() : 0);
        result = 31 * result + (shortSummary != null ? shortSummary.hashCode() : 0);
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Trainer{");
        sb.append("institution='").append(institution).append('\'');
        sb.append(", graduationYear=").append(graduationYear);
        sb.append(", instagramLink='").append(instagramLink).append('\'');
        sb.append(", shortSummary='").append(shortSummary).append('\'');
        sb.append(", rating=").append(rating);
        sb.append(", account=").append(account);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", imageName='").append(imageName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
