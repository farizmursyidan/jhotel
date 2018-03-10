
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
    	Lokasi lokasiHotel = new Lokasi(15067, 24682, "Lokasi hotel ini dekat UI");
    	Hotel hotelFariz = new Hotel("Hotel Fariz", lokasiHotel, 5);
    	Pesanan pesan = new Pesanan(100000, pelanggan);
    	Room kamar = new Room(hotelFariz, "123", true, pelanggan, 100000, StatusKamar.BOOKED);
        pesan.setTipeKamar(TipeKamar.PREMIUM);

        System.out.println("Welcome to JHotel");
        lokasiHotel.printData();
        pelanggan.printData();
        hotelFariz.printData();

        System.out.println("\n====================Method 1====================");
        Administrasi.pesananDitugaskan(pesan, kamar);
        kamar.printData();
        pesan.printData();

        System.out.println("\n====================Method 2====================");
        Administrasi.pesananDitugaskan(pesan, kamar);
        Administrasi.pesananDibatalkan(kamar);
        kamar.printData();
        pesan.printData();

        System.out.println("\n====================Method 3====================");
        Administrasi.pesananDitugaskan(pesan, kamar);
        Administrasi.pesananDibatalkan(pesan);
        kamar.printData();
        pesan.printData();

        System.out.println("\n====================Method 4====================");
        Administrasi.pesananDitugaskan(pesan, kamar);
        Administrasi.pesananSelesai(kamar);
        kamar.printData();
        pesan.printData();

        System.out.println("\n====================Method 5====================");
        Administrasi.pesananDitugaskan(pesan, kamar);
        Administrasi.pesananSelesai(pesan);
        kamar.printData();
        pesan.printData();
    }

    public JHotel()
    {
    	
    }
}
