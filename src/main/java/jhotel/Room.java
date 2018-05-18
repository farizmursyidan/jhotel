package jhotel;
/**
 * Ini adalah kelas Room yang mengolah kamar customer saat memesan hotel.
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
 */
public abstract class Room
{
    private Hotel hotel;
    private String nomor_kamar;
    private StatusKamar status_kamar;
    protected double dailyTariff;

    /**
    * Method ini merupakan constructor untuk membuat objek room
    * @param hotel adalah parameter untuk memasukkan data dari kelas hotel
    * @param nomor_kamar adalah nomor kamar
    * @param dailyTariff adalah tarif harian kamar
    * @return tidak ada
    */

    public Room(Hotel hotel, String nomor_kamar, double dailyTariff)
    {
        this.hotel = hotel;
        this.nomor_kamar = nomor_kamar;
        this.status_kamar = StatusKamar.VACANT;
        this.dailyTariff = dailyTariff;
    }

    /**
    * Method ini adalah accessor untuk mendapatkan data hotel
    * @return hotel mengembalikan data hotel
    */

    public Hotel getHotel()
    {
        return hotel;
    }

    /**
    * Method ini adalah accessor untuk mendapatkan nomor kamar
    * @return nomor_kamar mengembalikan nomor kamar
    */

    public String getNomorKamar()
    {
        return nomor_kamar;
    }

    /**
    * Method ini adalah accessor untuk mendapatkan harga per hari sewa kamar
    * @return dailyTariff mengembalikan harga per hari sewa kamar
    */

    public double getDailyTariff()
    {
        return dailyTariff;
    }

    /**
    * Method ini adalah accessor untuk mendapatkan status kamar
    * @return status_kamar mengembalikan status kamar
    */

    public StatusKamar getStatusKamar()
    {
        return status_kamar;
    }

    /**
     * Method ini adalah accessor untuk mendapatkan tipe kamar
     */

    public abstract TipeKamar getTipeKamar();

    /**
    * Method ini adalah mutator untuk menetapkan data hotel
    * @param hotel adalah data hotel
    */

    public void setHotel(Hotel hotel)
    {
        this.hotel = hotel;
    }

    /**
    * Method ini adalah mutator untuk menetapkan nomor kamar
    * @param nomor_kamar adalah nomor kamar
    */

    public void setNomorKamar(String nomor_kamar)
    {
        this.nomor_kamar = nomor_kamar;
    }

    /**
    * Method ini adalah mutator untuk menetapkan harga per hari sewa kamar
    * @param dailyTariff adalah harga per hari sewa kamar
    */

    public void setDailyTariff(double dailyTariff)
    {
        this.dailyTariff = dailyTariff;
    }

    /**
    * Method ini adalah mutator untuk menetapkan status kamar
    * @param status_kamar adalah status kamar
    */

    public void setStatusKamar(StatusKamar status_kamar)
    {
        this.status_kamar = status_kamar;
    }

    public String toString()
    {
        if(DatabasePesanan.getPesananAktif(this) == null)
        {
            return "\nNama Hotel      : " + getHotel().getNama() +
                   "\nTipe Kamar      : " + getTipeKamar() +
                   "\nHarga           : " + getDailyTariff() +
                   "\nStatus Kamar    : " + getStatusKamar();
        }

        else
        {
            return "\nNama Hotel      : " + getHotel().getNama() +
                   "\nTipe Kamar      : " + getTipeKamar() +
                   "\nHarga           : " + getDailyTariff() +
                   "\nStatus Kamar    : " + getStatusKamar() +
                   "\nPelanggan       : " + DatabasePesanan.getPesananAktif(this).getPelanggan().getNama();
        }
    }

    /**
    * Method ini adalah mutator untuk mencetak data kamar
    */

    // public void printData()
    // {
    //     System.out.println("\nRoom");
    //     System.out.println("Nama Hotel : " + hotel.getNama());
    //     System.out.printf("Nomor Kamar : %s\n",nomor_kamar);
    //     System.out.println("Tersedia : " + isAvailable);
    //     System.out.println("Harga : " + dailyTariff);
    //     System.out.println("Tipe Kamar : " + getTipeKamar().toString());
    //     System.out.println("Status Kamar : " + status_kamar);
    // }
}
