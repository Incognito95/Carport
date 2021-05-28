package web.commands;

import business.entities.AddSeller;
import business.entities.Material;
import business.entities.Order;
import business.entities.User;
import business.persistence.OrderMapper;
import business.services.MaterialFacade;
import business.services.OrderFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddNewProductCommand extends CommandProtectedPage {
    private MaterialFacade materialFacade = new MaterialFacade(database);

    public AddNewProductCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();

        if (request.getParameter("length") != null) {
            int length = Integer.parseInt(request.getParameter("length"));
            int price_per_unit = Integer.parseInt(request.getParameter("price_per_unit"));
            String name = request.getParameter("name");
            String unit = request.getParameter("unit");
            Material addProduct = materialFacade.AddNewProduct(length, price_per_unit, name, unit);
            request.setAttribute("addProduct", addProduct);
        }

        return pageToShow;
    }
}
