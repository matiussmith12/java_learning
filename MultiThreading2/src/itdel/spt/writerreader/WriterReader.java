package itdel.spt.writerreader;

/**
 *
 * @author Matius Smith
 */
interface WriterReader {
    public abstract void acquireReadLock(int readerNum);
    public abstract void acquireWriteLock(int writerNum);
    public abstract void releaseReadLock(int readerNum);
    public abstract void releaseWriteLock(int writerNum);
    
    
}
