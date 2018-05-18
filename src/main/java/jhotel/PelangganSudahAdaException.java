package jhotel;

/**
 * Ini adalah kelas Exception yang akan menghandle jika pelanggan yang dimasukkan ke database sudah ada sebelumnya
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */

public class PelangganSudahAdaException extends Exception
{
    private Customer pelanggan_error;

    public PelangganSudahAdaException(Customer pelanggan_input)
    {
        super("Pelanggan dengan data : ");
        pelanggan_error = pelanggan_input;
    }

    public String getPesan()
    {
        return super.getMessage() + pelanggan_error + " sudah terdaftar.";
    }
}
