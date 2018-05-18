package jhotel;
/**
 * WIni adalah kelas yang bertujuan untuk membuat kamar dengan tipe Premium Room.
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */
public class PremiumRoom extends Room
{
    private static final TipeKamar TIPE_KAMAR = TipeKamar.PREMIUM;
    private static final double DISCOUNT = 0.3;

    /**
     * Ini adalah constructor yang berfungsi untuk membuat objek kamar dengan tipe Premium Room
     * @param hotel adalah parameter untuk menentukan pada hotel mana kamar tersebut berada
     * @param nomor_kamar adalah parameter untuk menentukan pada kamar tersebut memiliki nomor berapa
     * @param dailyTariff adalah parameter untuk menentukan pada harga per hari dari kamar tersebut
     */
    
    public PremiumRoom(Hotel hotel, String nomor_kamar, double dailyTariff)
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

    /**
     * Method ini berfungsi untuk mendapatkan diskon harga kamar
     * @return DISCOUNT ini adalah mengembalikan diskon
     */

    public double getDiscount()
    {
        return DISCOUNT;
    }

    /**
     * Method ini berfungsi untuk menetapkan tarif harian kamar
     * @param dailyTariff adalah tarif harian yang ingin diset
     */

    public void setDailyTariff(double dailyTariff)
    {
        super.setDailyTariff(dailyTariff*DISCOUNT);
    }
}
