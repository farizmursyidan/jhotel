
/**
 * Write a description of class PremiumRoom here.
 *
 * @author A. Fariz Mursyidan
 * @version 15.03.2018
 */
public class PremiumRoom extends Room
{
    private static final TipeKamar TIPE_KAMAR = TipeKamar.PREMIUM;
    private static final double DISCOUNT = 0.3;
    
    public PremiumRoom(Hotel hotel, String nomor_kamar, boolean isAvailable, StatusKamar status_kamar)
    {
        super(hotel, nomor_kamar, isAvailable, status_kamar);
    }

    public TipeKamar getTipeKamar()
    {
        return TIPE_KAMAR;
    }

    public double getDiscount()
    {
        return DISCOUNT;
    }

    public void setDailyTariff(double dailyTariff)
    {
        super.setDailyTariff(dailyTariff*DISCOUNT);
    }
}
