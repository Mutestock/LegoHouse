/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Interfaces;

import Data.Exceptions.DataException;
import Logic.HelperClasses.LegoHelper.Lego;
import Logic.HelperClasses.OrderHelper.Order;
import Logic.HelperClasses.UserHelpers.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Henning
 */
public interface DBFacade {

    public void createUser(User user) throws DataException, SQLException;

    public User readUser(int id) throws DataException, SQLException;

    public void updateUser(User user) throws DataException, SQLException;

    public void deleteUser(User user) throws DataException, SQLException;

    public ArrayList<User> getAllUsers() throws DataException, SQLException;

    public User readUserByEmail(String email) throws DataException, SQLException;

    // Order
    public void createOrder(Order order) throws DataException, SQLException;

    public Order readOrder(int id) throws DataException, SQLException;

    public void updateOrder(Order order) throws DataException, SQLException;

    public void deleteOrder(Order order) throws DataException, SQLException;

    public ArrayList<Order> getAllOrders() throws DataException, SQLException;

    // Lego
    public void createLego(Lego lego) throws DataException, SQLException;

    public Lego readLego(int id) throws DataException, SQLException;

    public void updateLego(Lego lego) throws DataException, SQLException;

    public void deleteLego(Lego lego) throws DataException, SQLException;

    public ArrayList<Lego> getAllLego() throws DataException, SQLException;

    public Lego readLegoByOrderID(int id) throws DataException, SQLException;

    //misc
    public String readUserEmailByIDFK(int i) throws DataException, SQLException;

}
