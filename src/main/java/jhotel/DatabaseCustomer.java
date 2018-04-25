package jhotel;
import java.util.ArrayList;

/**
 * Ini adalah kelas Database Customer yang menampung daftar Customer hotel.
 *
 * @author A. Fariz Mursyidan
 * @version 08.03.2018
 */

public class DatabaseCustomer
{
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();
    private static int LAST_CUSTOMER_ID = 0;

    /**
    * Method ini adalah accessor untuk mengembalikan data customer dari database
    * @return null
    */

    public static ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
    }

    public static int getLastCustomerID()
    {
        return LAST_CUSTOMER_ID;
    }

    /**
    * Method ini berfungsi untuk menambah customer baru 
    * @param baru ini adalah parameter untuk menambah customer baru
    */

    public static boolean addCustomer(Customer baru) throws PelangganSudahAdaException
    {
        for(Customer pelanggan : CUSTOMER_DATABASE)
        {
            if(pelanggan.getID() == baru.getID() || pelanggan.getEmail() == baru.getEmail())
            {
                throw new PelangganSudahAdaException(baru);
            }
        }

        CUSTOMER_DATABASE.add(baru);
        LAST_CUSTOMER_ID = baru.getID();
        return true;
    }

    public static Customer getCustomer(int id)
    {
        for(Customer pelanggan : CUSTOMER_DATABASE)
        {
            if(pelanggan.getID() == id)
            {
                return pelanggan;
            }
        }

        return null;
    }

    /**
    * Method ini berfungsi untuk menghapus customer 
    * @param id ini adalah parameter untuk menghapus customer
    */

    public static boolean removeCustomer(int id) throws PelangganTidakDitemukanException
    {
        for(Customer pelanggan : CUSTOMER_DATABASE)
        {
            if(pelanggan.getID() == id)
            {
                for(Pesanan pesanan : DatabasePesanan.getPesananDatabase())
                {
                    if(pesanan.getPelanggan() == pelanggan)
                    {
                        try
                        {
                            DatabasePesanan.removePesanan(pelanggan);
                        }

                        catch (PesananTidakDitemukanException pesananTidakAda)
                        {
                            System.out.println(pesananTidakAda.getPesan());
                        }
                    }
                }

                CUSTOMER_DATABASE.remove(pelanggan);
                return true;
            }
        }

        throw new PelangganTidakDitemukanException(id);
    }
}
