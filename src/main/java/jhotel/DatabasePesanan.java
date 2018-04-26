package jhotel;
import java.util.ArrayList;

/**
 * Ini adalah kelas Database Pesanan yang menampung daftar pesanan.
 *
 * @author A. Fariz Mursyidan
 * @version 08.03.2018
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
    * Method ini adalah accessor untuk mengembalikan pesanan customer
    * @return null
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
    * Method ini adalah accessor untuk mengembalikan pesanan customer dari database
    * @return null
    */

    public static ArrayList<Pesanan> getPesananDatabase()
    {
        return PESANAN_DATABASE;
    }

    public static int getLastPesananID()
    {
        return LAST_PESANAN_ID;
    }

    /**
    * Method ini berfungsi untuk membatalkan pesanan customer
    * @return null
    */

}
