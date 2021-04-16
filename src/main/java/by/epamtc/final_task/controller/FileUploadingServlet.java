package by.epamtc.final_task.controller;

import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;
import by.epamtc.final_task.service.UserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static by.epamtc.final_task.controller.constant.ParameterName.*;

/**
 * Servlet for loading avatars
 */
@WebServlet(urlPatterns = {"/upload"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024
        , maxFileSize = 1024 * 1024 * 5
        , maxRequestSize = 1024 * 1024 * 5 * 5)

public class FileUploadingServlet extends HttpServlet {

    private final UserService userService = UserServiceImpl.getInstance();
    private static final String FILE_EXTENSION_REGEX = ".+\\.((png)|(jpg)|(jpeg))";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRealPath(ADD_FOR_PATH_AVATAR);
        try {
            for (Part part : request.getParts()) {

                String path = part.getSubmittedFileName();
                if (path == null || path.trim().isEmpty()) {
                    request.setAttribute(ParameterName.UPLOAD_RESULT, false);
                    request.getRequestDispatcher(PageName.EDIT_PROFILE_PAGE).forward(request, response);
                } else if (!path.matches(FILE_EXTENSION_REGEX)) {
                    request.setAttribute(ParameterName.UPLOAD_RESULT, false);
                    request.getRequestDispatcher(PageName.EDIT_PROFILE_PAGE).forward(request, response);
                } else {
                    String randFilename = UUID.randomUUID() + path.substring(path.lastIndexOf("."));
                    String avatar = request.getParameter(AVATAR);
                    if (avatar.equalsIgnoreCase(USER)) {
                        initUserAvatar(request, part, randFilename);
                        request.setAttribute(ParameterName.UPLOAD_RESULT, true);
                        request.getRequestDispatcher(PageName.EDIT_PROFILE_PAGE).forward(request, response);
                    }
                }
            }
        } catch (IOException | CommandException | IllegalStateException e) {
            request.setAttribute(ParameterName.UPLOAD_RESULT, false);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PageName.EDIT_PROFILE_PAGE);
            dispatcher.forward(request, response);
        }

    }

    private void initUserAvatar(HttpServletRequest request, Part part, String randFilename) throws
            CommandException, IOException {

        File fileSaveDirForUserAvatar = new File(UPLOAD_DIR_FOR_USER_AVATAR);
        if (!fileSaveDirForUserAvatar.exists()) {
            fileSaveDirForUserAvatar.mkdirs();
        }

        part.write(UPLOAD_DIR_FOR_USER_AVATAR + randFilename);
        part.write(SERVER_UPLOAD_DIR + randFilename);
        String email = (String) request.getSession().getAttribute(EMAIL);

        try {
            userService.updateAvatar(email, randFilename);
        } catch (ServiceException e) {
            throw new CommandException("Failed photo upload attempt");
        }
    }
}
