/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DatamapperImplementation;
import Data.Exceptions.DataException;
import Logic.HelperClasses.LegoHelper.Lego;
import Logic.HelperClasses.OrderHelper.Order;
import Logic.HelperClasses.UserHelpers.User;
import Logic.Interfaces.DBFacade;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Henning
 */
public class DBFacadeImplementation implements DBFacade {

    // ********'USER*********
    @Override
    public void createUser(User user) throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        dmi.createUser(user);
    }

    @Override
    public User readUser(int id) throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        User user = dmi.readUser(id);
        return user;
    }

    @Override
    public void updateUser(User user) throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        dmi.updateUser(user);
    }

    @Override
    public void deleteUser(User user) throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        dmi.deleteUser(user);
    }

    @Override
    public ArrayList<User> getAllUsers() throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        ArrayList<User> users = dmi.getAllUsers();
        return users;
    }

    @Override
    public User readUserByEmail(String email) throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        User user = readUserByEmail(email);
        return user;
    }

    // ************ ORDER ************
    @Override
    public void createOrder(Order order) throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        dmi.createOrder(order);
    }

    @Override
    public Order readOrder(int id) throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        Order order = dmi.readOrder(id);
        return order;
    }

    @Override
    public void updateOrder(Order order) throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        dmi.updateOrder(order);
    }

    @Override
    public void deleteOrder(Order order) throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        dmi.deleteOrder(order);
    }

    @Override
    public ArrayList<Order> getAllOrders() throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        ArrayList<Order> orders = dmi.getAllOrders();
        return orders;
    }

    // ************** LEGO **************
    @Override
    public void createLego(Lego lego) throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        dmi.createLego(lego);
    }

    @Override
    public Lego readLego(int id) throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        Lego lego = dmi.readLego(id);
        return lego;
    }

    @Override
    public void updateLego(Lego lego) throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        dmi.updateLego(lego);
    }

    @Override
    public void deleteLego(Lego lego) throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        dmi.deleteLego(lego);
    }

    @Override
    public ArrayList<Lego> getAllLego() throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        ArrayList<Lego> legoBricks = dmi.getAllLego();
        return legoBricks;
    }

    @Override
    public Lego readLegoByOrderID(int id) throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        Lego lego = dmi.readLegoByOrderID(id);
        return lego;
    }

}
