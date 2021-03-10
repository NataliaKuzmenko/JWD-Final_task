package by.epamtc.final_task.entity;

import by.epamtc.final_task.entity.user.User;

import java.util.Objects;

public class UserAuthorizationData extends User {

    private static final long serialVersionUID = -109346047819255961L;

    private String login;

    private transient String password;

    public UserAuthorizationData() {
    }

    public UserAuthorizationData(User user) {
        super(user);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserAuthorizationData userAuthData = (UserAuthorizationData) o;
        return Objects.equals(login, userAuthData.login) &&
                Objects.equals(password, userAuthData.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, password);
    }

    @Override
    public String toString() {
        return "UserAuthData{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

