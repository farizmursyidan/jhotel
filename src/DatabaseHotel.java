import java.util.ArrayList;
/**
 * Ini adalah kelas Database Hotel yang menampung daftar Hotel.
 *
 * @author A. Fariz Mursyidan
 * @version 08.03.2018
 */
public class DatabaseHotel
{
    private static ArrayList<Hotel> HOTEL_DATABASE = new ArrayList<Hotel>();
    private static int LAST_HOTEL_ID = 0;

    /**
    * Method ini adalah accessor untuk mengembalikan data hotel dari database
    * @return null
    */

    public static ArrayList<Hotel> getHotelDatabase()
    {
        return HOTEL_DATABASE;
    }

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

    public static Hotel getHotel(int id)
    {
        for(Hotel hotel : HOTEL_DATABASE)
        {
            if(id == hotel.getID())
            {
                return hotel;
            }
        } 

        return null;
    }

    /**
    * Method ini berfungsi untuk menghapus hotel 
    * @param id ini adalah parameter untuk menghapus hotel
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
