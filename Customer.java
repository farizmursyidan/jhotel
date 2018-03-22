import java.util.Date;
import java.util.regex.*;
/**
 * Ini adalah kelas Customer untuk mengolah data customer hotel.
 *
 * @author A. Fariz Mursyidan
 * @version 08.03.2018
 */
public class Customer
{
    protected int id;
    protected String nama;
    protected String email;
    protected Date dob;

    /**
    * Method ini merupakan constructor untuk meng-assign instance variable 
    * @param id ini adalah parameter untuk menentukan id customer
    * @param nama ini adalah parameter untuk menentukan nama customer
    * @return tidak ada
    */

    public Customer(int id, String nama, int tanggal, int bulan, int tahun)
    {
        this.id = id;
        this.nama = nama;
        this.dob = new Date(tanggal,bulan,tahun);
    }

    public Customer(int id, String nama, Date dob)
    {
        this.id = id;
        this.nama = nama;
        this.dob = dob;
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

    public String getEmail()
    {
        return email;
    }

    public Date getDOB()
    {
        return dob;
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

    public void setEmail(String email)
    {
        String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9][A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(email);
        
        if (m.matches())
        {
            this.email = email;
        }

        else
        {
            this.email = null;
        }
    }

    public void setDOB(Date dob)
    {
        this.dob = dob;
    }

    /**
    * Method ini adalah mutator untuk mencetak nama customer
    */

    // public void printData()
    // {
    //     System.out.println("\nCustomer");
    //     System.out.printf("ID : %d\n",id);
    //     System.out.printf("Nama : %s\n",nama);
    // }

    public String toString()
    {
        return null;
    }
}