package business.persistence;
import business.entities.SeeProducts;
import business.exceptions.UserException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowAllProductsMapper {

    private static Database database;

    public ShowAllProductsMapper(Database database) {
        this.database = database;
    }

    public List<SeeProducts> ShowAllProducts() throws UserException, SQLException {
        List<SeeProducts> seeProducts = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM material";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    int length = rs.getInt("length");
                    int width = rs.getInt("price_per_unit");
                    String name = rs.getString("name");
                    String unit = rs.getString("unit");
                    seeProducts.add(new SeeProducts(id, width, length, name, unit));
                }
                return seeProducts;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        }
    }

    public void getTotalPrice() {
    }

    public void addItem() {
    }
}
