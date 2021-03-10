package by.epamtc.final_task.entity.user;

public enum UserRole {

    STUDENT(1),

    LECTURER(2),

    ADMIN(3);


    private final int id;


    UserRole(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
