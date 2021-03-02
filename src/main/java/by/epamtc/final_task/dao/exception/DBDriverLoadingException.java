package by.epamtc.final_task.dao.exception;

public class DBDriverLoadingException extends RuntimeException{

    public DBDriverLoadingException(Exception e) {
        super(e);
    }
}
