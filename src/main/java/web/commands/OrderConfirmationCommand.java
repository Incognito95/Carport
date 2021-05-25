package web.commands;

import business.entities.OrderConfirmation;
import business.entities.User;
import business.services.OrderConfirmationFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderConfirmationCommand extends CommandProtectedPage
{
    private OrderConfirmationFacade orderConfirmationFacade = new OrderConfirmationFacade(database);

    public OrderConfirmationCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        OrderConfirmation order = (OrderConfirmation) session.getAttribute("order");
        OrderConfirmation orderConfirmation = orderConfirmationFacade.getOrderById(order.getOrderid());
        request.setAttribute("orderConfirmation", orderConfirmation);

        return pageToShow;
    }
}
