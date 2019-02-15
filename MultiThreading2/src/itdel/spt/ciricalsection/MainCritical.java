package itdel.spt.ciricalsection;

/**
 *
 * @author Matius Smith
 */
public class MainCritical {
    public static void main(String[] args) {
        // TODO code application logic here
        Printer p = new Printer(System.out, 500);
        User user1 = new User(p);
        User user2 = new User(p);
        User user3 = new User(p);
        
        user1.workOn("0123456789");
        user2.workOn("abcdefghij");
        user3.workOn("#!@#$%^&*()_+");
    }
}
