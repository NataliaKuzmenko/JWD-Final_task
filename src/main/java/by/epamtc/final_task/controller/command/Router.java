package by.epamtc.final_task.controller.command;

/**
 * Use for servlet navigation
 */
public class Router {
    private String page;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private Type type = Type.FORWARD;

    public Router(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Type getType() {
        return type;
    }

    public void useRedirect() {
        this.type = Type.REDIRECT;
    }

    public enum Type {
        FORWARD,
        REDIRECT
    }
}

