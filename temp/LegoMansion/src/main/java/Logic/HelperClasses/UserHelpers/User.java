/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.HelperClasses.UserHelpers;

/**
 *
 * @author Henning
 */
public class User {

    private int ID;
    private String email;
    private String password;
    private boolean admin;

    public User(int idcustomers, String email, String password, boolean admin) {
        this.ID = idcustomers;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public int getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public String toString() {
        return "User{" + "idcustomers=" + ID + ", email=" + email + ", password=" + password + ", admin=" + admin + '}';
    }
}
