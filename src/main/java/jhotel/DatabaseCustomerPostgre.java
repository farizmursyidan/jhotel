package jhotel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Ini adalah kelas DatabaseCustomerPostgre untuk mengolah data customer yang terhubung ke database server.
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */

public class DatabaseCustomerPostgre {
    public static int LAST_CUSTOMER_ID;

    /**
    * Method ini berfungsi untuk menambahkan customer baru pada database server
    * @param name adalah parameter yang berupa nama customer
    * @param email adalah parameter yang berupa email customer
    * @param password adalah parameter yang berupa password customer
    */

    static public boolean insertCustomer(String name, String email, String password){
        try {
            PreparedStatement stm = DatabaseConnectionPostgre.connection().prepareStatement("select max(id) from customer");
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                LAST_CUSTOMER_ID = rs.getInt("max");
                System.out.println("Last Hotel Id = " + LAST_CUSTOMER_ID);
            }
            Customer pelanggan = new Customer(name, 3, 7, 1997, email, password, "photo");
            PreparedStatement stmt = DatabaseConnectionPostgre.connection().prepareStatement("select * from customer where email = (?)");
            stmt.setString(1,email);
            ResultSet rs2 = stmt.executeQuery();
            if(rs2.next()){
                throw new PelangganSudahAdaException(pelanggan);
            }
            PreparedStatement pstmt = DatabaseConnectionPostgre.connection().prepareStatement("INSERT INTO customer VALUES (?, ?, ?, ?)");
            pstmt.setInt(1, LAST_CUSTOMER_ID + 1);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, password);
            //pstmt.addBatch();
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("Customer succesfully inserted");
            LAST_CUSTOMER_ID = pelanggan.getID();
            System.out.println("Last Customer Id = " + LAST_CUSTOMER_ID);
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        catch (PelangganSudahAdaException e) {
            System.out.println(e.getPesan());
            return false;
        }
    }

    /**
    * Method ini berfungsi untuk mendapatkan ID customer terakhir dari database server
    * @return  LAST_CUSTOMER_ID ini adalah mengembalikan ID customer terakhir dari database server
    */

    public static int getLastCustomerId() {
        try {
            PreparedStatement stm = DatabaseConnectionPostgre.connection().prepareStatement("select max(id) from customer");
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                LAST_CUSTOMER_ID = rs.getInt("max");
                return LAST_CUSTOMER_ID;
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    /**
     * Method ini berfungsi untuk mendapatkan data customer dari database server
     * @param id adalah parameter yang berupa id customer
     * @return pelanggan adalah data customer yang dikembalikan
     */

    static public Customer getCustomer(int id){
        try {
            Customer pelanggan = null;
            Statement stmnt = null;
            PreparedStatement pstmt = DatabaseConnectionPostgre.connection().prepareStatement("select c.id, c.name, c.email, c.password, cp.photo from customer c inner join customer_photo cp on c.email = cp.email where id = (?)");
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Customer succesfully selected");
            if(rs.next()){
                pelanggan = new Customer(rs.getString("name"), 3, 7, 1997, rs.getString("email"), rs.getString("password"), rs.getString("photo"));
                pelanggan.setID(rs.getInt("id"));
            }
            System.out.println(pelanggan);
            return pelanggan;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Method ini berfungsi untuk menghapus data customer dari database server
     * @param id adalah parameter yang berupa id customer
     */

    static public boolean removeCustomer(int id){
        try {
            Customer pelanggan = null;
            Statement stmnt = null;
            PreparedStatement pstmt = DatabaseConnectionPostgre.connection().prepareStatement("delete from customer where id = (?)");
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Customer berhasil dihapus");
            return true;
        }

        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
