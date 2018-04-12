
/**
 * Ini adalah kelas Room yang mengolah kamar customer saat memesan hotel.
 *
 * @author A. Fariz Mursyidan
 * @version 08.03.2018
 */
public abstract class Room
{
    private Hotel hotel;
    private String nomor_kamar;
    private boolean isAvailable;
    private StatusKamar status_kamar;
    private Pesanan pesan;
    protected double dailyTariff;

    /**
    * Method ini merupakan constructor untuk meng-assign instance variable 
    * @param hotel adalah parameter untuk memasukkan data dari kelas hotel
    * @param nomor_kamar adalah nomor kamar pelanggan
    * @param isAvailable adalah status ketersediaan kamar
    * @param dailyTariff adalah biaya kamar
    * @param status_kamar adalah status kamar saat ini
    * @param pesan adalah parameter untuk memasukkan data dari kelas pesanan
    * @return tidak ada
    */

    public Room(Hotel hotel, String nomor_kamar, boolean isAvailable, StatusKamar status_kamar)
    {
        this.hotel = hotel;
        this.nomor_kamar = nomor_kamar;
        this.isAvailable = isAvailable;
        this.status_kamar = status_kamar;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan data hotel
    * @return hotel mengembalikan data hotel
    */

    public Hotel getHotel()
    {
        return hotel;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan nomor kamar
    * @return nomor_kamar mengembalikan nomor kamar
    */

    public String getNomorKamar()
    {
        return nomor_kamar;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan status kamar sedang tersedia atau tidak
    * @return isAvailable mengembalikan status kamar
    */

    public boolean getStatusAvailable()
    {
        return isAvailable;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan harga per hari sewa kamar
    * @return dailyTariff mengembalikan harga per hari sewa kamar
    */

    public double getDailyTariff()
    {
        return dailyTariff;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan status kamar
    * @return status_kamar mengembalikan status kamar
    */

    public StatusKamar getStatusKamar()
    {
        return status_kamar;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan data pesanan
    * @return pesan mengembalikan data pesanan
    */

    public Pesanan getPesanan()
    {
        return pesan;
    }

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
    * Method ini adalah mutator untuk menetapkan status ketersediaan kamar
    * @param isAvailable adalah status ketersediaan kamar
    */

    public void setStatusAvailable(boolean isAvailable)
    {
        this.isAvailable = isAvailable;
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

    /**
    * Method ini adalah mutator untuk menetapkan data pesanan
    * @param pesan adalah data pesanan
    */

    public void setPesanan(Pesanan pesan)
    {
        this.pesan = pesan;
    }

    public String toString()
    {
        if(isAvailable)
        {
            return "Nama Hotel      : " + hotel.getNama() +
                   "Tipe Kamar      : " + getTipeKamar() +
                   "Harga           : " + getDailyTariff() +
                   "Status Kamar    : " + status_kamar;
        }

        else
        {
            return "Nama Hotel      : " + hotel.getNama() +
                   "Tipe Kamar      : " + getTipeKamar() +
                   "Harga           : " + getDailyTariff() +
                   "Status Kamar    : " + status_kamar +
                   "Pelanggan       : " + pesan.getPelanggan().getNama();
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