import javax.xml.crypto.Data;
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
        DatabaseCustomer.addCustomer(new Customer("A", 3, 7, 1997));
        DatabaseCustomer.addCustomer(new Customer("B", 13, 12, 1997));
        DatabaseCustomer.addCustomer(new Customer("C", 23, 11, 1997));

        for(Customer pelanggan : DatabaseCustomer.getCustomerDatabase())
        {
            System.out.println(pelanggan);
        }

        DatabaseHotel.addHotel(new Hotel("Alexis", new Lokasi(12, 35, "Alexis"), 5));
        DatabaseHotel.addHotel(new Hotel("Baubaunya", new Lokasi(45, 67, "Bau"), 5));
        DatabaseHotel.addHotel(new Hotel("Changrila", new Lokasi(78, 90, "Temennya Shangrila"), 5));

        for(Hotel hotel : DatabaseHotel.getHotelDatabase())
        {
            System.out.println(hotel);
        }

        DatabaseRoom.addRoom(new SingleRoom(DatabaseHotel.getHotel(1), "A1", StatusKamar.VACANT));
        DatabaseRoom.addRoom(new DoubleRoom(DatabaseHotel.getHotel(2), "B2", StatusKamar.VACANT));
        DatabaseRoom.addRoom(new PremiumRoom(DatabaseHotel.getHotel(3), "C3", StatusKamar.VACANT));
        DatabaseRoom.addRoom(new PremiumRoom(DatabaseHotel.getHotel(1), "D4", StatusKamar.VACANT));

        for(Room kamar : DatabaseRoom.getRoomDatabase())
        {
            System.out.println(kamar + "\n");
        }

        DatabasePesanan.addPesanan(new Pesanan(1, DatabaseCustomer.getCustomer(1)));
        DatabasePesanan.addPesanan(new Pesanan(2, DatabaseCustomer.getCustomer(2)));
        DatabasePesanan.addPesanan(new Pesanan(3, DatabaseCustomer.getCustomer(3)));

        for(Pesanan pesan : DatabasePesanan.getPesananDatabase())
        {
            System.out.println(pesan);
        }

        Administrasi.pesananDitugaskan(DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(1)), DatabaseRoom.getRoom(DatabaseHotel.getHotel(1), "A1"));
        Administrasi.pesananDitugaskan(DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(2)), DatabaseRoom.getRoom(DatabaseHotel.getHotel(1), "D4"));
        Administrasi.pesananDitugaskan(DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(3)), DatabaseRoom.getRoom(DatabaseHotel.getHotel(2), "B2"));

        for(Pesanan pesan : DatabasePesanan.getPesananDatabase())
        {
            System.out.println(pesan);
        }

        Administrasi.pesananDibatalkan(DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(2)));
        Administrasi.pesananSelesai(DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(1)));
        Administrasi.pesananSelesai(DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(3)));

        for(Pesanan pesan : DatabasePesanan.getPesananDatabase())
        {
            System.out.println(pesan);
        }
    }

    public JHotel()
    {
        
    }
}
