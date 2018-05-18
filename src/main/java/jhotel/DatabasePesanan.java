package jhotel;
import java.util.ArrayList;

/**
 * Ini adalah kelas Database Pesanan yang menampung daftar pesanan.
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */
public class DatabasePesanan
{
    private static ArrayList<Pesanan> PESANAN_DATABASE = new ArrayList<Pesanan>();
    private static int LAST_PESANAN_ID = 0;

    /**
    * Method ini berfungsi untuk menambah pesanan baru 
    * @param baru ini adalah parameter untuk membuat pesanan baru
    */

    public static boolean addPesanan(Pesanan baru) throws PesananSudahAdaException
    {
        for(Pesanan pesan : PESANAN_DATABASE)
        {
            if(pesan.getStatusAktif()==true && pesan.getID()==baru.getID())
            {
                throw new PesananSudahAdaException(baru);
            }
        }
        PESANAN_DATABASE.add(baru);
        LAST_PESANAN_ID = baru.getID();
        return true;
    }

    /**
    * Method ini berfungsi untuk menghapus pesanan 
    * @param pesan ini adalah parameter untuk menghapus pesanan
    */

    public static boolean removePesanan(Customer pesan) throws PesananTidakDitemukanException
    {
        for(Pesanan pesanan : PESANAN_DATABASE)
        {
            if(pesanan.equals(pesan))
            {
                if(pesanan.getRoom() != null)
                {
                    Administrasi.pesananDibatalkan(pesanan);
                }
                else
                {
                    if(pesanan.getStatusAktif())
                    {
                        pesanan.setStatusAktif(false);
                    }
                }

                PESANAN_DATABASE.remove(pesanan);
                return true;
            }
        }

        throw new PesananTidakDitemukanException(pesan);
    }

    /**
     * Method ini berfungsi untuk mendapatkan data pesanan dari database
     * @param id adalah parameter ID yang dibutuhkan untuk mendapatkan data pesanan
     * @return pesan adalah mengembalikan data pesanan
     */

    public static Pesanan getPesanan(int id)
    {
        for(Pesanan pesan : PESANAN_DATABASE)
        {
            if(pesan.getID() == id)
            {
                return pesan;
            }
        }
        return null;
    }

    /**
     * Method ini berfungsi untuk mendapatkan data pesanan yang sedang berstatus aktif dari database
     * @param kamar adalah parameter kamar yang dibutuhkan untuk mendapatkan data pesanan
     * @return pesan adalah mengembalikan data pesanan aktif
     */

    public static Pesanan getPesananAktif(Room kamar)
    {
        for(Pesanan pesan : PESANAN_DATABASE)
        {
            if(pesan.getRoom() == kamar && pesan.getStatusAktif() == true)
            {
                return pesan;
            }
        }
        return null;
    }

    /**
     * Method ini berfungsi untuk mendapatkan data pesanan yang sedang berstatus aktif dari database
     * @param pelanggan adalah parameter kamar yang dibutuhkan untuk mendapatkan data pesanan
     * @return pesan adalah mengembalikan data pesanan aktif
     */

    public static Pesanan getPesananAktif(Customer pelanggan)
    {
        for(Pesanan pesan : PESANAN_DATABASE)
        {
            if(pesan.getPelanggan() == pelanggan && pesan.getStatusAktif() == true)
            {
                return pesan;
            }
        }
        return null;
    }

    /**
     * Method ini adalah accessor untuk mendapatkan data pesanan dari database
     * @return PESANAN_DATABASE mengembalikan database pesanan
     */

    public static ArrayList<Pesanan> getPesananDatabase()
    {
        return PESANAN_DATABASE;
    }

    /**
     * Method ini berfungsi untuk mendapatkan ID pesanan terakhir dari database
     * @return LAST_PESANAN_ID ini adalah mengembalikan ID pesanan terakhir dari database
     */

    public static int getLastPesananID()
    {
        return LAST_PESANAN_ID;
    }

}
