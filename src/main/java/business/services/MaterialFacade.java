package business.services;

import business.entities.AddSeller;
import business.entities.Material;
import business.exceptions.UserException;
import business.persistence.AddNewProductMapper;
import business.persistence.Database;
import business.persistence.MaterialMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MaterialFacade {
    Database database;
    MaterialMapper materialMapper;
    AddNewProductMapper addNewProductMapper;

    public MaterialFacade(Database database) {
        this.database = database;
        materialMapper = new MaterialMapper(database);
        addNewProductMapper = new AddNewProductMapper(database);
    }

    public List<Material> ShowAllMaterials() throws UserException, SQLException {
        return materialMapper.ShowAllMaterials();
    }

    public Material AddNewProduct(int length, int price_per_unit, String name, String unit) throws UserException {
        Material material = new Material(length, price_per_unit, name, unit);
        material = addNewProductMapper.AddNewProduct(material);
        return material;
    }

}
