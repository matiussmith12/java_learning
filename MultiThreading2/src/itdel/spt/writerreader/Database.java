package itdel.spt.writerreader;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Matius Smith
 */
public class Database implements WriterReader {
    private int readerCount;
    private Semaphore mutex;
    private Semaphore db;
    
    public Database(){
        readerCount = 0;
        mutex = new Semaphore(1);
        db = new Semaphore(1);
    }
    
    public void acquireReadLock (int readerNum){
        try{
            mutex.acquire();
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }
        ++readerCount;
        
        if(readerCount == 1){
            try{
                db.acquire();
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
        System.out.println("Reader " + readerNum + " is reading. Reader count = "
                + ""+ readerCount);
        mutex.release();
        }
    
    public void releaseReadLock(int readerNum){
        try{
            mutex.acquire();
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }
        --readerCount;
        
        if (readerCount == 0 ){
            db.release();
        }
        System.out.println("Reader " +readerNum+ " is done reading. Reading count = "
        + readerCount);
        
        // mutex for reader
        mutex.release();
    }
    
    public void acquireWriteLock(int writerNum){
        try{
            db.acquire();
        }
        catch(InterruptedException ie){
            System.out.println("Writer " + writerNum+ " is writing");
        }
    }
    
    public void releaseWriteLock(int writerNum){
        System.out.println("Writer " + writerNum+ " is done writing.");
        db.release();
    }
}
