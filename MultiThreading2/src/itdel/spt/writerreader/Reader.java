package itdel.spt.writerreader;

/**
 *
 * @author Matius Smith
 */
public class Reader implements Runnable {
    private WriterReader database;
    private int readerNum;
    
    public Reader(int readerNum, WriterReader database){
        this.readerNum = readerNum;
        this.database = database;
    }
    @Override
    public void run(){
        while(true){
            SleepUtilities.nap();
            System.out.println("reader " + readerNum+ " wants to read.");
            database.acquireReadLock(readerNum);
            
            SleepUtilities.nap();
            database.releaseReadLock(readerNum);
        }
    };
}
