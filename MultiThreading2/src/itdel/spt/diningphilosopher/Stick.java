package itdel.spt.diningphilosopher;

/**
 *
 * @author Matius Smith
 */
public class Stick {
    private static final int USED = 1;
    private static final int UNUSED = 0;
    private int state = UNUSED;
    private Philosopher user = null;
    private final String name;
    
    public Stick(String name){
        this.name = name;
    }
    public String getName(){
        return (name);
    }
    public boolean use(Philosopher philosopher){
        if(user == null){
            user = philosopher;
            state = USED;
            return (true);
        }
        return (false);
    }
    
    public synchronized boolean release(Philosopher philosopher){
        if(user != null && user == philosopher){
            user = null;
            state = UNUSED;
            return (true);
        }
        return (false);
    }
    
    public boolean isUsed(){
        return (state == USED);
    }
    public boolean isAvailable(){
        return (!isUsed());
    }
}