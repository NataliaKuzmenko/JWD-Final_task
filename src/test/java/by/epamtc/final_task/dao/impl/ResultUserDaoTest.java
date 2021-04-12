package by.epamtc.final_task.dao.impl;

import by.epamtc.final_task.dao.ResultUserDao;
import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.entity.ResultUser;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class ResultUserDaoTest {
    private final ResultUserDao resultUserDao = ResultUserDaoImpl.getInstance();

    @Test
    public void findResultUserNegativeTest() throws DaoException {
        long userId = 3;
        long courseId = 1;
        ResultUser expected = new ResultUser(1, 6, "Внимательный студент", ResultUser.UserCourseStatus.APPLIED);
        ResultUser actual = resultUserDao.findResultUser(userId, courseId);
        assertNotEquals(expected, actual);
    }
}
