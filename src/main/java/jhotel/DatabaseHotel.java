package jhotel;
import java.util.ArrayList;

/**
 * Ini adalah kelas Database Hotel yang menampung daftar Hotel.
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */
public class DatabaseHotel
{
    private static ArrayList<Hotel> HOTEL_DATABASE = new ArrayList<Hotel>();
    private static int LAST_HOTEL_ID = 0;

    /**
    * Method ini adalah accessor untuk mendapatkan data hotel dari database
    * @return HOTEL_DATABASE mengembalikan database hotel
    */

    public static ArrayList<Hotel> getHotelDatabase()
    {
        return HOTEL_DATABASE;
    }

    /**
     * Method ini berfungsi untuk mendapatkan ID hotel terakhir dari database
     * @return LAST_HOTEL_ID ini adalah mengembalikan ID hotel terakhir dari database
     */

    public static int getLastHotelID()
    {
        return LAST_HOTEL_ID;
    }

    /**
    * Method ini berfungsi untuk menambah hotel baru 
    * @param baru ini adalah parameter untuk menambah hotel baru
    */

    public static boolean addHotel(Hotel baru) throws HotelSudahAdaException
    {
        for(Hotel hotel : HOTEL_DATABASE)
        {
            if(hotel.getID() == baru.getID() || (hotel.getNama().equals(baru.getNama()) && hotel.getLokasi().equals(baru.getLokasi())))
            {
                throw new HotelSudahAdaException(baru);
            }
        }

        LAST_HOTEL_ID = baru.getID();
        HOTEL_DATABASE.add(baru);
        return true;
    }

    /**
     * Method ini berfungsi untuk mendapatkan data hotel dari database
     * @param id adalah parameter ID yang dibutuhkan untuk mendapatkan data hotel
     * @return hotel adalah mengembalikan data hotel
     */

    public static Hotel getHotel(int id)
    {
        for(Hotel hotel : HOTEL_DATABASE)
        {
            if(hotel.getID() == id)
            {
                return hotel;
            }
        } 

        return null;
    }

    /**
     * Method ini berfungsi untuk menghapus hotel dari database
     * @param id adalah parameter ID yang dibutuhkan untuk menghapus data hotel
     */

    public static boolean removeHotel(int id) throws HotelTidakDitemukanException
    {
        for(Hotel hotel : HOTEL_DATABASE)
        {
            if(id == hotel.getID())
            {
                for(Room kamar : DatabaseRoom.getRoomsFromHotel(hotel))
                {
                    try
                    {
                        DatabaseRoom.removeRoom(hotel, kamar.getNomorKamar());
                    }

                    catch (RoomTidakDitemukanException kamarTidakAda)
                    {
                        System.out.println(kamarTidakAda.getPesan());
                    }
                }
                HOTEL_DATABASE.remove(hotel);
                return true;
            }
        }

        throw new HotelTidakDitemukanException(id);
    }
}
