package business.persistence;

import business.entities.CarportItem;
import business.entities.Order;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarportItemMapper {

    private static Database database;

    public CarportItemMapper(Database database) {
        this.database = database;
    }

    public List<CarportItem> CarportItemMap() throws UserException, SQLException {
        List<CarportItem> carportItems = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM carport_item";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int order_id = rs.getInt("order_ID");
                    int item_id = rs.getInt("item_ID");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int quantity = rs.getInt("quantity");
                    int price = rs.getInt("price");
                    String description = rs.getString("description");

                    carportItems.add(new CarportItem(order_id, item_id, length, width, quantity, price, description));
                }
                return carportItems;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        }
    }

    public void getTotalPrice() {

    }

    public CarportItem AddCarportItem(CarportItem carportItem) throws UserException {


        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO carport_item SET quantity = ?, description = ?, length = ?, width = ?, price = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, carportItem.getQuantity());
                ps.setString(2, carportItem.getDescription());
                ps.setInt(3, carportItem.getLength());
                ps.setInt(4, carportItem.getWidth());
                ps.setInt(5, carportItem.getPrice());
                ps.setInt(5, carportItem.getOrder_id());

                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();

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
        return carportItem;
    }
}
