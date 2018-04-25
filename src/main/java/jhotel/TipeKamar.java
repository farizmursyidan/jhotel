package jhotel;
/**
 * Ini adalah kelas enum Tipe Kamar yang berisi daftar tipe kamar
 *
 * @author A. Fariz Mursyidan
 * @version 08.03.2018
 */
public enum TipeKamar
{
    SINGLE("Single"),
    DOUBLE("Double"),
    PREMIUM("Premium");

    public String deskripsi;

    TipeKamar(String deskripsi)
    {
    	this.deskripsi = deskripsi;
    }

    public String toString()
    {
    	return deskripsi;
    }
}