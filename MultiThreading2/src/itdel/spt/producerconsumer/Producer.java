package itdel.spt.producerconsumer;

/**
 *
 * @author Matius Smith
 */
public class Producer extends Actor{
    public Producer(String name, CookieJar jar, long delay){
        super(name,jar,delay);
    }
    
    @Override
    public void work(){
     Cookie cookie = new Cookie(this);
     jar.put(cookie);
    }
}
