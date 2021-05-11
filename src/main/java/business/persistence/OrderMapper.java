package business.persistence;

import business.entities.Order;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper
{
    private Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }

    public void createOrder(Order order) throws UserException {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO orders SET width = ?, length = ?, roof_type = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, order.getLength());
                ps.setString(2, order.getWidth());
                ps.setString(3, order.getRoof_type());


                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
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
    }

    public List<Order> showAllOrders() throws UserException {

        List<Order> orders = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM orders";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ResultSet rs = ps.executeQuery();

                while(rs.next()) {
                    String order_id = rs.getString("order_id");
                    String length = rs.getString("length");
                    String width = rs.getString("width");
                    String roof_type = rs.getString("roof_type");

                    orders.add(new Order(order_id, length, width, roof_type));
                }
                return orders;
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
    }

}
