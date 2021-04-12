package by.epamtc.final_task.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Course {
    private static final long serialVersionUID = 6025254276834738707L;
    private long id;
    private String title;
    private String description;
    private String materialsPath;
    private LocalDate startDate;
    private LocalDate endDate;
    private long lecturerId;
    private StatusCourse status;
    private FormatCourse format;
    private int limitStudents;

    public Course() {
    }

    public Course(long id, String title, String description, String materialsPath, LocalDate startDate,
                  LocalDate endDate, long lecturerId, StatusCourse status, FormatCourse format, int limitStudents) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.materialsPath = materialsPath;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lecturerId = lecturerId;
        this.status = status;
        this.format = format;
        this.limitStudents = limitStudents;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescripton(String descripton) {
        this.description = descripton;
    }

    public String getMaterialsPath() {
        return materialsPath;
    }

    public void setMaterialsPath(String materialsPath) {
        this.materialsPath = materialsPath;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public long getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(long lecturerId) {
        this.lecturerId = lecturerId;
    }

    public StatusCourse getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = Course.StatusCourse.valueOf(status);
    }


    public FormatCourse getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = Course.FormatCourse.valueOf(format);
    }


    public int getLimitStudents() {
        return limitStudents;
    }

    public void setLimitStudents(int limitStudents) {
        this.limitStudents = limitStudents;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return lecturerId == course.lecturerId &&
                limitStudents == course.limitStudents &&
                title.equals(course.title) && description.equals(course.description) &&
                materialsPath.equals(course.materialsPath) &&
                startDate.equals(course.startDate) && endDate.equals(course.endDate) &&
                status == course.status && format == course.format;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, materialsPath, startDate, endDate, lecturerId, status, format, limitStudents);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descripton='" + description + '\'' +
                ", materialsPath='" + materialsPath + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", studentsLimit=" + limitStudents +
                ", lecturerId=" + lecturerId +
                ", status=" + status +
                ", format=" + format +
                ", limitStudents=" + limitStudents +
                '}';
    }

    public enum FormatCourse {
        ONLINE,
        OFFLINE;
    }

    public enum StatusCourse {
        NOT_STARTED,
        IN_PROGRESS,
        FINISHED;
    }
}
