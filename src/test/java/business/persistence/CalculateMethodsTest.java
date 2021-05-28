//package business.persistence;
//
//import business.entities.Material;
//import business.exceptions.UserException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CalculateMethodsTest {
//    private final static String USER = "root";
//    private final static String PASSWORD = "root1995";
//    private final static String URL = "jdbc:mysql://localhost:3306/carport?serverTimezone=CET";
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
//        material = new Material(1, 360, 4, "25x200\tmm.\ttrykimp.\tBrædt", "stk");
//    }
//
//
//    @Test
//    void createMaterial() throws UserException {
//        materialMapper.createMaterial(material);
//    }
//}