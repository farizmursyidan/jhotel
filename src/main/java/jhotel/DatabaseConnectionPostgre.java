package jhotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Ini adalah kelas DatabaseConnectionPostgre yang berfungsi untuk membuat koneksi dengan database pada server
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */

public class DatabaseConnectionPostgre {

    /**
     * Method ini berfungsi untuk membuat koneksi dan mengecek koneksi dengan database
     */

    static public Connection connection(){
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/jhotel",
                            "fariz", "fariz");
            System.out.println("Opened database successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return c;
    }
}
