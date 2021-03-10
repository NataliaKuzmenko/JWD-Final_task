package by.epamtc.final_task.service;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceManager {
    private static final String RES_FILE_NAME = "strings";

    private final ResourceBundle resourceBundle;

    public ResourceManager(Locale locale) {
        locale = (locale == null) ? Locale.getDefault() : locale;
        this.resourceBundle = ResourceBundle.getBundle(RES_FILE_NAME, locale);
    }

    public String getValue(String key) {
        return resourceBundle.getString(key);
    }
}


