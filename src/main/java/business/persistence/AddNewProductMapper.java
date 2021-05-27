package business.persistence;

import business.entities.AddSeller;
import business.entities.Material;
import business.entities.Order;
import business.exceptions.UserException;

import java.sql.*;

public class AddNewProductMapper {

    private static Database database;

    public AddNewProductMapper(Database database) {
        this.database = database;
    }

    public Material AddNewProduct(Material product) throws UserException {

        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO material SET length = ?, price_per_unit = ?, name = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, product.getLength());
                ps.setInt(2, product.getPrice_per_unit());
                ps.setString(3, product.getName());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
        return product;
    }
}
