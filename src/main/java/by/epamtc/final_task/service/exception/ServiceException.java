package by.epamtc.final_task.service.exception;

public class ServiceException extends Exception{
    private static final long serialVersionUID = 5602354829649835348L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Exception e) {
        super(e);
    }

    public ServiceException(String message, Exception e) {
        super(message, e);
    }

}
