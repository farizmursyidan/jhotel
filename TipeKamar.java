
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

    public String toString;

    TipeKamar(String toString)
    {
    	this.toString = toString;
    }

    public String toString()
    {
    	return toString;
    }
}