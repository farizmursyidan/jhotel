package jhotel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication

/**
 * Class JHotel merupakan class utama dan terdapat main pada class ini
 *
 * @author A. Fariz Mursyidan
 * @version 01.03.2018
 */
public class JHotel
{
    public static void main(String[] args)
    {
        SpringApplication.run(JHotel.class, args);
    }

    public JHotel()
    {
        try {
            DatabaseHotel.addHotel(new Hotel("Hotel A", new Lokasi(12, 34, "Lokasi A"), 5));
        }
        catch (HotelSudahAdaException ex) {
            System.out.println(ex.getPesan());
        }

        try {
            DatabaseHotel.addHotel(new Hotel("Hotel B", new Lokasi(45, 56, "Lokasi B"), 5));
        }
        catch (HotelSudahAdaException ex) {
            System.out.println(ex.getPesan());
        }

        try {
            DatabaseRoom.addRoom(new SingleRoom(DatabaseHotel.getHotel(1), "123"));
        }
        catch (RoomSudahAdaException ex) {
            System.out.println(ex.getPesan());
        }

        try {
            DatabaseRoom.addRoom(new SingleRoom(DatabaseHotel.getHotel(1), "456"));
        }
        catch (RoomSudahAdaException ex) {
            System.out.println(ex.getPesan());
        }

        try {
            DatabaseRoom.addRoom(new SingleRoom(DatabaseHotel.getHotel(2), "789"));
        }
        catch (RoomSudahAdaException ex) {
            System.out.println(ex.getPesan());
        }
    }
}
