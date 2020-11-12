package com.kharitonov.gym.model.builder;

import com.kharitonov.gym.model.entity.Trainer;

/**
 * The type Trainer builder.
 */
public final class TrainerBuilder extends UserBuilder<TrainerBuilder> {

    private TrainerBuilder() {
        user = new Trainer();
    }

    /**
     * A trainer trainer builder.
     *
     * @return the trainer builder
     */
    public static TrainerBuilder aTrainer() {
        return new TrainerBuilder();
    }

    @Override
    public Trainer build() {
        return (Trainer) user;
    }

    /**
     * With institution trainer builder.
     *
     * @param institution the institution
     * @return the trainer builder
     */
    public TrainerBuilder withInstitution(String institution) {
        ((Trainer) user).setInstitution(institution);
        return this;
    }

    /**
     * With graduation year trainer builder.
     *
     * @param graduationYear the graduation year
     * @return the trainer builder
     */
    public TrainerBuilder withGraduationYear(int graduationYear) {
        ((Trainer) user).setGraduationYear(graduationYear);
        return this;
    }

    /**
     * With instagram link trainer builder.
     *
     * @param instagramLink the instagram link
     * @return the trainer builder
     */
    public TrainerBuilder withInstagramLink(String instagramLink) {
        ((Trainer) user).setInstagramLink(instagramLink);
        return this;
    }

    /**
     * With short summary trainer builder.
     *
     * @param shortSummary the short summary
     * @return the trainer builder
     */
    public TrainerBuilder withShortSummary(String shortSummary) {
        ((Trainer) user).setShortSummary(shortSummary);
        return this;
    }

    /**
     * With rating trainer builder.
     *
     * @param rating the rating
     * @return the trainer builder
     */
    public TrainerBuilder withRating(double rating) {
        ((Trainer) user).setRating(rating);
        return this;
    }
}
