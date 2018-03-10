
/**
 * Ini adalah kelas Pesanan yang mengolah pesanan customer saat memesan hotel.
 *
 * @author A. Fariz Mursyidan
 * @version 08.03.2018
 */
public class Pesanan
{
    private double biaya;
    private Customer pelanggan;
    private String namaPelanggan;
    private TipeKamar tipeKamar;
    private boolean isDiproses;
    private boolean isSelesai;
    private Room kamar;

    /**
    * Method ini merupakan constructor untuk meng-assign instance variable 
    * @param biaya adalah parameter untuk menentukan biaya hotel
    * @param pelanggan adalah customer yang memesan hotel
    * @return tidak ada
    */

    public Pesanan(double biaya, Customer pelanggan)
    {
    	this.biaya = biaya;
    	this.pelanggan = pelanggan;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan jumlah biaya
    * @return biaya mengembalikan jumlah biaya
    */

    public double getBiaya()
    {
        return biaya;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan data pelanggan
    * @return pelanggan mengembalikan data pelanggan
    */

    public Customer getPelanggan()
    {
        return pelanggan;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan nama pelanggan
    * @return namaPelanggan mengembalikan nama pelanggan
    */

    public String getNamaPelanggan()
    {
    	return namaPelanggan;
    }

    /**
    * Method ini adalah accessor untuk mengembalikan tipe kamar
    * @return tipeKamar mengembalikan tipe kamar
    */

    public TipeKamar getTipeKamar()
    {
    	return tipeKamar;
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

    /**
    * Method ini adalah mutator untuk menetapkan jumlah biaya
    * @param biaya adalah jumlah biaya
    */

    public void setBiaya(double biaya)
    {
        this.biaya = biaya;
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
    * Method ini adalah mutator untuk menetapkan nama pelanggan baru
    * @param namaPelanggan adalah nama pelanggan baru
    */

    public void setNamaPelanggan(String namaPelanggan)
    {
    	this.namaPelanggan = namaPelanggan;
    }

    /**
    * Method ini adalah mutator untuk menetapkan tipe kamar pelanggan
    * @param tipeKamar adalah tipe kamar pelanggan
    */

    public void setTipeKamar(TipeKamar tipeKamar)
    {
    	this.tipeKamar = tipeKamar;
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
    * Method ini adalah mutator untuk mencetak data pesanan
    */

    public void printData()
    {
        System.out.println("\nPesanan");
    	System.out.println("Nama Pelanggan : " + pelanggan.getNama());
    	System.out.printf("Tipe Kamar : %s\n",tipeKamar);
    	System.out.println("Status Layanan Diproses : " + isDiproses);
    	System.out.println("Status Layanan Selesai : " + isSelesai);
    }

}
