package itdel.spt.producerconsumer;

/**
 *
 * @author Matius Smith
 */
public abstract class Actor implements Runnable {
    protected final String name;
    protected final CookieJar jar;
    protected final long delay;
    private int cycle = 0;
    
    public Actor(String name, CookieJar jar, long delay){
        this.name = name;
        this.jar = jar;
        this.delay = delay;
    
    }
    
    public String getName(){
        return (name);
    }
    
    public void setCycle(int cycle){
        this.cycle = cycle;
    }
    
    @Override
    public void run(){
        int i = 0;
        while( i < cycle){
            work();
            
            try{
                Thread.sleep(delay);
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
            ++i;
        }
    }
    
    public void say(String message){
        System.out.println(name + ": " + message);
    }
    
    public  abstract void work();
}