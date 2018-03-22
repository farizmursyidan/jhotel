import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
        Customer cust1 = new Customer(123, "fariz", new GregorianCalendar(1997,07,12).getTime());
        //Customer pelanggan = new Customer(1506724682, "Fariz");
        // Lokasi lokasiHotel = new Lokasi(15067, 24682, "Lokasi hotel ini dekat UI");
        // Hotel hotel = new Hotel("Hotel Fariz", lokasiHotel, 5);
        // Room singleRoom = new SingleRoom(hotel, "123", true, StatusKamar.BOOKED);
        // Pesanan pesan = new Pesanan(3, pelanggan, singleRoom);
        // Room doubleRoom = new DoubleRoom(hotel, "123", true, StatusKamar.BOOKED);
        // Pesanan pesan2 = new Pesanan(5, pelanggan, doubleRoom);

        // pelanggan.setEmail("e.t.d@");
        // System.out.println("e.t.d@ = " + pelanggan.getEmail());
        // pelanggan.setEmail("Ee_.td@ui.ac.id");
        // System.out.println("Ee_.td@ui.ac.id = " + pelanggan.getEmail());
        // pelanggan.setEmail("fariz.modul5@netlab.com");
        // System.out.println("fariz.modul5@netlab.com = " + pelanggan.getEmail());
        

        // System.out.println("Welcome to JHotel");
        // //lokasiHotel.printData();
        // //pelanggan.printData();
        // //hotel.printData();
        
        // singleRoom.setDailyTariff(1500000);
        // pesan.setBiaya();

        // doubleRoom.setDailyTariff(3000000);
        // pesan2.setBiaya();

        // System.out.println("\n====================SingleRoom====================");
        // Administrasi.pesananDitugaskan(pesan, singleRoom);
        // //singleRoom.printData();
        // //pesan.printData();

        // System.out.println("\n====================DoubleRoom====================");
        // Administrasi.pesananDitugaskan(pesan2, doubleRoom);
        // //doubleRoom.printData();
        // //pesan2.printData();

        // System.out.println("\n====================Pengecekan SingleRoom====================");

        // if(singleRoom instanceof DoubleRoom)
        // {
        //     System.out.println("Benar Double Room");
        // }

        // else
        // {
        //     System.out.println("Salah, bukan Double Room");
        // }

        // System.out.println("\n====================Pengecekan DoubleRoom====================");

        // if(doubleRoom instanceof DoubleRoom)
        // {
        //     System.out.println("Benar Double Room");
        // }

        // else
        // {
        //     System.out.println("Salah, bukan Double Room");
        // }
    }

    public JHotel()
    {
        
    }
}
