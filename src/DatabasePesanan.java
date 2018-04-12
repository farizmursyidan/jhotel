import java.util.ArrayList;

/**
 * Ini adalah kelas Database Pesanan yang menampung daftar pesanan.
 *
 * @author A. Fariz Mursyidan
 * @version 08.03.2018
 */
public class DatabasePesanan
{
    private static final ArrayList<Pesanan> PESANAN_DATABASE = new ArrayList<>();
    private static final int LAST_PESANAN_ID = 0;

    /**
    * Method ini berfungsi untuk menambah pesanan baru 
    * @param baru ini adalah parameter untuk membuat pesanan baru
    */

    public static boolean addPesanan(Pesanan baru)
    {
        if(PESANAN_DATABASE.contains(baru))
        {
            if(baru.getStatusAktif())
            {
                return false;
            }
            else
            {
                PESANAN_DATABASE.add(baru);
                return true;
            }
        }
        else
        {
            PESANAN_DATABASE.add(baru);
            return true;
        }
    }

    /**
    * Method ini berfungsi untuk menghapus pesanan 
    * @param pesan ini adalah parameter untuk menghapus pesanan
    */

    public static boolean removePesanan(Pesanan pesan)
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

                if(PESANAN_DATABASE.remove(pesanan))
                {
                    return true;
                }
            }
        }

        return false;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan pesanan customer
    * @return null
    */

    public static Pesanan getPesanan(int id)
    {
        for(int i = 0;i < PESANAN_DATABASE.size(); i++)
        {
            Pesanan pesan = PESANAN_DATABASE.get(i);
            if(pesan.getID() == id)
            {
                return pesan;
            }
        }
        return null;
    }

    public static Pesanan getPesanan(Room kamar)
    {
        for(int i = 0;i < PESANAN_DATABASE.size(); i++)
        {
            Pesanan pesan = PESANAN_DATABASE.get(i);
            if(pesan.getRoom() == kamar)
            {
                return pesan;
            }
        }
        return null;
    }

    public static Pesanan getPesananAktif(Customer pelanggan)
    {
        for(int i = 0;i < PESANAN_DATABASE.size(); i++)
        {
            Pesanan pesan = PESANAN_DATABASE.get(i);
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
