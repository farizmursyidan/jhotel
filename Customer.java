
/**
 * Ini adalah kelas Customer untuk mengolah data customer hotel.
 *
 * @author A. Fariz Mursyidan
 * @version 01.03.2018
 */
public class Customer
{
    protected int id;
    protected String nama;

    /**
    * Method ini merupakan constructor untuk meng-assign instance variable 
    * @param id ini adalah parameter untuk menentukan id customer
    * @param nama ini adalah parameter untuk menentukan nama customer
    * @return tidak ada
    */

    public Customer(int id, String nama)
    {
        this.id = id;
        this.nama = nama;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan id customer
    * @return id mengembalikan id customer
    */

    public int getID()
    {
        return id;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan nama customer
    * @return nama mengembalikan nama customer
    */

    public String getNama()
    {
        return nama;
    }

    /**
    * Method ini adalah mutator untuk menetapkan id customer
    * @param id adalah id customer
    */

    public void setID(int id)
    {
        this.id = id;
    }

    /**
    * Method ini adalah mutator untuk menetapkan nama customer
    * @param nama mengembalikan nama customer
    */

    public void setNama(String nama)
    {
        this.nama = nama;
    }

    /**
    * Method ini adalah mutator untuk mencetak nama customer
    */

    public void printData()
    {
        System.out.printf("Nama customer : %s\n",nama);
    }
}