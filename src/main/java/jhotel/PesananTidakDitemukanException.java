package jhotel;

/**
 * Ini adalah kelas Exception yang akan menghandle jika pesanan yang ingin dihapus tidak terdapat di database
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */

public class PesananTidakDitemukanException extends Exception
{
    private Customer pelanggan_error;

    public PesananTidakDitemukanException(Customer pelanggan_input)
    {
        super("Pesanan yang dipesan oleh: ");
        pelanggan_error = pelanggan_input;
    }

    public String getPesan()
    {
        return super.getMessage() + pelanggan_error.getNama() + " tidak ditemukan.";
    }
}
