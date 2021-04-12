package by.epamtc.final_task.service.validation;

/**
 * Class for validating user data
 */
public class UserValidator {

    private static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w]{2,4}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-zа-я])(?=.*[A-ZА-Я]).{6,20}$";
    private static final String NAME_PATTERN = "[A-Za-zА-Яа-яЁё]+(\\s+[A-Za-zА-Яа-яЁё]+)?";
    private static final String LAST_NAME_PATTERN = "[A-Za-zА-Яа-яЁё]{2,15}";
    private static final UserValidator instance = new UserValidator();

    private UserValidator() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static UserValidator getInstance() {
        return instance;
    }

    /**
     * Check if value of email is right
     *
     * @param email the user email
     * @return the boolean
     */
    public boolean isRightEmail(String email) {
        return email.matches(EMAIL_PATTERN);
    }

    /**
     * Check if value of password is right
     *
     * @param enteredPassword the enteredPassword
     * @return the boolean
     */
    public boolean isRightPassword(String enteredPassword) {
        return enteredPassword.matches(PASSWORD_PATTERN);
    }

    /**
     * Check if value of name is right
     *
     * @param name the user name
     * @return the boolean
     */
    public boolean isRightName(String name) {
        return name.matches(NAME_PATTERN);
    }

    /**
     * Check if value of lastname is right
     *
     * @param lastName the user lastname
     * @return the boolean
     */
    public boolean isRightLastName(String lastName) {
        return lastName.matches(LAST_NAME_PATTERN);
    }
}

