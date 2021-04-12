package by.epamtc.final_task.service.validation;

/**
 * Class for validating user results data
 */
public class ResultUserValidator {
    private static final int MAXIMAL_MARK = 10;
    private static final int MINIMAL_MARK = 0;
    private static final String COMMENT_PATTERN = ".{3,500}";

    private static final ResultUserValidator instance = new ResultUserValidator();

    private ResultUserValidator() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ResultUserValidator getInstance() {
        return instance;
    }

    /**
     * Check if value of comment is right
     *
     * @param enteredComment the enteredComment
     * @return the boolean
     */
    public boolean isRightComment(String enteredComment) {
        return enteredComment.matches(COMMENT_PATTERN);
    }

    /**
     * Check if value of mark is right
     *
     * @param mark the mark
     * @return the boolean
     */
    public boolean isRightMark(int mark) {
        return mark >= MINIMAL_MARK && mark <= MAXIMAL_MARK;
    }
}
