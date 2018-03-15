
/**
 * Write a description of class DoubleRoom here.
 *
 * @author A. Fariz Mursyidan
 * @version 15.03.2018
 */
public class DoubleRoom extends Room
{
    private static final TipeKamar TIPE_KAMAR = TipeKamar.DOUBLE;
    private Customer customer2;

    public DoubleRoom(Hotel hotel, String nomor_kamar, boolean isAvailable, StatusKamar status_kamar)
    {
        super(hotel, nomor_kamar, isAvailable, status_kamar);
    }

    public Customer getCustomer2()
    {
        return customer2;
    }

    public TipeKamar getTipeKamar()
    {
        return TIPE_KAMAR;
    }

    public void setCustomer2(Customer customer2)
    {
        this.customer2 = customer2;
    }
}
