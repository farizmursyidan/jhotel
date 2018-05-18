package jhotel;
import java.util.ArrayList;

/**
 * Ini adalah kelas Database Customer yang menampung daftar Customer hotel.
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */

public class DatabaseCustomer
{
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();
    private static int LAST_CUSTOMER_ID = 0;

    /**
    * Method ini adalah accessor untuk mendapatkan data customer dari database
    * @return CUSTOMER_DATABASE mengembalikan database customer
    */

    public static ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
    }

    /**
     * Method ini berfungsi untuk mendapatkan ID customer terakhir dari database
     * @return LAST_CUSTOMER_ID ini adalah mengembalikan ID customer terakhir dari database
     */

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

    /**
     * Method ini berfungsi untuk mendapatkan data customer dari database
     * @param id adalah parameter ID yang dibutuhkan untuk mendapatkan data customer
     * @return pelanggan adalah mengembalikan data customer
     */

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
     * Method ini berfungsi untuk mengecek data customer yang dimasukkan ketika login dengan database
     * apabila cocok, maka customer dapat login
     * @param email adalah parameter email yang dibutuhkan untuk login
     * @param password adalah parameter password yang dibutuhkan untuk login
     * @return pelanggan adalah mengembalikan data customer
     */

    public static Customer getCustomerLogin(String email, String password)
    {
        for(Customer pelanggan : CUSTOMER_DATABASE)
        {
            if(pelanggan.getEmail().equals(email) && pelanggan.getPassword().equals(password))
            {
                return pelanggan;
            }
        }

        return null;
    }

    /**
    * Method ini berfungsi untuk menghapus customer dari database
    * @param id adalah parameter ID yang dibutuhkan untuk menghapus data customer
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
