/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Data.DBAccess.DBConnector;
import Data.Exceptions.DataException;
import Logic.FacadeImplementation;
import Logic.HelperClasses.LegoHelper.Lego;
import Logic.HelperClasses.OrderHelper.Order;
import Logic.HelperClasses.UserHelpers.User;
import Logic.Interfaces.DBFacade;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.runtime.Context.DEBUG;

/**
 *
 * @author Henning
 */
public class DatamapperImplementation implements DBFacade {

    @Override
    public void createUser(User user) throws DataException, SQLException {
        try {
            PreparedStatement preparedStmt;
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            String query
                    = " INSERT INTO users (idusers, email, password, admin)"
                    + " VALUES(?,?,?,?);";
            preparedStmt = c.prepareStatement(query);
            preparedStmt.setInt(1, user.getID());
            preparedStmt.setString(2, user.getEmail());
            preparedStmt.setString(3, user.getPassword());
            preparedStmt.setBoolean(4, false);

            preparedStmt.execute();

            preparedStmt.close();
            c.close();
        } catch (Exception ex) {
            throw new DataException();
        }
    }

    @Override
    public User readUser(int id) throws DataException, SQLException {
//        User user = null;
        try {
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            String query
                    = "SELECT * "
                    + "FROM users "
                    + "WHERE idusers = '" + id + "';";
            PreparedStatement prepStmt = c.prepareStatement(query);
            ResultSet rs = prepStmt.executeQuery(query);
            c = connector.getConnection();

            String password = "";
            String email = "";
            Boolean admin = false;
            while (rs.next()) {
                password = rs.getString("password");
                email = rs.getString("email");
                admin = rs.getBoolean("admin");
            }
            User user = new User(id, email, password, admin);
            prepStmt.close();
            rs.close();
            c.close();

            return user;
        } catch (Exception ex) {
            throw new DataException();
        }
    }

    @Override
    public void updateUser(User user) throws DataException, SQLException {
        PreparedStatement preparedStmt;
        try {
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            String query
                    = "UPDATE users "
                    + "SET "
                    + "email = ?, "
                    + "password =  ?, "
                    + "admin = ? "
                    + "WHERE idusers = ?;";
            preparedStmt = c.prepareStatement(query);
            preparedStmt.setString(1, user.getEmail());
            preparedStmt.setString(2, user.getPassword());
            preparedStmt.setBoolean(3, false);
            preparedStmt.setInt(4, user.getID());
            preparedStmt.executeUpdate();
            preparedStmt.close();
            c.close();
        } catch (Exception ex) {
            throw new DataException();
        }
    }

    @Override
    public void deleteUser(User user) throws DataException, SQLException {
        try {
            PreparedStatement preparedStmt;
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            String query
                    = "DELETE FROM users "
                    + "WHERE idusers = '" + user.getID() + "';";
            preparedStmt = c.prepareStatement(query);
            preparedStmt.execute();
            preparedStmt.close();
            c.close();
        } catch (Exception ex) {
            throw new DataException();
        }
    }

    @Override
    public ArrayList<User> getAllUsers() throws DataException, SQLException {
        try {
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            String query
                    = ("SELECT *"
                    + "FROM users");
            PreparedStatement prepStmt = c.prepareStatement(query);
            ResultSet rs = prepStmt.executeQuery();
            ArrayList<User> allUsers = new ArrayList();
            while (rs.next()) {
                int userid = rs.getInt("idusers");
                String email = rs.getString("email");
                String password = rs.getString("password");
                boolean admin = rs.getBoolean("admin");
                allUsers.add(new User(userid, email, password, admin));
            }
            prepStmt.close();
            rs.close();
            c.close();
            return allUsers;

        } catch (SQLException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            throw new DataException();
        }
        return null;
    }

    public User readUserByEmail(String email) throws DataException, SQLException {
        try {
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            String query
                    = "SELECT * "
                    + "FROM users "
                    + "WHERE email = '" + email + "';";
            PreparedStatement prepStmt = c.prepareStatement(query);
            ResultSet rs = prepStmt.executeQuery(query);
            c = connector.getConnection();

            int idusers = 0;
            String password = "";
            Boolean admin = false;
            while (rs.next()) {
                idusers = rs.getInt("idusers");
                password = rs.getString("password");
                admin = rs.getBoolean("admin");
            }
            User user = new User(idusers, email, password, admin);
            prepStmt.close();
            rs.close();
            c.close();

            return user;
        } catch (Exception ex) {
            throw new DataException();
        }
    }

