package by.epamtc.final_task.service.impl;

import by.epamtc.final_task.dao.CourseDao;
import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.dao.impl.CourseDaoImpl;
import by.epamtc.final_task.entity.Course;
import by.epamtc.final_task.service.CourseService;
import by.epamtc.final_task.service.exception.ServiceException;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.testng.Assert.assertEquals;

public class CourseServiceImplTest {
    private CourseDao courseDao;
    private CourseService courseService;

    @BeforeTest
    public void init() {
        courseDao = mock(CourseDaoImpl.class);
        Whitebox.setInternalState(CourseDaoImpl.class, "instance", courseDao);
        courseService = CourseServiceImpl.getInstance();
    }

    @Test
    public void findInfoAboutCoursePositiveTest() throws DaoException, ServiceException {
        Course expected = new Course(1, "Общий курс английского языка", "ОБЩИЙ КУРС АНГЛИЙСКОГО ЯЗЫКА " +
                "– иностранный язык «для жизни». Программа подходит для любого уровня подготовки, от Starter (A1) до " +
                "Proficiency (C2). Направлена на практическое овладение английским языком в комплексе и преодоление " +
                "психологического барьера при общении. Общий курс направлен на формирование и совершенствование всех " +
                "языковых и коммуникативных навыков того уровня сложности, на котором вы занимаетесь. Мы проводим " +
                "занятия по учебным материалам, разработанным совместно с BBC Worldwide и BBC Learning English. " +
                "Обучаясь по материалам программ BBC, вы будете слышать живой английский язык и знать все последние " +
                "новости. Темы курса расширяют кругозор, разные варианты произношения в видео- и аудиоматериалах " +
                "помогают «настроить ухо». Вы научитесь воспринимать спикеров  на слух – носителей языка и тех, для " +
                "кого английский не родной. Особое внимание уделяется освоению разговорных клише. Системный подход к " +
                "обучению чтению и письму совершенствует навыки критического мышления. Следить за прогрессом и " +
                "определять зоны развития вам помогут проверочные и тренировочные тесты. На уровнях Starter (A1) – " +
                "Upper Intermediate (B2) мы занимаемся по интерактивному авторскому онлайн-пособию Compass New. " +
                "Мы создали его для работы над грамотностью и лексическим разнообразием речи. На уровне Proficiency " +
                "(C2) рассматриваем презентации выдающихся в своей области людей на TED Talk, всемирно известной " +
                "платформе по обмену интересными идеями. Материалы на общую и бизнес-тематику используем как модели " +
                "для обучения, источник аутентичного материала. Обсуждаем интересные факты и идеи.",
                "materials.pdf", LocalDate.parse("2021-09-01"), LocalDate.parse("2022-05-31"), 2,
                Course.StatusCourse.IN_PROGRESS, Course.FormatCourse.OFFLINE, 12);
        when(courseDao.findInfoAboutCourse(1)).thenReturn(expected);
        Course actual = courseService.findInfoAboutCourse(1);
        assertEquals(expected, actual);
    }
}
