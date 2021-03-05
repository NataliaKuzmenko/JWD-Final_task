package by.epamtc.final_task.service.validation;

public class UserValidator {

    private static UserValidator instance = new UserValidator();

    private static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w]{2,4}$";

    private static final String PASSWORD_PATTERN = "\\w{3,15}";


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

}

