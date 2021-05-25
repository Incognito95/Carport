package web.commands;

import business.entities.AddSeller;
import business.entities.CarportItem;
import business.exceptions.UserException;
import business.services.CarportItemFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class ShowAllCarportItemsCommand extends Command
{
    public String role;
    public String pageToShow;
    private CarportItemFacade carportItemFacade = new CarportItemFacade(database);

    public ShowAllCarportItemsCommand(String pageToShow, String role)
    {
        this.pageToShow = pageToShow;
        this.role = role;

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {

        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int price = Integer.parseInt(request.getParameter("price"));
        int order_id = Integer.parseInt(request.getParameter("order_id"));





        List<CarportItem> carportItems = carportItemFacade.CarportItemFacade();
        request.setAttribute("carportItems", carportItems);

        List<CarportItem> carportItem = carportItemFacade.calcPost();
        request.setAttribute("carportItems", carportItem);

        CarportItem addCarportItem =  carportItemFacade.AddCarportItem(order_id, length, width, quantity, price, description);
        request.setAttribute("addCarportItem", addCarportItem);

        return pageToShow;

    }

    public String getRole()
    {
        return role;
    }
}
