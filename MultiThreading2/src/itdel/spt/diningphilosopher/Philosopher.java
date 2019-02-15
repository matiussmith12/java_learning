package itdel.spt.diningphilosopher;

/**
 *
 * @author Matius Smith
 */
public class Philosopher implements Runnable{
    private final String name;
    private Stick left = null;
    private Stick right = null;
    private int cycle = 0;
    
    public Philosopher(String _name){
        name = _name;
    }
    
    public String getName(){
        return (name);
    }
    
    public void setLeftStick(Stick _stick){
        left = _stick;
    }
    
    public void setRightStick(Stick _stick){
        right = _stick;
    }   
    
    public void setCycle(int _cycle){
        cycle = _cycle;
    }
    
    public void pickUpSticks(){
        long sleepTime = 100;
        while(!left.use(this) || !right.use(this)){
            say("missed the chopsticks");
            dropSticks();
            goSleeping(sleepTime);
            sleepTime  *= 2;
        }
    }
    
    private void dropSticks(){
        left.release(this);
        right.release(this);
    }
    
    private void eat(){
        pickUpSticks();
        say("eating");
        goSleeping(1000);
        dropSticks();
    }
    
    private void think(){
        say("thinking");
        goSleeping(2000);
    }
    
    private void goSleeping(long _millis){
        try{
            Thread.sleep(_millis);
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }
    }
    
    public void say(String message){
        System.out.println(name + ":" + message);
    }
    
    @Override
    public void run(){
        for(int i = 0; i < cycle; ++i){
            eat();
            think();
        }
    }
}
