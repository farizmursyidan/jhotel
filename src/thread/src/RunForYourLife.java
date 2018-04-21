import java.util.Random;

public class RunForYourLife extends Thread implements Runnable {

    private Thread t;
    private String nama;
    private int checkpoint;

    public RunForYourLife(String nama)
    {
        this.nama = nama;
        System.out.println(nama + ", ready.");
    }

    public void run()
    {
        System.out.println(nama + ", go!");
        for(checkpoint = 1; checkpoint <= 20; checkpoint++)
        {
            Random rand = new Random();
            int n = rand.nextInt(401) + 100;
            try
            {
                System.out.println(nama + " has passed checkpoint " + checkpoint);
                Thread.sleep(n);
            }

            catch (InterruptedException e)
            {
                System.out.println(nama + " was interrupted");
            }
        }

        System.out.println(nama + " has finished!");
    }

    public void start()
    {
        System.out.println(nama + ", set...");
        if (t == null)
        {
            t = new Thread (this, nama);
            t.start ();
        }
    }
}
