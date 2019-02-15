package itdel.spt.writerreader;

/**
 *
 * @author Matius Smith
 */
public class Writer implements Runnable {
    private WriterReader database;
    private int writerNum;
    
    public Writer(int w, WriterReader d){
        writerNum = w;
        database = d;
    }
    
    public void run(){
        while(true){
            SleepUtilities.nap();
            
            System.out.println("writer " + writerNum + " wants to write");
            database.acquireWriteLock(writerNum);
            
            SleepUtilities.nap();
            
            database.releaseWriteLock(writerNum);
        }
    }
}
