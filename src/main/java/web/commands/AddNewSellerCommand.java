package web.commands;

import business.entities.AddSeller;
import business.entities.Order;
import business.entities.User;
import business.persistence.OrderMapper;
import business.services.AddNewSellerFacade;
import business.services.OrderFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddNewSellerCommand extends CommandProtectedPage {
    private AddNewSellerFacade addNewSellerFacade = new AddNewSellerFacade(database);

    public AddNewSellerCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();

        if (request.getParameter("email") != null) {
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            int phone = Integer.parseInt(request.getParameter("phone"));
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String role = request.getParameter("role");
            AddSeller addSeller = addNewSellerFacade.AddNewSeller(name, address, phone, email, password, role);
            request.setAttribute("addSeller", addSeller);
        }

        return pageToShow;
    }
}
