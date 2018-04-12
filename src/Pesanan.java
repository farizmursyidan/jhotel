import java.util.Date;
/**
 * Ini adalah kelas Pesanan yang mengolah pesanan customer saat memesan hotel.
 *
 * @author A. Fariz Mursyidan
 * @version 08.03.2018
 */
public class Pesanan
{
    private int id;
    private double biaya;
    private double jumlahHari;
    private Customer pelanggan;
    private boolean isAktif;
    private boolean isDiproses;
    private boolean isSelesai;
    private Room kamar;
    private Date tanggalPesan;

    /**
    * Method ini merupakan constructor untuk meng-assign instance variable
    * @param pelanggan adalah customer yang memesan hotel
    * @return tidak ada
    */

    public Pesanan(double jumlahHari, Customer pelanggan)
    {
    	this.jumlahHari = jumlahHari;
    	this.pelanggan = pelanggan;
    	isAktif = true;
    	tanggalPesan = new Date();
    	id = DatabasePesanan.getLastPesananID()+1;
    }

//    public Pesanan(double jumlahHari, Customer pelanggan, Room kamar, Date tanggalPesan)
//    {
//        this.biaya = kamar.getDailyTariff()*jumlahHari;
//        this.jumlahHari = jumlahHari;
//        this.pelanggan = pelanggan;
//        this.kamar = kamar;
//        this.tanggalPesan = tanggalPesan;
//    }

    public int getID()
    {
        return id;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan jumlah biaya
    * @return biaya mengembalikan jumlah biaya
    */

    public double getBiaya()
    {
        return biaya;
    }

    public double getJumlahHari()
    {
        return jumlahHari;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan data pelanggan
    * @return pelanggan mengembalikan data pelanggan
    */

    public Customer getPelanggan()
    {
        return pelanggan;
    }

    public boolean getStatusAktif()
    {
        return isAktif;
    }


    /**
    * Method ini adalah accessor untuk mengembalikan status diproses
    * @return isDiproses mengembalikan status diproses
    */

    public boolean getStatusDiproses()
    {
        return isDiproses;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan status selesai
    * @return isSelesai mengembalikan status selesai
    */

    public boolean getStatusSelesai()
    {
        return isSelesai;
    }    

    /**
    * Method ini adalah accessor untuk mengembalikan rincian data kamar pelanggan
    * @return kamar mengembalikan rincian data kamar pelanggan
    */

    public Room getRoom()
    {
    	return kamar;
    }

    public Date getTanggalPesan()
    {
        return tanggalPesan;
    }

    public void setID()
    {
        this.id = id;
    }

    /**
    * Method ini adalah mutator untuk menetapkan jumlah biaya
    */

    public void setBiaya()
    {
        biaya = kamar.getDailyTariff()*jumlahHari;
    }

    public void setJumlahHari(double jumlahHari)
    {
        this.jumlahHari = jumlahHari;
    }

    /**
    * Method ini adalah mutator untuk menetapkan data pelanggan baru
    * @param pelanggan adalah data pelanggan baru
    */

    public void setPelanggan(Customer pelanggan)
    {
        this.pelanggan = pelanggan;
    }

    public void setStatusAktif(boolean aktif)
    {
        isAktif = aktif;
    }

    /**
    * Method ini adalah mutator untuk menetapkan status diproses
    * @param diproses adalah status sedang diproses atau tidak
    */

    public void setStatusDiproses(boolean diproses)
    {
        isDiproses = diproses;
    }

    /**
    * Method ini adalah mutator untuk menetapkan status selesai
    * @param selesai adalah status sudah selesai atau belum
    */

    public void setStatusSelesai(boolean selesai)
    {
        isSelesai = selesai;
    }

    /**
    * Method ini adalah mutator untuk menetapkan data kamar pelanggan
    * @param kamar adalah data kamar pelanggan
    */

    public void setRoom(Room kamar)
    {
    	this.kamar = kamar;
    }

    public Date setTanggalPesan(Date tanggalPesan)
    {
        this.tanggalPesan = tanggalPesan;
        return tanggalPesan;
    }

    public String toString()
    {
        String final_status = "KOSONG";
        
        if (isDiproses == true && isSelesai == false)
        {
            final_status = "DIPROSES";
        } 

        else if (isDiproses == false && isSelesai == false)
        {
            final_status = "KOSONG";
        }
        
        else if (isDiproses == false && isSelesai == true)
        {
            final_status = "SELESAI";
        }
        
        return "Dibuat Oleh " +pelanggan.getNama() +
                ".Proses booking untuk" +kamar.getHotel()+
                "Kamar Nomor " + kamar.getNomorKamar()+
                "dengan tipe kamar yang diinginkan "+kamar.getTipeKamar()+
                ". Status :" +final_status+ ".";
    }

    /**
    * Method ini adalah mutator untuk mencetak data pesanan
    */

    // public void printData()
    // {
    //     System.out.println("\nPesanan");
    // 	System.out.println("Nama Pelanggan : " + pelanggan.getNama());
    // 	System.out.println("Status Layanan Diproses : " + isDiproses);
    // 	System.out.println("Status Layanan Selesai : " + isSelesai);
    //     System.out.println("Jumlah Hari : " + jumlahHari);
    //     System.out.println("Biaya : " + biaya);
    // }

}
