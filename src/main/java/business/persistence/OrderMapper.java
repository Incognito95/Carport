package business.persistence;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.services.OrderFacade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper
{
    private static Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }

    public Order createOrder(Order order) throws UserException {
        
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO orders SET width = ?, length = ?, roof_type = ?, customer_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, order.getLength());
                ps.setInt(2, order.getWidth());
                ps.setString(3, order.getRoof_type());
                ps.setInt(4, order.getCustomer_id());

                ps.executeUpdate();
                ResultSet userIds = ps.getGeneratedKeys();
                userIds.next();
                int userIdsInt = userIds.getInt(1);
                order.setCustomer_id(userIdsInt);

                ResultSet orderIds = ps.getGeneratedKeys();
                orderIds.next();
                int orderIdsInt = orderIds.getInt(1);
                order.setOrder_id(orderIdsInt);

            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
        return order;
    }
    public List<Order> showAllOrders() throws UserException {
        List<Order> orders = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM orders WHERE customer_id BETWEEN ? AND ?";
            User user = null;

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int customer_id = rs.getInt("customer_id");
                    int order_id = rs.getInt("order_id");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    String date = rs.getString("date");
                    int sub_total = rs.getInt("subtotal");
                    String roof_type = rs.getString("roof_type");
                    orders.add(new Order(customer_id, length, width, date, sub_total, roof_type, order_id));
                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
        return orders;
    }
}
