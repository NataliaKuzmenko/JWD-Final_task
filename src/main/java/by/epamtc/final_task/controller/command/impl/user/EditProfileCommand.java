package by.epamtc.final_task.controller.command.impl.user;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.ParameterName;
import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.service.UserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.impl.UserServiceImpl;
import by.epamtc.final_task.service.validation.UserValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class EditProfileCommand implements Command {

    public static final Logger LOGGER = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();
    private UserValidator validationUser = UserValidator.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page = null;

        String name = request.getParameter(ParameterName.FIRST_NAME);
       // String avatar = request.getParameter(RequestAttribute.AVATAR);
      //  String email = (String) request.getSession().getAttribute(RequestAttribute.EMAIL);
       /* try {
         if (validationUser.isRightName(name) && validationUser.isRightAboutMe(aboutMe)) {
                User user = userService.updateInfo(email, name, aboutMe, country, gender);
                page = PathToPage.PROFILE_PAGE;

                resolveUser(request, user);

           } else {
                request.setAttribute(RequestAttribute.ERROR_DATA, true);
                page = PathToPage.EDIT_PROFILE_PAGE;
                request.setAttribute(RequestAttribute.GENDER, gender);
                request.setAttribute(RequestAttribute.COUNTRY, country);
                request.setAttribute(RequestAttribute.ABOUT_ME, aboutMe);
                request.setAttribute(RequestAttribute.NAME_USER, name);
                request.setAttribute(RequestAttribute.AVATAR, avatar);
                request.setAttribute(RequestAttribute.LANG_CHANGE_PROCESS_COMMAND,
                        RequestAttribute.COMMAND_PROFILE);
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "User not found", e);
            throw new CommandException("User not found", e);
        }*/
        return new Router(page);
    }

    private void resolveUser(HttpServletRequest request, User user) throws CommandException {
       /* if (user != null) {
            request.setAttribute(RequestAttribute.GENDER, user.getUserGender());
            request.setAttribute(RequestAttribute.COUNTRY, user.getCountry());
            request.setAttribute(RequestAttribute.ABOUT_ME, user.getAboutMe());
            request.setAttribute(RequestAttribute.NAME_USER, user.getName());
            request.setAttribute(RequestAttribute.AVATAR, user.getAvatar());
            request.setAttribute(RequestAttribute.LANG_CHANGE_PROCESS_COMMAND,
                    RequestAttribute.COMMAND_PROFILE);
        } else {
            throw new CommandException("Fail User update");
        }*/
    }
}

