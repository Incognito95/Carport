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


    public Material createMaterial(Material material) throws UserException {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO material SET length = ?, price_per_unit = ?, name = ?, unit = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, material.getLength());
                ps.setInt(2, material.getPrice_per_unit());
                ps.setString(3, material.getName());
                ps.setString(4, material.getUnit());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                material.setId(id);
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException | UserException ex)
        {
            throw new UserException(ex.getMessage());
        }
        return material;
    }
}
