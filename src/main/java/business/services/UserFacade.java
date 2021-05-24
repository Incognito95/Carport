package business.services;

import business.entities.Order;
import business.entities.User;
import business.persistence.Database;
import business.persistence.OrderConfirmationMapper;
import business.persistence.UserMapper;
import business.exceptions.UserException;

import java.util.List;

public class UserFacade
{
    UserMapper userMapper;
    OrderConfirmationMapper orderConfirmationMapper;

    public UserFacade(Database database)
    {
        userMapper = new UserMapper(database);
        orderConfirmationMapper = new OrderConfirmationMapper(database);
    }

    public User login(String email, String password) throws UserException
    {
        return userMapper.login(email, password);
    }

    public User createUser(String email, String password) throws UserException
    {
        User user = new User(email, password, "customer");
        userMapper.createUser(user);
        return user;
    }


    public List<User> showAllUsers() throws UserException {
        return userMapper.showAllUsers();
    }

    public User getUserById(int userid) throws Exception {
        return userMapper.getUserById(userid);
    }








}
