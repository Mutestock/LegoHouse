/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Data.DBAccess.DataException;
import Data.DatamapperImplementation;
import Logic.FacadeImplementation;
import Logic.HelperClasses.LegoHelper.Lego;
import Logic.HelperClasses.OrderHelper.Order;
import Logic.HelperClasses.UserHelpers.User;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henning
 */
public class Various {

    public Various() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testReadUserEmail() throws DataException, SQLException {
        String expected = "cake@cake.cake";
        DatamapperImplementation dmi = new DatamapperImplementation();
        User user = dmi.readUser(0);
        String actual = user.getEmail();

        assertEquals(expected, actual);
    }

//    @Test
//    public void testDAOCreateReadUpdateDeleteUser() throws Exception {
//        User user = new User(999, "testemail1@test.test", "testpass1", false);
//        User userToUpdate = new User(9993, "testemail2@test.test", "testpass2", true);
//        String ExpectedPass = "testpass2";
//        DatamapperImplementation dmi = new DatamapperImplementation();
//        dmi.createUser(user);
//        System.out.println("pre: " + user);
//        user = userToUpdate;
//        System.out.println("mid: " + user);
//        dmi.updateUser(user);
//        System.out.println("post: " + user);
//        String ActualPass = user.getPassword();
//        System.out.println(user.getID());
//        assertEquals(ExpectedPass, ActualPass);
//        try {
//            System.out.println(user.getID());
//            dmi.deleteUser(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Deletion in testDAOCreateReadDeleteUser Failed..");
//        }
//    }
//    @Test
//    public void testUpdateUser() throws DataException, SQLException
//    {
//        DatamapperImplementation dmi = new DatamapperImplementation();
//        User user = dmi.readUser(1);
//        User updatedUser = new User(1, "boom", "lulmonster", true);
//        user = updatedUser;
//        dmi.updateUser(user);
//        System.out.println("###################");
//        System.out.println(user);
//        System.out.println("##################");
//        System.out.println(dmi.readUser(1));
//        
//    }
    @Test
    public void testDeleteUser() throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        User user = dmi.readUser(999);
        dmi.deleteUser(user);

    }

    @Test
    public void testGetPasswordByGetAllUsers() throws DataException, SQLException {
        String expected = "1234";
        DatamapperImplementation dmi = new DatamapperImplementation();
        ArrayList<User> users = dmi.getAllUsers();
        User user = users.get(0);
        String actual = user.getPassword();

        assertEquals(expected, actual);

    }

    @Test
    public void testReadOrder() throws DataException, SQLException {
        String expected = "CANCELLED";
        DatamapperImplementation dmi = new DatamapperImplementation();
        Order order = dmi.readOrder(0);
        String actual = order.getStatus();
        assertEquals(expected, actual);
    }

    @Test
    public void testCreateOrder() throws DataException, SQLException {
        FacadeImplementation FacImpl = new FacadeImplementation();
        String expected = "SHIPPED";
        DatamapperImplementation dmi = new DatamapperImplementation();
        Order order = new Order(1, FacImpl.timeString(), "SHIPPED", dmi.readUser(0));
        dmi.createOrder(order);
        String actual = order.getStatus();
        assertEquals(expected, actual);

    }

    @Test
    public void testUpdateOrder() throws DataException, SQLException {
        FacadeImplementation FacImpl = new FacadeImplementation();

        String expected = "DELIVERED";
        DatamapperImplementation dmi = new DatamapperImplementation();
        Order order = dmi.readOrder(3);
        Order orderReplace = new Order(3, FacImpl.timeString(), "DELIVERED", dmi.readUser(order.getUser().getID()));
        order = orderReplace;
        dmi.updateOrder(order);
        String actual = dmi.readOrder(3).getStatus();
        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteOrder() throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        Order order = dmi.readOrder(1);
        dmi.deleteOrder(order);
    }

    @Test
    public void testAllOrders() throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        ArrayList<Order> list = new ArrayList<>();
        list = dmi.getAllOrders();
        Order order = list.get(1);
        String expected = "SHIPPED";
        String actual = order.getStatus();
        assertEquals(expected, actual);
    }

    @Test
    public void testCreateLego() throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        Lego lego = new Lego(8, 5, 7, 2, dmi.readOrder(1));
        dmi.createLego(lego);
        int expected = 5;
        int actual = lego.getHeight();
        assertEquals(expected, actual);
    }

    @Test
    public void testReadLego() throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        Lego lego = dmi.readLego(0);
        int expected = 2;
        int actual = lego.getHeight();
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateLego() throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        Lego lego = dmi.readLego(3);
        Lego legoUpdate = new Lego(3, 6, 5, 4, dmi.readOrder(lego.getOrder().getIdorders()));
        lego = legoUpdate;
        System.out.println("LEGOUPDATE: " + legoUpdate);
        dmi.updateLego(lego);
        int expected = 5;
        int actual = lego.getWidth();
        assertEquals(expected, actual);

    }

    @Test
    public void testDeleteLego() throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        Lego lego = dmi.readLego(8);
        dmi.deleteLego(lego);
    }

    @Test 
    public void testAllLego() throws DataException, SQLException {
        DatamapperImplementation dmi = new DatamapperImplementation();
        ArrayList<Lego> list = new ArrayList<>();
        list = dmi.getAllLego();
        Lego lego = list.get(0);
        int expected = 2;
        int actual = lego.getHeight();
        assertEquals(expected, actual);
    }

}
