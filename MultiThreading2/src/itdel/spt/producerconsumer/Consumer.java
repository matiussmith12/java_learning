package itdel.spt.producerconsumer;

/**
 *
 * @author Matius Smith
 */
public class Consumer extends  Actor {
    public Consumer(String name, CookieJar jar, long delay){
        super(name,jar,delay);
    }
    
    @Override
    public void work(){
        Cookie cookie = jar.take(this);
        cookie.consumedBy(this);
    }
}
