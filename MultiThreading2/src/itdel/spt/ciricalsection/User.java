package itdel.spt.ciricalsection;

/**
 *
 * @author Matius Smith
 */
public class User {
    private Printer printer = null;
    
    public User(Printer _printer){
        printer = _printer;
    }
    
    public void workOn(String document){
        (new Thread (new Runnable(){
            
            @Override
            public void run(){
                printer.print(document);
            }
        })).start();
    }
}
