package jhotel;
import java.util.ArrayList;

/**
 * Ini adalah kelas Database Customer yang menampung daftar kamar hotel.
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */
public class DatabaseRoom
{
    private static ArrayList<Room> ROOM_DATABASE = new ArrayList<Room>();

    /**
    * Method ini berfungsi untuk menambah kamar baru 
    * @param baru ini adalah parameter untuk menambah kamar baru
    */

    public static boolean addRoom(Room baru) throws RoomSudahAdaException
    {
        for(Room kamar : ROOM_DATABASE)
        {
            if(kamar.getHotel()==baru.getHotel() && kamar.getNomorKamar()==baru.getNomorKamar())
            {
                throw new RoomSudahAdaException(baru);
            }
        }

        ROOM_DATABASE.add(baru);
        return true;
    }

    /**
     * Method ini berfungsi untuk mendapatkan data kamar dari database
     * @param hotel adalah parameter hotel yang dibutuhkan untuk mendapatkan data kamar
     * @param nomor_kamar adalah parameter nomor kamar yang dibutuhkan untuk mendapatkan data kamar
     * @return kamar adalah mengembalikan data kamar
     */

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
     * Method ini berfungsi untuk mendapatkan data kamar dari suatu hotel
     * @param hotel adalah parameter hotel yang dibutuhkan untuk mendapatkan data kamar
     * @return tempRoom adalah mengembalikan data kamar pada suatu hotel
     */

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

    /**
     * Method ini berfungsi untuk mendapatkan data kamar yang berstatus vacant dari database
     * @return tempVacantRoom adalah mengembalikan data kamar yang berstatus vacant
     */

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
    * Method ini berfungsi untuk menghapus kamar dari database
    * @param hotel adalah parameter hotel yang dibutuhkan untuk mengetahui kamar tersebut berada pada hotel mana
    * @param nomor_kamar adalah parameter nomor kamar yang dibutuhkan untuk menunjukkan kamar mana yang ingin dihapus
    */

    public static boolean removeRoom(Hotel hotel, String nomor_kamar) throws RoomTidakDitemukanException
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

        throw new RoomTidakDitemukanException(hotel, nomor_kamar);
    }

    /**
    * Method ini adalah accessor untuk mengembalikan data kamar dari database
    * @return ROOM_DATABASE mengembalikan data kamar dari database
    */

    public static ArrayList<Room> getRoomDatabase()
    {
        return ROOM_DATABASE;
    }
}
