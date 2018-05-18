package jhotel;

/**
 * Ini adalah kelas Exception yang akan menghandle jika hotel yang dimasukkan ke database sudah ada sebelumnya
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */

public class HotelSudahAdaException extends Exception
{
    private Hotel hotel_error;

    public HotelSudahAdaException(Hotel hotel_input)
    {
        super("Hotel dengan nama : ");
        hotel_error = hotel_input;
    }

    public String getPesan()
    {
        return super.getMessage() + hotel_error.getNama()+ " sudah terdaftar.";
    }
}
