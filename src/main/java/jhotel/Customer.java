package jhotel;
import java.text.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.*;

/**
 * Ini adalah kelas Customer untuk mengolah data customer hotel.
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */

public class Customer
{
    private int id;
    private String nama;
    private String email;
    private Date dob;
    private String password;
    private String photo;
    SimpleDateFormat tbt = new SimpleDateFormat("dd MMMMMMMM yyyy");

    /**
    * Method ini merupakan constructor untuk membuat objek customer
    * @param nama ini adalah parameter untuk menentukan nama customer
    * @param tanggal ini adalah parameter untuk menentukan tanggal lahir customer
    * @param bulan ini adalah parameter untuk menentukan bulan lahir customer
    * @param tahun ini adalah parameter untuk menentukan tahun lahir customer
    * @param email ini adalah parameter untuk menentukan email customer
    * @param password ini adalah parameter untuk menentukan password customer
    * @param photo ini adalah parameter untuk menentukan string lokasi tempat penyimpanan foto profil customer pada server
    * @return tidak ada
    */

    public Customer(String nama, int tanggal, int bulan, int tahun, String email, String password, String photo)
    {
        this.id = DatabaseCustomer.getLastCustomerID() + 1;
        this.nama = nama;
        this.email = email;
        this.dob = new GregorianCalendar(tahun, bulan-1, tanggal).getTime();
        this.password = password;
        this.photo = photo;
    }

    /**
     * Method ini merupakan constructor untuk membuat objek customer
     * @param nama ini adalah parameter untuk menentukan nama customer
     * @param dob ini adalah parameter untuk menentukan tanggal, bulan, dan tahun lahir customer
     * @param email ini adalah parameter untuk menentukan email customer
     * @param password ini adalah parameter untuk menentukan password customer
     * @return tidak ada
     */

    public Customer(String nama, Date dob, String email, String password)
    {
        this.id = DatabaseCustomer.getLastCustomerID() + 1;
        this.nama = nama;
        this.dob = dob;
        this.email = email;
        this.password = password;
    }

    /**
     * Method ini adalah accessor untuk mendapatkan string lokasi tempat penyimpanan foto profil customer pada server
     * @return photo mengembalikan string lokasi tempat penyimpanan foto profil customer pada server
     */

    public String getPhoto()
    {
        return photo;
    }

    /**
    * Method ini adalah accessor untuk mendapatkan id customer
    * @return id mengembalikan id customer
    */

    public int getID()
    {
        return id;
    }

    /**
    * Method ini adalah accessor untuk mendapatkan nama customer
    * @return nama mengembalikan nama customer
    */

    public String getNama()
    {
        return nama;
    }

    /**
    * Method ini adalah accessor untuk mendapatkan email customer
    * @return email mengembalikan email customer
    */

    public String getEmail()
    {
        return email;
    }

    /**
    * Method ini adalah accessor untuk mendapatkan tanggal, bulan, tahun lahir customer
    * @return dob mengembalikan tanggal, bulan, lahir customer
    */

    public Date getDOB()
    {
        return dob;
    }

    /**
    * Method ini adalah accessor untuk mendapatkan password customer
    * @return password mengembalikan password customer
    */

    public String getPassword()
    {
        return password;
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
    * @param nama adalah nama customer
    */

    public void setNama(String nama)
    {
        this.nama = nama;
    }

    /**
    * Method ini adalah mutator untuk menetapkan email customer
    * @param email adalah email customer
    */

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

    /**
     * Method ini adalah mutator untuk menetapkan tanggal, bulan, tahun lahir customer
     * @param dob adalah tanggal, bulan, tahun lahir customer
     */

    public void setDOB(Date dob)
    {
        this.dob = dob;
    }

    /**
     * Method ini adalah mutator untuk menetapkan password customer
     * @param password adalah password customer
     */

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String toString()
    {
        if(DatabasePesanan.getPesananAktif(this) != null)
        {
            return "\nCustomer ID   : " + getID() +
                   "\nNama          : " + getNama() +
                   "\nE-mail        : " + getEmail() +
                   "\nDate of Birth : " + tbt.format(getDOB()) +
                   "\nBooking order is in progress";
        }

        else
        {
            return "\nCustomer ID   : " + getID() +
                   "\nNama          : " + getNama() +
                   "\nE-mail        : " + getEmail() +
                   "\nDate of Birth : " + tbt.format(getDOB());
        }
    }
}