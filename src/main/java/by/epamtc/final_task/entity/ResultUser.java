package by.epamtc.final_task.entity;

import java.util.Objects;

public class ResultUser {
    private static final long serialVersionUID = -128367247802464631L;
    private long resultId;
    private int mark;
    private String comment;
    private UserCourseStatus status;

    public ResultUser() {
    }

    public ResultUser(long resultId, int mark, String comment, UserCourseStatus status) {
        this.resultId = resultId;
        this.mark = mark;
        this.comment = comment;
        this.status = status;
    }

    public long getResultId() {
        return resultId;
    }

    public void setResultId(long resultId) {
        this.resultId = resultId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UserCourseStatus getStatus() {
        return status;
    }

    public void setStatus(UserCourseStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ResultUser that = (ResultUser) obj;
        return resultId == that.resultId && mark == that.mark && Objects.equals(comment, that.comment) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultId, mark, comment, status);
    }

    @Override
    public String toString() {
        return "ResultUser{" +
                "resultId=" + resultId +
                ", mark=" + mark +
                ", comment='" + comment + '\'' +
                ", status=" + status +
                '}';
    }

    public enum UserCourseStatus {
        APPLIED,
        TRAINING_IN_PROGRESS,
        FINISHED,
        DENIED;
    }
}
