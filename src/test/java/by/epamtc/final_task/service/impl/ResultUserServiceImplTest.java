package by.epamtc.final_task.service.impl;

import by.epamtc.final_task.dao.ResultUserDao;
import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.dao.impl.ResultUserDaoImpl;
import by.epamtc.final_task.entity.ResultUser;
import by.epamtc.final_task.service.ResultUserService;
import by.epamtc.final_task.service.exception.ServiceException;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ResultUserServiceImplTest {
    private ResultUserDao resultUserDao;
    private ResultUserService resultUserService;

    @BeforeTest
    public void init() {
        resultUserDao = mock(ResultUserDaoImpl.class);
        Whitebox.setInternalState(ResultUserDaoImpl.class, "instance", resultUserDao);
        resultUserService = ResultUserServiceImpl.getInstance();
    }

    @Test
    public void findResultUserPositiveTest() throws DaoException, ServiceException {
        ResultUser expected = new ResultUser(1, 6, "Внимательный студент", ResultUser.UserCourseStatus.APPLIED);
        when(resultUserDao.findResultUser(3, 1)).thenReturn(expected);
        ResultUser actual = resultUserService.findResultUser(3, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void findResultUserNegativeTest() throws ServiceException, DaoException {
        ResultUser expected = new ResultUser(2, 7, "Отличный студент.", ResultUser.UserCourseStatus.TRAINING_IN_PROGRESS);
        when(resultUserDao.findResultUser(4, 1)).thenReturn(expected);
        ResultUser actual = resultUserService.findResultUser(15, 1);
        assertNotEquals(expected, actual);
    }
}
