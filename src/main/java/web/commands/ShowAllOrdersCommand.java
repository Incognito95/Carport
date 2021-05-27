package web.commands;

import business.entities.AddSeller;
import business.entities.Material;
import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.services.MaterialFacade;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class ShowAllOrdersCommand extends CommandProtectedPage
{
    private OrderFacade orderFacade = new OrderFacade(database);
    private MaterialFacade materialFacade = new MaterialFacade(database);

    public ShowAllOrdersCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {



            List<Order> orders = orderFacade.showAllOrders();
            request.setAttribute("orders", orders);

            List<Material> materials = materialFacade.ShowAllMaterials();
            request.setAttribute("materials", materials);








            return pageToShow;
    }
}

