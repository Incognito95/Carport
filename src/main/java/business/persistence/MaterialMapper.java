package business.persistence;

import business.entities.ConfirmedOrders;
import business.entities.Material;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialMapper {
    Database database;
    public MaterialMapper(Database database) {
        this.database = database;
    }

    public List<Material> ShowAllMaterials() throws UserException, SQLException {
        List<Material> showMaterials = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM material";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    int length = rs.getInt("length");
                    int price_per_unit = rs.getInt("price_per_unit");
                    String name = rs.getString("name");
                    String unit = rs.getString("unit");
                    showMaterials.add(new Material(id, length, price_per_unit, name, unit));
                }
                return showMaterials;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        }
    }
}
