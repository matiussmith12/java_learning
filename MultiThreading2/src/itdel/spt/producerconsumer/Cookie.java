package itdel.spt.producerconsumer;



/**
 *
 * @author Matius Smith
 */
public class Cookie {
    private static int SEQ_COUNTER = 0;
    private final int seq;
    private final Producer producer;
    private Consumer consumer = null;
    
    public Cookie(Producer _producer){
        seq = nextSeq();
        producer = _producer;
    }
    
    public int getSeq(){
        return (seq);
    }
    
    public Producer getProducer(){
        return(producer);
    }
    
    public Consumer getConsumer(){
        return (consumer);
    }
    
    public void consumedBy(Consumer consumer){
        if(this.consumer == null){
            this.consumer = consumer;
        }
    }
    
    private static synchronized int nextSeq(){
        return (++SEQ_COUNTER);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("cookie:").append(seq).append("|producer: ").
                append(producer.getName());
        
        if(consumer != null){
            sb.append("|consumer: ").append(consumer.getName());
        }
        return (sb.toString());
    }   
}

