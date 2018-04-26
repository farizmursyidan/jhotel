package jhotel;
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
        if(kamar.getStatusKamar() == StatusKamar.VACANT)
        {
            pesan.setStatusSelesai(false);
            pesan.setStatusDiproses(true);
            pesan.setRoom(kamar);
            kamar.setStatusKamar(StatusKamar.BOOKED);
        }

        else
        {
            pesan.setStatusAktif(false);
        }
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

        // kamar.getPesanan().setStatusSelesai(false);
        // tidak bisa dilakukan karena pesan merupakan private object milik class Room

        Pesanan pesan = DatabasePesanan.getPesananAktif(kamar);
        pesan.setStatusSelesai(false);
        pesan.setStatusDiproses(false);
//        pesanTemp.setRoom(null);
        pesan.setStatusAktif(false);

        roomLepasPesanan(kamar);
    }

    public static void pesananSelesai(Room kamar)
    {
        Pesanan pesan = DatabasePesanan.getPesananAktif(kamar);
        pesan.setStatusSelesai(true);
        pesan.setStatusDiproses(false);
//        pesanTemp.setRoom(null);
        pesan.setStatusAktif(false);

        roomLepasPesanan(kamar);
    }

    public static void pesananDibatalkan(Pesanan pesan)
    {
        roomLepasPesanan(pesan.getRoom());

        pesan.setStatusSelesai(false);
        pesan.setStatusDiproses(false);
        pesan.setStatusAktif(false);
//        pesan.setRoom(null);
    }

    public static void pesananSelesai(Pesanan pesan)
    {
        roomLepasPesanan(pesan.getRoom());

        pesan.setStatusSelesai(true);
        pesan.setStatusDiproses(false);
        pesan.setStatusAktif(false);
//        pesan.setRoom(null);
    }
}
