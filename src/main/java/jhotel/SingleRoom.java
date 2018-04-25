package jhotel;
/**
 * Write a description of class SingleRoom here.
 *
 * @author A. Fariz Mursyidan
 * @version 15.03.2018
 */
public class SingleRoom extends Room
{
    private static final TipeKamar TIPE_KAMAR = TipeKamar.SINGLE;

    public SingleRoom(Hotel hotel, String nomor_kamar)
    {
        super(hotel, nomor_kamar);
    }

    public TipeKamar getTipeKamar()
    {
        return TIPE_KAMAR;
    }
}
