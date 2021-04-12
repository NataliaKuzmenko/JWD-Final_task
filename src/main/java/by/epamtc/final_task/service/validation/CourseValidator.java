package by.epamtc.final_task.service.validation;

import by.epamtc.final_task.entity.Course;

import java.time.LocalDate;

/**
 * Class for validating course data
 */
public class CourseValidator {
    private static final String TITLE_PATTERN = ".{3,100}";
    private static final String DESCRIPTION_PATTERN = ".{3,1500}";
    private static final String MAXIMAL_DATE = "2099-12-31";

    private static final CourseValidator instance = new CourseValidator();

        private CourseValidator() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static CourseValidator getInstance() {
        return instance;
    }

    /**
     * Check if value of course title is right
     *
     * @param title the course title
     * @return the boolean
     */
    public boolean isRightTitle(String title) {
        return title.matches(TITLE_PATTERN);
    }

    /**
     * Check if value of course description is right
     *
     * @param description the course description
     * @return the boolean
     */
    public boolean isRightDescription(String description) {
        return description.matches(DESCRIPTION_PATTERN);
    }

    /**
     * Check if value of course start date is right
     *
     * @param startDate the course start date
     * @return the boolean
     */
    public boolean isRightStartDate(LocalDate startDate) {
        LocalDate minDate = LocalDate.now();
        LocalDate maxDate = LocalDate.parse(MAXIMAL_DATE);
        return !startDate.isBefore(minDate) && !startDate.isAfter(maxDate);
    }

    /**
     * Check if value of course end  date is right
     *
     * @param startDate the course start date
     * @param endDate the course end date
     * @return the boolean
     */
    public boolean isRightEndDate(LocalDate startDate, LocalDate endDate) {
        LocalDate minDate = LocalDate.now();
        LocalDate maxDate = LocalDate.parse(MAXIMAL_DATE);
        return !endDate.isBefore(startDate) && !endDate.isBefore(minDate) && !endDate.isAfter(maxDate);
    }

    /**
     * Check if value of course format is right
     *
     * @param format the course format
     * @return the boolean
     */
    public boolean isRightFormat(String format) {
        return Course.FormatCourse.valueOf(format).equals(Course.FormatCourse.ONLINE) ||
                Course.FormatCourse.valueOf(format).equals(Course.FormatCourse.OFFLINE);
    }
}
