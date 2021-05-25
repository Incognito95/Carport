package business.persistence;

import business.entities.Order;
import business.entities.OrderConfirmation;
import business.exceptions.UserException;

import java.sql.*;

public class OrderConfirmationMapper
{
    private static Database database;

    public OrderConfirmationMapper(Database database) {
        this.database = database;
    }

    public OrderConfirmation getOrderById(int order_id) throws Exception {
        OrderConfirmation orderConfirmation;
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM orders WHERE order_id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, order_id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    order_id = rs.getInt("order_id");
                    int date = rs.getInt("date");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int price = rs.getInt("price");
                    String roof_type = rs.getString("roof_type");
                    orderConfirmation = new OrderConfirmation(order_id, date, length, width, price, roof_type);

                } else
                {
                    throw new UserException("der sket en fejl...");
                }
            }
        }
        return orderConfirmation;
    }
}
