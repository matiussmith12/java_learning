package itdel.spt.producerconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matius Smith
 */
public class CookieShop {
    private final List<Actor>actors;
    private final List<Thread>threads;
    private final CookieJar jar;
    
    public CookieShop(int numberOfProducer, int numberOfConsumer,
            int jarCapacity){
        int numberOfActor = numberOfProducer + numberOfConsumer;
        actors = new ArrayList<>();
        threads = new ArrayList<>();
        jar = new CookieJar(jarCapacity);
        
        for(int i = 0; i < numberOfProducer; ++i){
            Actor actor = new Producer(("P" + i),jar,(100*(i +1)));
            actor.setCycle(jarCapacity);
            actors.add(actor);
            threads.add(new Thread(actor));
        }
        
        for(int i = 0; i < numberOfConsumer; ++i){
            Actor actor = new Consumer(("C" + i), jar, (100 * (i + 2)));
            actor.setCycle((jarCapacity * numberOfProducer)/numberOfConsumer);
            actors.add(actor);
            threads.add(new Thread(actor));
        }
    }
    
    public void startInteracting(){
         for(int i = 0; i < threads.size(); ++i){
             threads.get(i).start();
         }
         try{
             for(int i = 0; i < threads.size();++i){
                 threads.get(i).join();
             }
         }
         catch(InterruptedException ie){
             ie.printStackTrace();
         }
    }
}
