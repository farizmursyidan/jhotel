package jhotel;

/**
 * Ini adalah kelas Exception yang akan menghandle jika kamar yang ingin dihapus tidak terdapat di database
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */

public class RoomTidakDitemukanException extends Exception
{
    private Hotel hotel_error;
    private String room_error;

    public RoomTidakDitemukanException(Hotel hotel_input, String room_input)
    {
        super("Kamar yang terletak di : ");
        hotel_error = hotel_input;
        room_error = room_input;
    }

    public String getPesan()
    {
        return super.getMessage() + hotel_error + " dan dengan nomor kamar " + room_error + " tidak ditemukan.";
    }
}