    @Override
    public void createOrder(Order order) throws DataException, SQLException {
        try {
            FacadeImplementation timeFetch = new FacadeImplementation();
            PreparedStatement preparedStmt;
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            String query
                    = "INSERT INTO orders (idorders, order_date, status, userIDFK) "
                    + "VALUES(?,?,?,?);";
            preparedStmt = c.prepareStatement(query);
            preparedStmt.setInt(1, order.getIdorders());
            preparedStmt.setString(2, (timeFetch.timeString()));
            preparedStmt.setString(3, order.getStatus());
            preparedStmt.setInt(4, (order.getUser().getID()));

            preparedStmt.execute();
            preparedStmt.close();
            c.close();
        } catch (Exception ex) {
            throw new DataException();
        }
    }

    @Override
    public Order readOrder(int id) throws DataException, SQLException {
        try {
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            String query
                    = "SELECT * "
                    + "FROM orders "
                    + "WHERE idorders = '" + id + "';";
            PreparedStatement prepStmt = c.prepareStatement(query);
            ResultSet rs = prepStmt.executeQuery(query);
            c = connector.getConnection();

            String order_date = null;
            String status = "";
            int userId = 0;
            while (rs.next()) {
                order_date = rs.getString("order_date");
                status = rs.getString("status");
                userId = rs.getInt("userIDFK");
            }

            Order order = new Order(id, order_date, status, readUser(userId));
            prepStmt.close();
            rs.close();
            c.close();

            return order;
        } catch (Exception ex) {
            throw new DataException();
        }
    }

    @Override
    public void updateOrder(Order order) throws DataException, SQLException {

        try {
            FacadeImplementation timeFetch = new FacadeImplementation();
            PreparedStatement prepStmt;
            timeFetch.timeString();
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            String query
                    = "UPDATE orders "
                    + "SET "
                    + "order_date = ?, "
                    + "status =  ?, "
                    + "userIDFK = ? "
                    + "WHERE idorders = ?;";
            prepStmt = c.prepareStatement(query);
            prepStmt.setString(1, order.getDate());
            prepStmt.setString(2, order.getStatus());
            prepStmt.setInt(3, order.getUser().getID());
            prepStmt.setInt(4, order.getIdorders());

            prepStmt.executeUpdate();
            prepStmt.close();
            c.close();

        } catch (Exception ex) {
            throw new DataException();
        }
    }

    @Override
    public void deleteOrder(Order order) throws DataException, SQLException {

        try {
            PreparedStatement preparedStmt;
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            String query
                    = "DELETE FROM orders "
                    + "WHERE idorders = '" + order.getIdorders() + "';";
            preparedStmt = c.prepareStatement(query);
            preparedStmt.execute();
            preparedStmt.close();
            c.close();
        } catch (Exception ex) {
            throw new DataException();
        }
    }

    @Override
    public ArrayList<Order> getAllOrders() throws DataException, SQLException {
        try {
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            String query
                    = ("SELECT *"
                    + "FROM orders");
            PreparedStatement prepStmt = c.prepareStatement(query);
            ResultSet rs = prepStmt.executeQuery();
            ArrayList<Order> allOrders = new ArrayList();
            while (rs.next()) {
                int idorders = rs.getInt("idorders");
                String order_date = rs.getString("order_date");
                String status = rs.getString("status");
                int userIDFK = rs.getInt("userIDFK");
                allOrders.add(new Order(idorders, order_date, status, readUser(userIDFK)));
            }
            prepStmt.close();
            rs.close();
            c.close();
            return allOrders;

        } catch (SQLException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            throw new DataException();
        }
        return null;
    }

    @Override
    public void createLego(Lego lego) throws DataException, SQLException {
        try {
            PreparedStatement preparedStmt;
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            String query
                    = "INSERT INTO lego_type (idlego_type, height, width, length, idordersfk) "
                    + "VALUES(?,?,?,?,?);";
            preparedStmt = c.prepareStatement(query);
            preparedStmt.setInt(1, lego.getBrickID());
            preparedStmt.setInt(2, lego.getHeight());
            preparedStmt.setInt(3, lego.getWidth());
            preparedStmt.setInt(4, lego.getLength());
            preparedStmt.setInt(5, lego.getOrder().getIdorders());
            preparedStmt.execute();

            preparedStmt.close();
            c.close();
        } catch (Exception ex) {
            throw new DataException();
        }
    }

