package itdel.spt.ciricalsection;

import java.io.PrintStream;

/**
 *
 * @author Matius Smith
 */
public class Printer {
    protected PrintStream stream = null;
    protected long delay = 0;
    
    public Printer(PrintStream stream, long delay){
        this.stream = stream;
        this.delay = delay;
    }
    
    public void print(String document){
        int documentLength = document.length();
        
        (new Thread (new Runnable(){
            
            @Override
            public void run(){
                for(int i = 0; i < documentLength; i++){
                    stream.println(document.charAt(i));
                    try{
                        Thread.sleep(delay);
                    }
                    catch(InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
            }
        })).start();
    }
}
