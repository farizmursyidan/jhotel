import java.util.ArrayList;

/**
 * Ini adalah kelas Database Customer yang menampung daftar kamar hotel.
 *
 * @author A. Fariz Mursyidan
 * @version 08.03.2018
 */
public class DatabaseRoom
{
    private static final ArrayList<Room> ROOM_DATABASE = new ArrayList<>();

    /**
    * Method ini berfungsi untuk menambah kamar baru 
    * @param baru ini adalah parameter untuk menambah kamar baru
    */

    public static boolean addRoom(Room baru)
    {
        for(Room kamar : ROOM_DATABASE)
        {
            if(!kamar.getHotel().equals(baru.getHotel()) && !kamar.getNomorKamar().equals(baru.getNomorKamar()))
            {
                ROOM_DATABASE.add(baru);
                return true;
            }
        }

        return false;
    }

    public static Room getRoom(Hotel hotel, String nomor_kamar)
    {
        for(Room kamar : ROOM_DATABASE)
        {
            if(kamar.getHotel().equals(hotel) && kamar.getNomorKamar().equals(nomor_kamar))
            {
                return kamar;
            }
        }

        return null;
    }

    /**
    * Method ini berfungsi untuk menghapus kamar 
    * @param id ini adalah parameter untuk menghapus kamar
    */

    public static boolean removeRoom(int id)
    {
        return false;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan data kamar dari database
    * @return null
    */

    public static ArrayList<Room> getRoomDatabase()
    {
        return ROOM_DATABASE;
    }
}
