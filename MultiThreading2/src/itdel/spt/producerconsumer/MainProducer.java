package itdel.spt.producerconsumer;

/**
 *
 * @author Matius Smith
 */
public class MainProducer {
    public static void main(String[] args) {
        // TODO code application logic here
        CookieShop cs = new CookieShop(3, 2, 5);
        cs.startInteracting();
    }
    
}
