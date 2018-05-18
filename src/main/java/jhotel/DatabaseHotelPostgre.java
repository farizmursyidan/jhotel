package jhotel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Ini adalah kelas DatabaseHotelPostgre untuk mengolah data hotel yang terhubung ke database server.
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */

public class DatabaseHotelPostgre {

    private static int LAST_HOTEL_ID = 0;

    /**
     * Method ini berfungsi untuk mendapatkan ID hotel terakhir dari database server
     * @return LAST_HOTEL_ID ini adalah mengembalikan ID hotel terakhir dari database server
     */

    public static int getLastHotelId() {
        return LAST_HOTEL_ID;
    }

    /**
     * Method ini berfungsi untuk menambahkan hotel baru pada database server
     * @param nama adalah parameter yang berupa nama hotel
     * @param x adalah parameter yang berupa koordinat x hotel
     * @param y adalah parameter yang berupa koordinat y hotel
     * @param deskripsi adalah parameter yang berupa deskripsi lokasi hotel
     * @param bintang adalah parameter yang berupa bintang hotel
     */

    static public boolean insertHotel(String nama, float x, float y, String deskripsi, int bintang){
        try {
            PreparedStatement stm = DatabaseConnectionPostgre.connection().prepareStatement("select max(id) from hotel");
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                LAST_HOTEL_ID = rs.getInt("max");
                System.out.println("Last Hotel Id = " + LAST_HOTEL_ID);
            }
            Hotel hotel = new Hotel(nama, new Lokasi(x,y,deskripsi),bintang);
            PreparedStatement stmt = DatabaseConnectionPostgre.connection().prepareStatement("select * from hotel where x_coord = (?) and y_coord = (?)");
            stmt.setFloat(1,x);
            stmt.setFloat(2,y);
            ResultSet rs2 = stmt.executeQuery();
            if(rs2.next()){
                throw new HotelSudahAdaException(hotel);
            }
            PreparedStatement pstmt = DatabaseConnectionPostgre.connection().prepareStatement("INSERT INTO hotel VALUES (?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, hotel.getID());
            pstmt.setString(2, nama);
            pstmt.setDouble(3, x);
            pstmt.setDouble(4, y);
            pstmt.setString(5, deskripsi);
            pstmt.setInt(6, bintang);
            //pstmt.addBatch();
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("Hotel succesfully inserted");
            LAST_HOTEL_ID = hotel.getID();
            System.out.println("Last Hotel Id = " + LAST_HOTEL_ID);
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        catch(HotelSudahAdaException a) {
            System.out.println(a.getPesan());
            return false;
        }
    }

    /**
     * Method ini berfungsi untuk mendapatkan data hotel dari database server
     * @param id adalah parameter yang berupa id customer
     * @return hotel adalah data hotel yang dikembalikan
     */

    static public Hotel getHotel(int id){
        try {
            Hotel hotel = null;
            Statement stmnt = null;
            PreparedStatement pstmt = DatabaseConnectionPostgre.connection().prepareStatement("select * from hotel where id = (?)");
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Hotel succesfully selected");
            if(rs.next()){
                hotel = new Hotel(rs.getString("nama"),
                        new Lokasi(rs.getFloat("x_coord"),
                                rs.getFloat("y_coord"),
                                rs.getString("deskripsi")),
                        rs.getInt("bintang"));
                hotel.setID(rs.getInt("id"));
            }
            System.out.println(hotel);
            return hotel;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Method ini berfungsi untuk menghapus data hotel dari database server
     * @param id adalah parameter yang berupa id hotel
     */

    static public boolean removeHotel(int id){
        try {
            Hotel hotel = null;
            Statement stmnt = null;
            PreparedStatement pstmt = DatabaseConnectionPostgre.connection().prepareStatement("delete from hotel where id = (?)");
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Hotel berhasil dihapus");
            return true;
        }

        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
