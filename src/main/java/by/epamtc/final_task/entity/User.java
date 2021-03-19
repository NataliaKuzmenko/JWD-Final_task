package by.epamtc.final_task.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVersionUID = -3435818998116239919L;
    private int userId;
    private String email;
    private String firstName;
    private String lastName;
    private UserRole role;
    private String photoPath;

    public User() {
    }
    public User(User user) {
        this.userId = user.userId;
        this.email = user.email;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.role = user.role;
        this.photoPath = user.photoPath;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = UserRole.valueOf(role);
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                role == user.role &&
                Objects.equals(photoPath, user.photoPath);
    }
    @Override
    public int hashCode() {
        return Objects.hash(userId, lastName, firstName, email, role, photoPath);
    }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
    public enum UserRole {
        STUDENT,
        LECTURER,
        ADMIN;
    }
    public enum UserCourseStatus {
        APPLIED,
        ENTERED,
        NOT_ENTERED;
    }

}
