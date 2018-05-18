package jhotel;

/**
 * Ini adalah kelas Exception yang akan menghandle jika kamar yang dimasukkan ke database sudah ada sebelumnya
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */

public class RoomSudahAdaException extends Exception
{
    private Room room_error;

    public RoomSudahAdaException(Room room_input)
    {
        super("Kamar dengan nomor ruang ");
        room_error = room_input;
    }

    public String getPesan()
    {
        return super.getMessage() + room_error.getNomorKamar() + " pada " + room_error.getHotel() + " sudah terdaftar.";
    }
}
