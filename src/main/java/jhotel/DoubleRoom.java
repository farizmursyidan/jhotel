package jhotel;
/**
 * Ini adalah kelas yang bertujuan untuk membuat kamar dengan tipe Double Room.
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */
public class DoubleRoom extends Room
{
    private static final TipeKamar TIPE_KAMAR = TipeKamar.DOUBLE;
    private Customer customer2;

    /**
     * Ini adalah constructor yang berfungsi untuk membuat objek kamar dengan tipe Double Room
     * @param hotel adalah parameter untuk menentukan pada hotel mana kamar tersebut berada
     * @param nomor_kamar adalah parameter untuk menentukan pada kamar tersebut memiliki nomor berapa
     * @param dailyTariff adalah parameter untuk menentukan pada harga per hari dari kamar tersebut
     */

    public DoubleRoom(Hotel hotel, String nomor_kamar, double dailyTariff)
    {
        super(hotel, nomor_kamar, dailyTariff);
    }

    public Customer getCustomer2()
    {
        return customer2;
    }

    /**
     * Method ini berfungsi untuk mendapatkan tipe kamar
     * @return TIPE_KAMAR ini adalah mengembalikan tipe kamar
     */

    public TipeKamar getTipeKamar()
    {
        return TIPE_KAMAR;
    }

    public void setCustomer2(Customer customer2)
    {
        this.customer2 = customer2;
    }
}
