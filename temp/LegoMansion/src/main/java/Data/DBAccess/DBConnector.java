package Data.DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is used to connect to any MySQL database that allows remote access.
 * What database to connect to and what SQL user to log in as is determined by the constant variables currently hardcoded.
 * Currently, the DBConnector connects to the MySQL server on Simon Asholt Norup's Ubuntu droplet.
 * @author RODA
 */
public class DBConnector {
    private Connection connection = null;
	
    //Constants
    private static final String IP	 = "localhost"; //;
    private static final String PORT     = "3306";
    public static final String DATABASE  = "legohus";
    private static final String USERNAME = "root"; 
    private static final String PASSWORD = "yourling";	     	
	
    /** 
     * Constructor that handles the actual connection process and initializes the Connection variable.
     * @throws Exception
     */
    public DBConnector() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance(); //com.mysql.cj.jdbc.Driver
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE + "?allowMultiQueries=true"; // &useSSL=false ???
        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
    }

    /**
     * @return the connection initialized as the DBConnector object was created
     */
    public Connection getConnection() {
        return this.connection;
    }
}
