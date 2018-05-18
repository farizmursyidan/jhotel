package jhotel;

/**
 * Ini adalah kelas Exception yang akan menghandle jika hotel yang ingin dihapus tidak terdapat di database
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */

public class HotelTidakDitemukanException extends Exception
{
    private int hotel_error;

    public HotelTidakDitemukanException(int hotel_input)
    {
        super("Hotel dengan ID : ");
        hotel_error = hotel_input;
    }

    public String getPesan()
    {
        return super.getMessage() + hotel_error + " tidak ditemukan.";

    }
}
