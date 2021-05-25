package web.commands;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.services.OrderFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserCommand extends CommandProtectedPage
{
    private UserFacade userFacade = new UserFacade(database);

    public UserCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        List<User> users = userFacade.showAllUsers();
        request.setAttribute("users", users);

            return pageToShow;
    }
}
