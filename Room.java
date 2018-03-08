
/**
 * Write a description of class Room here.
 *
 * @author A. Fariz Mursyidan
 * @version 08.03.2018
 */
public class Room
{
    private Hotel hotel;
    private int id;
    private String nomor_kamar;
    private boolean isAvailable;
    private Customer customer;
    private double dailyTariff;
    private StatusKamar status_kamar;
    private Pesanan pesan;

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */

    public Hotel getHotel()
    {
        return hotel;
    }

    public int getID()
    {
        return id;
    }

    public String getNomorKamar()
    {
        return nomor_kamar;
    }

    public boolean getStatusAvailable()
    {
        return isAvailable;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public double getDailyTariff()
    {
        return dailyTariff;
    }

    public StatusKamar getStatusKamar()
    {
        return status_kamar;
    }

    public Pesanan getPesanan()
    {
        return pesan;
    }

    public void setHotel(Hotel hotel)
    {
        this.hotel = hotel;
    }

    public void setID(int id)
    {
        this.id = id;
    }

    public void setNomorKamar(String nomor_kamar)
    {
        this.nomor_kamar = nomor_kamar;
    }

    public void setStatusAvailable(boolean isAvailable)
    {
        this.isAvailable = isAvailable;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public void setDailyTariff(double dailyTariff)
    {
        this.dailyTariff = dailyTariff;
    }

    public void setStatusKamar(StatusKamar status_kamar)
    {
        this.status_kamar = status_kamar;
    }

    public void setPesanan(Pesanan pesan)
    {
        this.pesan = pesan;
    }

    public void printData()
    {
        
    }
}
