package jhotel;
/**
 * Ini adalah kelas yang bertujuan untuk membuat kamar dengan tipe Single Room.
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */
public class SingleRoom extends Room
{
    private static final TipeKamar TIPE_KAMAR = TipeKamar.SINGLE;

    /**
     * Ini adalah constructor yang berfungsi untuk membuat objek kamar dengan tipe Single Room
     * @param hotel adalah parameter untuk menentukan pada hotel mana kamar tersebut berada
     * @param nomor_kamar adalah parameter untuk menentukan pada kamar tersebut memiliki nomor berapa
     * @param dailyTariff adalah parameter untuk menentukan pada harga per hari dari kamar tersebut
     */

    public SingleRoom(Hotel hotel, String nomor_kamar, double dailyTariff)
    {
        super(hotel, nomor_kamar, dailyTariff);
    }

    /**
     * Method ini berfungsi untuk mendapatkan tipe kamar
     * @return TIPE_KAMAR ini adalah mengembalikan tipe kamar
     */

    public TipeKamar getTipeKamar()
    {
        return TIPE_KAMAR;
    }
}
