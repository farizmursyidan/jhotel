package jhotel;

/**
 * Ini adalah kelas Exception yang akan menghandle jika pesanan yang dimasukkan ke database sudah ada sebelumnya
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */

public class PesananSudahAdaException extends Exception
{
    private Pesanan pesanan_error;

    public PesananSudahAdaException(Pesanan pesanan_input)
    {
        super("Pesanan yang dipesan oleh : ");
        pesanan_error = pesanan_input;
    }

    public String getPesan()
    {
        return super.getMessage() + pesanan_error.getPelanggan().getNama() + " sudah melakukan pemesanan.";
    }
}
