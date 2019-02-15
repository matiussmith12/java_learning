package itdel.spt.ciricalsection;

import java.io.PrintStream;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Matius Smith
 */
public class SynchronizedPrinter extends Printer {
    private Semaphore s = null;
    
    public SynchronizedPrinter(PrintStream stream, long delay){
        super(stream, delay);
        s = new Semaphore(1);
    }
    
    @Override
    public void print(String document){
        int documentLength = document.length();
        (new Thread(new Runnable(){
            
            @Override
            public void run(){
                try{
                    s.acquire();
                    for(int i = 0; i < documentLength; i++){
                        stream.println(document.charAt(i));
                        Thread.sleep(delay);
                    }
                    s.release();
                }
                catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        })).start();
    }
}