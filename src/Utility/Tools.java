package Utility;


public class Tools {
    public static void bekle(int sn) {
        try {
            Thread.sleep(1000 * sn);//ms beklediği için
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
