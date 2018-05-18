package jhotel;
/**
 * Ini adalah kelas enum Status Kamar yang berisi daftar status kamar.
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */
public enum StatusKamar
{
    BOOKED("Booked"),
    PROCESSED("Processed"),
    VACANT("Vacant");

    public String deskripsi;

    StatusKamar(String deskripsi)
    {
    	this.deskripsi = deskripsi;
    }

    public String toString()
    {
    	return deskripsi;
    }
}
