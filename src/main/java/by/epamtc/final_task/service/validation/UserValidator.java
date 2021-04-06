package by.epamtc.final_task.service.validation;

public class UserValidator {

    private static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w]{2,4}$";
    private static final String PASSWORD_PATTERN = "\\w{3,15}";
    private static final String NAME_PATTERN = "[A-Za-zА-Яа-яЁё]+(\\s+[A-Za-zА-Яа-яЁё]+)?";
    private static final String LAST_NAME_PATTERN = "[A-Za-zА-Яа-яЁё]{2,15}";
    private static final UserValidator instance = new UserValidator();


    private UserValidator() {
    }

    public static UserValidator getInstance() {
        return instance;
    }

    public boolean isRightEmail(String enteredLogin) {
        return enteredLogin.matches(EMAIL_PATTERN);
    }

    public boolean isRightPassword(String enteredPassword) {
        return enteredPassword.matches(PASSWORD_PATTERN);
    }

    public boolean isRightName(String name) {
        return name.matches(NAME_PATTERN);
    }

    public boolean isRightLastName(String lastName) {
        return lastName.matches(LAST_NAME_PATTERN);
    }
}

