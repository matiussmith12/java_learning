package itdel.spt.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Matius Smith
 */
public class CookieJar {
    public static final int DEFAULT_CAPACITY = 10;
    private Queue<Cookie> cookies = null;
    private int capacity = 0;
    
    public CookieJar(int capacity){
        if (capacity > 0 ){
            this.capacity = capacity;
        }
        else {
            this.capacity = DEFAULT_CAPACITY;
        }
        cookies = new LinkedList<Cookie>();
    }
    
    public boolean isEmpty(){
        return(cookies.size() == capacity);
    }
    
    public boolean isFull(){
        return(cookies.size()== capacity);
    }
    
    public synchronized void put(Cookie _cookie){
        while(isFull()){
            try{
                _cookie.getProducer().say("Penyimpanan Cookie penuh.");
                wait();
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
            _cookie.getProducer().say("notified");
        }
        
        _cookie.getProducer().say("adding(" + _cookie.getSeq()+ ")");
        cookies.offer(_cookie);
        notifyAll();
    }
    
    public synchronized  Cookie take(Consumer _consumer){
        while(isEmpty()){
            try{
                _consumer.say("Penampungan Cookie kosong");
                wait();
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
            _consumer.say("notified.");
        }
        Cookie cookie = cookies.poll();
        cookie.consumedBy(_consumer);
        _consumer.say("taking (" + cookie.getSeq()+ ")");
        notifyAll();
        return (cookie);
    }

}































