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
        System.out.println("-Exception Pelanggan Sudah Ada-");

        Customer pelanggan1 = new Customer("A", 3, 7, 1997, "email@ui.ac.id");
        try {
            DatabaseCustomer.addCustomer(pelanggan1);
        }

        catch (PelangganSudahAdaException tes)
        {
            System.out.println(tes.getPesan());
        }

        try {
            DatabaseCustomer.addCustomer(pelanggan1);
        }

        catch (PelangganSudahAdaException tes)
        {
            System.out.println(tes.getPesan());
        }

        Customer pelanggan3 = new Customer("C", 23, 11, 1997, "email3@ui.ac.id");
        try {
            DatabaseCustomer.addCustomer(pelanggan3);
        }

        catch (PelangganSudahAdaException tes)
        {
            System.out.println(tes.getPesan());
        }

        for(Customer pelanggan : DatabaseCustomer.getCustomerDatabase())
        {
            System.out.println(pelanggan);
        }

        Hotel hotel1 = new Hotel("Alexis", new Lokasi(12, 35, "Alexis"), 5);
        System.out.println("\n-Exception Hotel Sudah Ada-");
        try {
            DatabaseHotel.addHotel(hotel1);
        }

        catch (HotelSudahAdaException tes)
        {
            System.out.println(tes.getPesan());
        }

        try {
            DatabaseHotel.addHotel(hotel1);
        }

        catch (HotelSudahAdaException tes)
        {
            System.out.println(tes.getPesan());
        }

        Hotel hotel3 = new Hotel("Changrila", new Lokasi(78, 90, "Temennya Shangrila"), 5);
        try {
            DatabaseHotel.addHotel(hotel3);
        }

        catch (HotelSudahAdaException tes)
        {
            System.out.println(tes.getPesan());
        }

        Hotel hotel4 = new Hotel("Dudu", new Lokasi(89, 99, "Dudu"), 5);
        try {
            DatabaseHotel.addHotel(hotel4);
        }

        catch (HotelSudahAdaException tes)
        {
            System.out.println(tes.getPesan());
        }

        for(Hotel hotel : DatabaseHotel.getHotelDatabase())
        {
            System.out.println(hotel);
        }

        System.out.println("\n-Exception Room Sudah Ada-");

        Room kamar1 = new SingleRoom(hotel1, "A1");
        try {
            DatabaseRoom.addRoom(kamar1);
        }

        catch (RoomSudahAdaException test){
            System.out.println(test.getPesan());
        }

        try {
            DatabaseRoom.addRoom(kamar1);
        }

        catch (RoomSudahAdaException test){
            System.out.println(test.getPesan());
        }

        Room kamar3 = new DoubleRoom(hotel3, "B2");
        try {
            DatabaseRoom.addRoom(kamar3);
        }

        catch (RoomSudahAdaException test){
            System.out.println(test.getPesan());
        }

        Room kamar4 = new PremiumRoom(hotel4, "C3");
        try {
            DatabaseRoom.addRoom(kamar4);
        }

        catch (RoomSudahAdaException test){
            System.out.println(test.getPesan());
        }

        for(Room kamar : DatabaseRoom.getRoomDatabase())
        {
            System.out.println(kamar);
        }

        System.out.println("\n-Exception Pesanan Sudah Ada-");

        Pesanan pesan1 = new Pesanan(1, pelanggan1);
        try {
            DatabasePesanan.addPesanan(pesan1);
        }

        catch (PesananSudahAdaException tes)
        {
            System.out.println(tes.getPesan());
        }

        try {
            DatabasePesanan.addPesanan(pesan1);
        }

        catch (PesananSudahAdaException tes)
        {
            System.out.println(tes.getPesan());
        }

        Pesanan pesan3 = new Pesanan(3, pelanggan3);
        try {
            DatabasePesanan.addPesanan(pesan3);
        }

        catch (PesananSudahAdaException tes)
        {
            System.out.println(tes.getPesan());
        }

        Customer pelanggan4 = new Customer("D", 23, 11, 1997, "email4@ui.ac.id");
        Pesanan pesan4 = new Pesanan(4, pelanggan4);
        try {
            DatabasePesanan.addPesanan(pesan4);
        }

        catch (PesananSudahAdaException tes)
        {
            System.out.println(tes.getPesan());
        }

        for(Pesanan pesan : DatabasePesanan.getPesananDatabase())
        {
            System.out.println(pesan);
        }

        System.out.println("---------------------");

        System.out.println("\n-Exception Pelanggan Tidak Ditemukan-");
        try {
            DatabaseCustomer.removeCustomer(5);
        }

        catch (PelangganTidakDitemukanException tes)
        {
            System.out.println(tes.getPesan());
        }

//        for(Customer pelanggan : DatabaseCustomer.getCustomerDatabase())
//        {
//            System.out.println(pelanggan);
//        }

        System.out.println("\n-Exception Hotel Tidak Ditemukan-");
        try {
            DatabaseHotel.removeHotel(5);
        }

        catch (HotelTidakDitemukanException tes)
        {
            System.out.println(tes.getPesan());
        }

//        for(Hotel hotel : DatabaseHotel.getHotelDatabase())
//        {
//            System.out.println(hotel);
//        }

        System.out.println("\n-Exception Room Tidak Ditemukan-");
        try {
            DatabaseRoom.removeRoom(hotel4, "Z5");
        }

        catch (RoomTidakDitemukanException tes)
        {
            System.out.println(tes.getPesan());
        }

//        for(Room kamar : DatabaseRoom.getRoomDatabase())
//        {
//            System.out.println(kamar + "\n");
//        }

        Customer pelanggan5 = new Customer("D", 3, 4, 1995, "email5@ui.ac.id");

        System.out.println("\n-Exception Pesanan Tidak Ditemukan-");
        try {
            DatabasePesanan.removePesanan(pelanggan5);
        }

        catch (PesananTidakDitemukanException tes)
        {
            System.out.println(tes.getPesan());
        }

//        for(Pesanan pesan : DatabasePesanan.getPesananDatabase())
//        {
//            System.out.println(pesan);
//        }

//        Administrasi.pesananDitugaskan(DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(1)), DatabaseRoom.getRoom(DatabaseHotel.getHotel(1), "A1"));
//        Administrasi.pesananDitugaskan(DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(2)), DatabaseRoom.getRoom(DatabaseHotel.getHotel(1), "D4"));
//        Administrasi.pesananDitugaskan(DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(3)), DatabaseRoom.getRoom(DatabaseHotel.getHotel(2), "B2"));
//
//        for(Pesanan pesan : DatabasePesanan.getPesananDatabase())
//        {
//            System.out.println(pesan);
//        }
//
//        Administrasi.pesananDibatalkan(DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(2)));
//        Administrasi.pesananSelesai(DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(1)));
//        Administrasi.pesananSelesai(DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(3)));
//
//        for(Pesanan pesan : DatabasePesanan.getPesananDatabase())
//        {
//            System.out.println(pesan);
//        }
    }

    public JHotel()
    {
        
    }
}
