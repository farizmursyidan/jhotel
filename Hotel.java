
/**
 * Ini adalah kelas Hotel yang mendeskripsikan nama, lokasi, dan bintang hotel tersebut.
 *
 * @author A. Fariz Mursyidan
 * @version 01.03.2018
 */
public class Hotel
{
    private String nama;
    private Lokasi lokasi;
    private int bintang;

    /**
    * Method ini merupakan constructor untuk meng-assign instance variable 
    * @param nama ini adalah parameter untuk menentukan nama pelanggan
    * @param lokasi ini adalah parameter untuk menentukan lokasi hotel
    * @param bintang ini adalah parameter untuk memberikan bintang hotel
    * @return tidak ada
    */

    public Hotel(String nama, Lokasi lokasi, int bintang)
    {
        this.nama = nama;
        this.lokasi = lokasi;
        this.bintang = bintang;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan nilai bintang hotel
    * @return bintang mengembalikan nilai bintang hotel
    */

    public int getBintang()
    {
        return bintang;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan nama hotel
    * @return nama mengembalikan nama hotel
    */

    public String getNama()
    {
        return nama;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan lokasi hotel
    * @return lokasi mengembalikan lokasi hotel
    */

    public Lokasi getLokasi()
    {
        return lokasi;
    }

    /**
    * Method ini adalah mutator untuk menetapkan nama hotel
    * @param nama adalah nama hotel
    */

    public void setNama(String nama)
    {
        this.nama = nama;
    }

    /**
    * Method ini adalah mutator untuk menetapkan lokasi hotel
    * @param lokasi adalah lokasi hotel
    */

    public void setLokasi(Lokasi lokasi)
    {
        this.lokasi = lokasi;
    }

    /**
    * Method ini adalah mutator untuk menetapkan bintang hotel
    * @param bintang adalah bintang hotel
    */

    public void setBintang(int bintang)
    {
        this.bintang = bintang;
    }

    /**
    * Method ini adalah mutator untuk mencetak nama hotel
    */

    public void printData()
    {
        System.out.printf("Nama hotel : %s\n",nama);
    }
}
