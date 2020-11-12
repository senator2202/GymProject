package com.kharitonov.gym.model.service;

import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.Trainer;
import com.kharitonov.gym.model.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Find user optional.
     *
     * @param parameters the parameters
     * @return the optional
     * @throws ServiceException the service exception
     */
    Optional<User> findUser(Map<String, String> parameters) throws ServiceException;

    /**
     * Register user optional.
     *
     * @param parameters the parameters
     * @return the optional
     * @throws ServiceException the service exception
     */
    Optional<User> registerUser(Map<String, String> parameters) throws ServiceException;

    /**
     * Confirm account boolean.
     *
     * @param accountId the account id
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean confirmAccount(String accountId) throws ServiceException;

    /**
     * Update account data boolean.
     *
     * @param user           the user
     * @param email          the email
     * @param locale         the locale
     * @param newPassword    the new password
     * @param repeatPassword the repeat password
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean updateAccountData(User user, String email, String locale, String newPassword, String repeatPassword)
            throws ServiceException;

    /**
     * Update personal data boolean.
     *
     * @param userId    the user id
     * @param firstName the first name
     * @param lastName  the last name
     * @param phone     the phone
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean updatePersonalData(int userId, String firstName, String lastName, String phone) throws ServiceException;

    /**
     * Find recent users list.
     *
     * @param daysNumber the days number
     * @return the list
     * @throws ServiceException the service exception
     */
    List<User> findRecentUsers(String daysNumber) throws ServiceException;

    /**
     * Update user image boolean.
     *
     * @param userId    the user id
     * @param imageName the image name
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean updateUserImage(int userId, String imageName) throws ServiceException;

    /**
     * Buy trainings boolean.
     *
     * @param client          the client
     * @param trainingsNumber the trainings number
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean buyTrainings(Client client, String trainingsNumber) throws ServiceException;

    /**
     * Find all trainers list.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Trainer> findAllTrainers() throws ServiceException;

    /**
     * Add to balance boolean.
     *
     * @param client the client
     * @param amount the amount
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean addToBalance(Client client, String amount) throws ServiceException;

    /**
     * Find email by id optional.
     *
     * @param userId the user id
     * @return the optional
     * @throws ServiceException the service exception
     */
    Optional<String> findEmailById(int userId) throws ServiceException;

    /**
     * Block user boolean.
     *
     * @param userId the user id
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean blockUser(String userId) throws ServiceException;

    /**
     * Unblock user boolean.
     *
     * @param userId the user id
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean unblockUser(String userId) throws ServiceException;

    /**
     * Update discount boolean.
     *
     * @param clientId the client id
     * @param discount the discount
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean updateDiscount(String clientId, String discount) throws ServiceException;

    /**
     * Update short summary boolean.
     *
     * @param trainerId    the trainer id
     * @param shortSummary the short summary
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean updateShortSummary(int trainerId, String shortSummary) throws ServiceException;
}
