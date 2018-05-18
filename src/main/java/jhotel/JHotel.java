package jhotel;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

/**
 * Ini merupakan class JHotel, terdapat fungsi main pada class ini.
 *
 * @author A. Fariz Mursyidan
 * @version 01/03/2018
 */
public class JHotel {

    /**
     * ini merupakan main method.
     */
    public static void main(String[] args) {

        DatabaseConnectionPostgre.connection();

        Lokasi lokasi = new Lokasi(1, 2, "AAAAAAAA");
        Lokasi lokasi2 = new Lokasi(3, 4, "BBBBBBBB");

        Hotel A = new Hotel("SHANGRI-LA", lokasi,6);

        DatabaseHotelPostgre.insertHotel("SHANGRI-LA", 1, 2, "AAAAAAAA", 6);

        try {
            DatabaseHotel.addHotel(A);
        }catch (HotelSudahAdaException e){
            System.out.println(e.getPesan());
        }

        Hotel B = new Hotel("Four Seasons", lokasi2,5);

        DatabaseHotelPostgre.insertHotel("Four Seasons", 3, 4, "BBBBBBBB", 5);

        try {
            DatabaseHotel.addHotel(B);
        }catch (HotelSudahAdaException e){
            System.out.println(e.getPesan());
        }

        DatabaseHotelPostgre.removeHotel(1);

        Room A123 = new SingleRoom(A, "123", 100000);
        try {
            DatabaseRoom.addRoom(A123);
        } catch (RoomSudahAdaException a) {
            System.out.println(a.getPesan());
        }

        Room B456 = new SingleRoom(B, "456", 200000);
        try {
            DatabaseRoom.addRoom(B456);
        } catch (RoomSudahAdaException a) {
            System.out.println(a.getPesan());
        }


        Room D789 = new PremiumRoom(A, "789", 300000);
        try {
            DatabaseRoom.addRoom(D789);
        } catch (RoomSudahAdaException a) {
            System.out.println(a.getPesan());
        }

        SpringApplication.run(JHotel.class, args);
    }

    /**
     * ini merupakan method Jhotel yang merupakan constructor.
     *
     * @return Nothing.
     */
    public JHotel() {

    }
}