    @Override
    public Lego readLego(int id) throws DataException, SQLException {
        try {
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            String query
                    = "SELECT * "
                    + "FROM lego_type "
                    + "WHERE idlego_type = '" + id + "';";
            PreparedStatement prepStmt = c.prepareStatement(query);
            ResultSet rs = prepStmt.executeQuery(query);
            c = connector.getConnection();
            int height = 0;
            int width = 0;
            int length = 0;
            int ordersId = 0;

            while (rs.next()) {
                height = rs.getInt("height");
                width = rs.getInt("width");
                length = rs.getInt("length");
                ordersId = rs.getInt("idordersfk");
            }

            Lego lego = new Lego(id, height, width, length, readOrder(ordersId));
            prepStmt.close();
            rs.close();
            c.close();

            return lego;
        } catch (Exception ex) {
            throw new DataException();
        }
    }

    @Override
    public void updateLego(Lego lego) throws DataException, SQLException {
        try {
            PreparedStatement prepStmt;
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            String query
                    = "UPDATE lego_type "
                    + "SET "
                    + "height= ?, "
                    + "width =  ?, "
                    + "length = ?, "
                    + "idordersfk = ? "
                    + "WHERE idlego_type = ?;";
            prepStmt = c.prepareStatement(query);
            prepStmt.setInt(1, lego.getHeight());
            prepStmt.setInt(2, lego.getWidth());
            prepStmt.setInt(3, lego.getLength());
            prepStmt.setInt(4, lego.getOrder().getIdorders());
            prepStmt.setInt(5, lego.getBrickID());

            prepStmt.executeUpdate();
            prepStmt.close();
            c.close();

        } catch (Exception ex) {
            throw new DataException();
        }
    }

    @Override
    public void deleteLego(Lego lego) throws DataException, SQLException {
        try {
            PreparedStatement preparedStmt;
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            String query
                    = "DELETE FROM lego_type "
                    + "WHERE idlego_type = '" + lego.getBrickID() + "';";
            preparedStmt = c.prepareStatement(query);
            preparedStmt.execute();
            preparedStmt.close();
            c.close();
        } catch (Exception ex) {
            throw new DataException();
        }
    }

    @Override
    public ArrayList<Lego> getAllLego() throws DataException, SQLException {
        try {
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            String query
                    = ("SELECT *"
                    + "FROM lego_type");
            PreparedStatement prepStmt = c.prepareStatement(query);
            ResultSet rs = prepStmt.executeQuery();
            ArrayList<Lego> allLego = new ArrayList();
            while (rs.next()) {
                int idlego = rs.getInt("idlego_type");
                int height = rs.getInt("height");
                int width = rs.getInt("width");
                int length = rs.getInt("length");
                int orderid = rs.getInt("idordersfk");
//                allOrders.add(new Order(idorders, status, status, readUser(userIDFK)));
                allLego.add(new Lego(idlego, height, width, length, readOrder(orderid)));
            }
            prepStmt.close();
            rs.close();
            c.close();
            return allLego;

        } catch (SQLException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            throw new DataException();
        }
        return null;
    }

    @Override
    public Lego readLegoByOrderID(int id) throws DataException, SQLException {
        try {
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            String query
                    = "SELECT * "
                    + "FROM lego_type "
                    + "WHERE idordersfk = '" + id + "';";
            PreparedStatement prepStmt = c.prepareStatement(query);
            ResultSet rs = prepStmt.executeQuery(query);
            c = connector.getConnection();
            
            int idlego_type = 0;
            int height = 0;
            int width = 0;
            int length = 0;

            while (rs.next()) {
                
                idlego_type = rs.getInt("idlego_type");
                height = rs.getInt("height");
                width = rs.getInt("width");
                length = rs.getInt("length");
            }

            Lego lego = new Lego(idlego_type, height, width, length, readOrder(id));
            prepStmt.close();
            rs.close();
            c.close();

            return lego;
        } catch (Exception ex) {
            throw new DataException();
        }
    }

}
