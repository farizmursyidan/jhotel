
/**
 * Ini adalah kelas Pesanan yang mengolah pesanan customer saat memesan hotel.
 *
 * @author A. Fariz Mursyidan
 * @version 01.03.2018
 */
public class Pesanan
{
    private double biaya;
    private Customer pelanggan;
    private String namaPelanggan;
    private String jenisKamar;
    private boolean isDiproses;
    private boolean isSelesai;

    /**
    * Method ini merupakan constructor untuk meng-assign instance variable 
    * @param biaya ini adalah parameter untuk menentukan biaya hotel
    * @param pelanggan ini adalah customer yang memesan hotel
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
    * Method ini adalah accessor untuk mengembalikan nama pelanggan
    * @return namaPelanggan mengembalikan nama pelanggan
    */

    public String getPelanggan()
    {
        return namaPelanggan;
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
    * Method ini adalah mutator untuk menetapkan jumlah biaya
    * @param biaya adalah jumlah biaya
    */

    public void setBiaya(double biaya)
    {
        this.biaya = biaya;
    }

    /**
    * Method ini adalah mutator untuk menetapkan pelanggan baru
    * @param baru adalah pelanggan baru
    */

    public void setPelanggan(Customer baru)
    {
        pelanggan = baru;
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
    * Method ini adalah mutator untuk mencetak jumlah biaya
    */

    public void printData()
    {
    	System.out.printf("Biaya yang harus dibayar : %.1f",biaya);
    }

}
