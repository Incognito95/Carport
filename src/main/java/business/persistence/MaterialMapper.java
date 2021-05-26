package business.persistence;

import business.entities.CarportItem;
import business.entities.Material;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;

public class MaterialMapper {
    Database database;
    public MaterialMapper(Database database) {
        this.database = database;
    }

    public Material getCarportItemById(int id) throws UserException {
        Material material = null;

        try (
                Connection connection = database.connect()) {
                String sql = "SELECT * FROM materials WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("id");
                    material = new Material(id, 126, 129);
                }
            } catch (SQLException throwables) {
                throw new UserException("fejl.....");
            }
        } catch (SQLException throwables)
        {
            throw new UserException("fejl.....");
        }
        return material;
    }

    public User createMaterial(User material) throws UserException {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO user (email, password, role) VALUES (?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, material.getEmail());
                ps.setString(2, material.getPassword());
                ps.setString(3, material.getRole());
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
        return  material;
    }


}
