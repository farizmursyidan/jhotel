package jhotel;
import java.util.Date;
/**
 * Ini adalah kelas Pesanan yang mengolah pesanan customer saat memesan hotel.
 *
 * @author A. Fariz Mursyidan
 * @version 15.05.2018
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
    * Method ini merupakan constructor untuk membuat objek pesanan
    * @param jumlahHari adalah jumlah hari yang diinginkan customer
    * @param idHotel adalah id hotel yang ingin dipesan customer
    * @param nomorKamar adalah nomor kamar yang ingin dipesan customer
    * @param pelanggan adalah customer yang memesan hotel
    * @return tidak ada
    */

    public Pesanan(double jumlahHari, int idHotel, String nomorKamar, Customer pelanggan)
    {
    	this.jumlahHari = jumlahHari;
    	this.pelanggan = pelanggan;
    	this.isAktif = true;
    	this.kamar = DatabaseRoom.getRoom(DatabaseHotel.getHotel(idHotel), nomorKamar);
    	try {
    	    this.biaya = jumlahHari * kamar.getDailyTariff();
        }
        catch (Exception e) {
    	    System.out.println(""+e);
        }
    	this.tanggalPesan = new Date();
    	this.id = DatabasePesanan.getLastPesananID()+1;
    }

//    public Pesanan(double jumlahHari, Customer pelanggan, Room kamar, Date tanggalPesan)
//    {
//        this.biaya = kamar.getDailyTariff()*jumlahHari;
//        this.jumlahHari = jumlahHari;
//        this.pelanggan = pelanggan;
//        this.kamar = kamar;
//        this.tanggalPesan = tanggalPesan;
//    }

    /**
     * Method ini adalah accessor untuk mendapatkan id pesanan
     * @return id mengembalikan id pesanan
     */

    public int getID()
    {
        return id;
    }

    /**
    * Method ini adalah accessor untuk mendapatkan jumlah biaya yang harus dibayar customer
    * @return biaya mengembalikan jumlah biaya
    */

    public double getBiaya()
    {
        return biaya;
    }

    /**
     * Method ini adalah accessor untuk mendapatkan jumlah hari customer ingin menginap
     * @return jumlahHari mengembalikan jumlah hari
     */

    public double getJumlahHari()
    {
        return jumlahHari;
    }

    /**
    * Method ini adalah accessor untuk mendapatkan data pelanggan
    * @return pelanggan mengembalikan data pelanggan
    */

    public Customer getPelanggan()
    {
        return pelanggan;
    }

    /**
     * Method ini adalah accessor untuk mengecek status aktif dari pesanan
     * @return isAktif mengembalikan status aktif pesanan
     */

    public boolean getStatusAktif()
    {
        return isAktif;
    }

    /**
     * Method ini adalah accessor untuk mengecek status diproses dari pesanan
     * @return isDiproses mengembalikan status diproses pesanan
     */

    public boolean getStatusDiproses()
    {
        return isDiproses;
    }

    /**
     * Method ini adalah accessor untuk mengecek status selesai dari pesanan
     * @return isSelesai mengembalikan status selesai pesanan
     */

    public boolean getStatusSelesai()
    {
        return isSelesai;
    }    

    /**
    * Method ini adalah accessor untuk mendapatkan rincian data kamar pelanggan
    * @return kamar mengembalikan rincian data kamar pelanggan
    */

    public Room getRoom()
    {
    	return kamar;
    }

    /**
     * Method ini adalah accessor untuk mendapatkan tanggal kapan customer memesan kamar
     * @return tanggalPesan mengembalikan tanggal dibuatnya pesanan
     */

    public Date getTanggalPesan()
    {
        return tanggalPesan;
    }

    /**
     * Method ini adalah mutator untuk menetapkan id pesanan
     * @param id adalah id pesanan
     */

    public void setID(int id)
    {
        this.id = id;
    }

    /**
    * Method ini adalah mutator untuk menetapkan jumlah biaya
    * @param biaya adalah biaya yang harus dibayar
    */

    public void setBiaya(double biaya)
    {
        this.biaya = kamar.getDailyTariff()*jumlahHari;
    }

    /**
     * Method ini adalah mutator untuk menetapkan jumlah hari
     * @param jumlahHari adalah jumlah hari
     */

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

    /**
     * Method ini adalah mutator untuk menetapkan status aktif
     * @param aktif adalah status sedang aktif atau tidak
     */

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

    /**
     * Method ini adalah mutator untuk menetapkan tanggal pesanan
     * @param tanggalPesan adalah data tanggal pesanan
     */

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

        if(kamar != null)
        {
            return "Pesanan{" +
                    "pelanggan=" + pelanggan.getNama() +
                    ", hotel=" + kamar.getHotel().getNama() +
                    ", kamar=" + kamar.getNomorKamar() +
                    ", tipeKamar=" + kamar.getTipeKamar() +
                    ", status='" + final_status + '\'' +
                    '}';
        }

        else
        {
            return "Pesanan{" +
                    "pelanggan=" + pelanggan.getNama() +
                    ", hotel=null" +
                    ", kamar=null" +
                    ", tipeKamar=null" +
                    ", status='" + final_status + '\'' +
                    '}';
        }
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
