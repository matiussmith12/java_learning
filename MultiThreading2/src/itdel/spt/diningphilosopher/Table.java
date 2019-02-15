package itdel.spt.diningphilosopher;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matius Smith
 */
public class Table {
    private final List<Philosopher> philosophers;
    private final List<Stick> sticks;
    private final List<Thread> threads;
    
    
    public  Table (int numberofSeat){
        philosophers = new ArrayList<>();
        sticks = new ArrayList<>();
        threads = new ArrayList<>();
        
        for(int i = 0; i< numberofSeat; ++i){
            Philosopher philosopher = new Philosopher("P" + i);
            philosopher.setCycle(5);
            philosophers.add(philosopher);
            threads.add(new Thread(philosopher));
            
            sticks.add(new Stick("S" + i));
        }
        
        for(int i = 0; i < numberofSeat; ++i){
            philosophers.get(i).setRightStick(sticks.get(i));
            philosophers.get(i).setLeftStick(sticks.get((i+1) % numberofSeat));
        }
    }
    
    public void startDining(){
        int _numberofSeat = philosophers.size();
        System.out.println("size: " + _numberofSeat);
        for(int i = 0; i < _numberofSeat; ++i){
            threads.get(i).start();
        }
        
        try{
            for(int i = 0; i < _numberofSeat; ++i){
                threads.get(i).join();
            }       
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }
    }
}















