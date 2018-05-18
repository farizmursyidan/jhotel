package jhotel;

/**
 * Ini adalah kelas Exception yang akan menghandle jika pelanggan yang ingin dihapus tidak terdapat di database
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */

public class PelangganTidakDitemukanException extends Exception
{
    private int pelanggan_error;

    public PelangganTidakDitemukanException(int pelanggan_input)
    {
        super("Data Customer dengan ID : ");
        pelanggan_error = pelanggan_input;
    }

    public String getPesan()
    {
        return super.getMessage() + pelanggan_error + " tidak ditemukan.";
    }
}
