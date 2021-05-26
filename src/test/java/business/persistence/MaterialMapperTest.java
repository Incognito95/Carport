//package business.persistence;
//
//import business.entities.Material;
//import business.exceptions.UserException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//
//class MaterialMapperTest {
//    private final static String USER = "root";
//    private final static String PASSWORD = "root123";
//    private final static String URL = "jdbc:mysql://localhost:3306/incogcarport?serverTimezone=CET";
//    // TODO: lav en test-database og peg på den med urlen
//
//    Database database;
//    MaterialMapper materialMapper;
//    Material material;
//
//
//    @BeforeEach
//    void setUp() throws ClassNotFoundException {
//        database = new Database(USER,PASSWORD,URL);
//        materialMapper = new MaterialMapper(database);
//        material = new Material(780, 300, 500);
//
//    }
//
//    @Test
//    void createMaterial(int id, int rem, int meter) throws UserException {
//        materialMapper.createMaterial(id, rem, meter);
//    }
//}