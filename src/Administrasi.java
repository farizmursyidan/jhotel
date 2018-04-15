
/**
 * Ini adalah kelas administrasi yang mengatur segala hal tentang pemesanan kamar hotel
 *
 * @author A. Fariz Mursyidan
 * @version 08.03.2018
 */
public class Administrasi
{
    /**
    * Method ini berfungsi untuk memproses sebuah pesanan baru
    * @param pesan mengambil data dari kelas Pesanan dan kamar mengambil data dari kelas Room
    */

    public static void pesananDitugaskan(Pesanan pesan, Room kamar)
    {
        pesan.setStatusSelesai(false);
        pesan.setStatusDiproses(true);
        pesan.setRoom(kamar);
        kamar.setStatusKamar(StatusKamar.BOOKED);
    }

    /**
    * Method ini berfungsi untuk mem-booking sebuah kamar
    * @param pesan mengambil data dari kelas Pesanan dan kamar mengambil data dari kelas Room
    */

    public static void roomAmbilPesanan(Pesanan pesan, Room kamar)
    {
        kamar.setStatusKamar(StatusKamar.BOOKED);
    }

    /**
    * Method ini berfungsi untuk mengosongkan sebuah kamar
    * @param kamar mengambil data dari kelas Room
    */

    public static void roomLepasPesanan(Room kamar)
    {
        kamar.setStatusKamar(StatusKamar.VACANT);
    }

    /**
    * Method ini berfungsi untuk membatalkan pesanan dengan mengubah
    * status selesai dan diproses menjadi false dan status room menjadi null serta me-unlink masing-masing objek.
    * @param kamar mengambil data dari kelas Room
    */

    public static void pesananDibatalkan(Room kamar)
    {
        // Pesanan pesan = kamar.getPesanan();
        // pesan.setStatusSelesai(false);
        // pesan.setStatusDiproses(false);
        // pesan.setStatusAktif(false);
        // pesan.setRoom(null);
        kamar.setStatusKamar(StatusKamar.VACANT);
    }

    /**
    * Method ini berfungsi untuk menyelesaikan pesanan dengan mengubah
    * status selesai menjadi true dan diproses menjadi false dan status room menjadi null serta me-unlink masing-masing objek.
    * @param kamar mengambil data dari kelas Room
    */

    public static void pesananSelesai(Room kamar)
    {
        // Pesanan pesan = kamar.getPesanan();
        // pesan.setStatusSelesai(true);
        // pesan.setStatusDiproses(false);
        // pesan.setStatusAktif(false);
        // pesan.setRoom(null);
        kamar.setStatusKamar(StatusKamar.VACANT);
    }

    /**
    * Method ini berfungsi untuk membatalkan pesanan dengan mengubah
    * status selesai dan diproses menjadi false dan status room menjadi null serta me-unlink masing-masing objek.
    * @param pesan mengambil data dari kelas Pesanan
    */

    public static void pesananDibatalkan(Pesanan pesan)
    {
        pesan.getRoom().setStatusKamar(StatusKamar.VACANT);
        pesan.setStatusSelesai(false);
        pesan.setStatusDiproses(false);
        pesan.setRoom(null);
    }

    /**
    * Method ini berfungsi untuk menyelesaikan pesanan dengan mengubah
    * status selesai menjadi true dan diproses menjadi false dan status room menjadi null serta me-unlink masing-masing objek.
    * @param pesan mengambil data dari kelas Pesanan
    */

    public static void pesananSelesai(Pesanan pesan)
    {
        pesan.getRoom().setStatusKamar(StatusKamar.VACANT);
        pesan.setStatusSelesai(true);
        pesan.setStatusDiproses(false);
        pesan.setRoom(null);
    }
}
