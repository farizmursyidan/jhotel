
/**
 * Class JHotel merupakan class utama dan terdapat main pada class ini
 *
 * @author A. Fariz Mursyidan
 * @version 01.03.2018
 */
public class JHotel
{
    public static void main(String[] args)
    {
    	Customer pelanggan = new Customer(1506724682, "Fariz");
    	Lokasi lokasiHotel = new Lokasi(15067, 24682, "Lokasi hotel ini di pusat kota");
    	Hotel hotelFariz = new Hotel("Hotel Fariz", lokasiHotel, 5);
    	Pesanan pesen = new Pesanan(100000, pelanggan);
    	pelanggan.printData();
    	pesen.printData();
    	hotelFariz.printData();
    	pelanggan.setNama("Kiel");
    	pelanggan.printData();
    	pesen.printData();
    }

    public JHotel()
    {
    	
    }
}
