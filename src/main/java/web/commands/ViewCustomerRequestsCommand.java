package web.commands;

import business.entities.Requests;
import business.exceptions.UserException;
import business.services.CustomerRequestsFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class ViewCustomerRequestsCommand extends CommandProtectedPage
{
    private CustomerRequestsFacade customerRequestsFacade = new CustomerRequestsFacade(database);

    public ViewCustomerRequestsCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException
    {
        List<Requests> requests = customerRequestsFacade.ViewAllCustomoerRequests();
        request.setAttribute("requests", requests);

        return pageToShow;
    }
}

