package itdel.spt.writerreader;

import java.util.concurrent.Semaphore;
/**
 *
 * @author Matius Smith
 */
public class MainReaderWriter {
    public static final int Readers = 3;
    public static final int Writers = 2;

    public static void main(String[] args) {
        // TODO code application logic here
        WriterReader database = new Database();
        
        Thread readerArray[] = new Thread[Readers];
        Thread writerArray[] = new Thread[Writers];
        
        for(int i = 0; i< Readers; i++){
            readerArray[i] = new Thread(new Reader(i,database));
            readerArray[i].start();
        }
        
        for(int i = 0; i< Writers; i++){
            writerArray[i] = new Thread(new Writer (i,database));
            writerArray[i].start();
        }
    }
    
}
