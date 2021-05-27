package business.persistence;

import business.entities.CarportItem;
import business.entities.Order;
import business.entities.Requests;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerViewRequestsMapper {

    private static Database database;

    public CustomerViewRequestsMapper(Database database) {
        this.database = database;
    }

    public List<Requests> ViewAllCustomoerRequests() throws UserException, SQLException {
        List<Requests> carportItems = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM orders";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int order_id = rs.getInt("order_id");
                    int date = rs.getInt("date");
                    int customer_id = rs.getInt("customer_id");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    String roof_type = rs.getString("roof_type");
                    carportItems.add(new Requests(order_id, date, customer_id, length, width, roof_type));
                }
                return carportItems;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        }
    }
}
