package com.kharitonov.gym.model.dao;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.Trainer;
import com.kharitonov.gym.model.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * The interface User dao.
 */
public interface UserDao extends BaseDao {
    /**
     * Add new user int.
     *
     * @param login             the login
     * @param encryptedPassword the encrypted password
     * @param email             the email
     * @return the int
     * @throws DaoException the dao exception
     */
    int add(String login, String encryptedPassword, String email) throws DaoException;

    /**
     * Find user by login password optional.
     *
     * @param name              the name
     * @param encryptedPassword the encrypted password
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<User> findUserByLoginPassword(String name, String encryptedPassword) throws DaoException;

    /**
     * Find user by id optional.
     *
     * @param userId the user id
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<User> findUserById(int userId) throws DaoException;

    /**
     * Check if login exists boolean.
     *
     * @param login the login
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean loginExists(String login) throws DaoException;

    /**
     * Find id by email int.
     *
     * @param email the email
     * @return the int: user id if email exists, 0 if not
     * @throws DaoException the dao exception
     */
    int findIdByEmail(String email) throws DaoException;

    /**
     * Confirm account boolean.
     *
     * @param id the id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean confirmAccount(int id) throws DaoException;

    /**
     * Update account data boolean.
     *
     * @param userId   the user id
     * @param email    the email
     * @param locale   the locale
     * @param password the password
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateAccountData(int userId, String email, String locale, String password) throws DaoException;

    /**
     * Update personal data boolean.
     *
     * @param userId    the user id
     * @param firstName the first name
     * @param lastName  the last name
     * @param phone     the phone
     * @param instagram
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updatePersonalData(int userId, String firstName, String lastName, String phone, String instagram)
            throws DaoException;

    /**
     * Find recent users list.
     *
     * @param days the days
     * @return the list
     * @throws DaoException the dao exception
     */
    List<User> findRecentUsers(int days) throws DaoException;

    /**
     * Update user image boolean.
     *
     * @param userId    the user id
     * @param imageName the image name
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateUserImage(int userId, String imageName) throws DaoException;

    /**
     * Update balance and bought trainings boolean.
     *
     * @param userId            the user id
     * @param decreaseBalance   the decrease balance
     * @param increaseTrainings the increase trainings
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateBalanceAndBoughtTrainings(int userId, double decreaseBalance, int increaseTrainings)
            throws DaoException;

    /**
     * Find all trainers list.
     *
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Trainer> findAllTrainers() throws DaoException;

    /**
     * Add to balance boolean.
     *
     * @param userId the user id
     * @param amount the amount
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean addToBalance(int userId, int amount) throws DaoException;

    /**
     * Find email by id optional.
     *
     * @param userId the user id
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<String> findEmailById(int userId) throws DaoException;

    /**
     * Block user boolean.
     *
     * @param userId the user id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean blockUser(int userId) throws DaoException;

    /**
     * Unblock user boolean.
     *
     * @param userId the user id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean unblockUser(int userId) throws DaoException;

    /**
     * Update discount boolean.
     *
     * @param clientId the client id
     * @param discount the discount
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateDiscount(int clientId, double discount) throws DaoException;

    /**
     * Update short summary boolean.
     *
     * @param trainerId    the trainer id
     * @param shortSummary the short summary
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateShortSummary(int trainerId, String shortSummary) throws DaoException;

    /**
     * Find password string.
     *
     * @param userId the user id
     * @return the string
     * @throws DaoException the dao exception
     */
    String findPassword(int userId) throws DaoException;
}
