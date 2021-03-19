package by.epamtc.final_task.entity;

import java.time.LocalDate;

public class Course {
    private static final long serialVersionUID = 6025254276834738707L;
    private int id;
    private String title;
    private String descripton;
    private String materialsPath;
   // private int authorId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int studentsLimit;
    private int lecturerId;
    private StatusCourse status;
    private FormatCourse format;
    private int limitStudents;

    public Course() {
    }

    public Course(int id, String title, String descripton, String materialsPath, LocalDate startDate, LocalDate endDate, int studentsLimit, int lecturerId, StatusCourse status, FormatCourse format, int limitStudents) {
        this.id = id;
        this.title = title;
        this.descripton = descripton;
        this.materialsPath = materialsPath;
        this.startDate = startDate;
        this.endDate = endDate;
        this.studentsLimit = studentsLimit;
        this.lecturerId = lecturerId;
        this.status = status;
        this.format = format;
        this.limitStudents = limitStudents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public String getMaterialsPath() {
        return materialsPath;
    }

    public void setMaterialsPath(String materialsPath) {
        this.materialsPath = materialsPath;
    }

  /*  public int getAuthorId() {
        return authorId;
    }*/

   /* public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }*/

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

    public int getStudentsLimit() {
        return studentsLimit;
    }

    public void setStudentsLimit(int studentsLimit) {
        this.studentsLimit = studentsLimit;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
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
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descripton='" + descripton + '\'' +
                ", materialsPath='" + materialsPath + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", studentsLimit=" + studentsLimit +
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
