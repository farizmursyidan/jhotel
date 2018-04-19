import java.util.ArrayList;

/**
 * Ini adalah kelas Database Customer yang menampung daftar kamar hotel.
 *
 * @author A. Fariz Mursyidan
 * @version 08.03.2018
 */
public class DatabaseRoom
{
    private static ArrayList<Room> ROOM_DATABASE = new ArrayList<Room>();

    /**
    * Method ini berfungsi untuk menambah kamar baru 
    * @param baru ini adalah parameter untuk menambah kamar baru
    */

    public static boolean addRoom(Room baru)
    {
        for(Room kamar : ROOM_DATABASE)
        {
            if(kamar.getHotel()==baru.getHotel() && kamar.getNomorKamar()==baru.getNomorKamar())
            {
                return false;
            }
        }

        ROOM_DATABASE.add(baru);
        return true;
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

    public static ArrayList<Room> getRoomsFromHotel(Hotel hotel)
    {
        ArrayList<Room> tempRoom = new ArrayList<Room>();

        for(Room kamar : ROOM_DATABASE)
        {
            if(kamar.getHotel().equals(hotel))
            {
                tempRoom.add(kamar);
            }
        }

        return tempRoom;
    }

    public static ArrayList<Room> getVacantRooms()
    {
        ArrayList<Room> tempVacantRoom = new ArrayList<Room>();

        for(Room kamar : ROOM_DATABASE)
        {
            if(kamar.getStatusKamar().equals(StatusKamar.VACANT))
            {
                tempVacantRoom.add(kamar);
            }
        }

        return tempVacantRoom;
    } 

    /**
    * Method ini berfungsi untuk menghapus kamar
    */

    public static boolean removeRoom(Hotel hotel, String nomor_kamar)
    {
        for(Room kamar : ROOM_DATABASE)
        {
            if(kamar.getHotel().equals(hotel) && kamar.getNomorKamar().equals(nomor_kamar))
            {
                Administrasi.pesananDibatalkan(kamar);
                if(ROOM_DATABASE.remove(kamar))
                {
                    return true;
                }
            }
        }

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
