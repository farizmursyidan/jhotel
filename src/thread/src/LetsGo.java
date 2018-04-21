public class LetsGo extends Thread{

    public static void main(String[] args)
    {
        RunForYourLife Lionel = new RunForYourLife("Lionel");
        RunForYourLife Andres = new RunForYourLife("Andres");
        RunForYourLife Messi = new RunForYourLife("Messi");

        Lionel.setPriority(Thread.MIN_PRIORITY);
        Andres.setPriority(Thread.NORM_PRIORITY);
        Messi.setPriority(Thread.MAX_PRIORITY);

        Lionel.start();
        Andres.start();
        Messi.start();
    }
}
