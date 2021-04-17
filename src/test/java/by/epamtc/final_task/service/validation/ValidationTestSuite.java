package by.epamtc.final_task.service.validation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HashPasswordTest.class,
        UserValidatorTest.class,
        CourseValidatorTest.class,
        ResultUserValidatorTest.class
})
public class ValidationTestSuite {
}
