/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.HelperClasses.OrderHelper;

import Logic.FacadeImplementation;
import Logic.HelperClasses.UserHelpers.User;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;

/**
 *
 * @author Henning
 */
public class Order {

    private int idorders;
    private String status;
    private String date;
    private User user;

    public Order(int idorders, String date, String status, User user) {
        this.idorders = idorders;
        this.status = status;
        this.date = date;
        this.user = user;
    }

    public int getIdorders() {
        return idorders;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Order{" + "idorders=" + idorders + ", status=" + status + ", date=" + date + ", user=" + user + '}';
    }

   
}
