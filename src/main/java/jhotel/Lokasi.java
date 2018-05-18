package jhotel;
/**
 * Ini adalah kelas Lokasi yang mendeskripsikan lokasi hotel melalui koordinat dan deskripsi.
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */
public class Lokasi
{
    private float x_coord;
    private float y_coord;
    private String deskripsiLokasi;

    /**
    * Method ini merupakan constructor untuk membuat objek lokasi
    * @param x_coord ini adalah parameter untuk menentukan koordinat x dari lokasi
    * @param y_coord ini adalah parameter untuk menentukan koordinat y dari lokasi
    * @param deskripsiLokasi ini adalah parameter untuk memberikan deskripsi dari lokasi hotel
    * @return tidak ada
    */

    public Lokasi(float x_coord, float y_coord, String deskripsiLokasi)
    {
        this.x_coord = x_coord;
        this.y_coord = y_coord;
        this.deskripsiLokasi = deskripsiLokasi;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan nilai koordinat x
    * @return x_coord mengembalikan nilai koordinat x
    */

    public float getX()
    {
        return x_coord;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan nilai koordinat y
    * @return y_coord mengembalikan nilai koordinat y
    */

    public float getY()
    {
        return y_coord;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan deskripsi lokasi
    * @return deskirpsiLokasi mengembalikan nilai koordinat x
    */

    public String getDeskripsi()
    {
        return deskripsiLokasi;
    }

    /**
    * Method ini adalah mutator untuk menetapkan nilai koordinat x
    * @param x_coord adalah nilai koordinat x
    */

    public void setX(float x_coord)
    {
        this.x_coord = x_coord;
    }

    /**
    * Method ini adalah mutator untuk menetapkan nilai koordinat y
    * @param y_coord adalah nilai koordinat y
    */

    public void setY(float y_coord)
    {
        this.y_coord = y_coord;
    }

    /**
    * Method ini adalah mutator untuk menetapkan deskripsi lokasi
    * @param deskripsi adalah deskripsi lokasi hotel
    */

    public void setDeskripsi(String deskripsi)
    {
        deskripsiLokasi = deskripsi;
    }

    public String toString()
    {
        return "\nKoordinat X      : " + getX() +
               "\nKoordinat Y      : " + getY() +
               "\nDeskripsi Lokasi : " + getDeskripsi();
    }
}
