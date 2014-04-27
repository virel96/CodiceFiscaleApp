
package controller;
import view.*;

/**
 * Permette di eseguire l'app sia in modalità TUI che in modalità GUI
 * @author Sandro
 */
public class StartApp {
    
    String[] args;
    
    public StartApp(String[] args) {
        this.args = args;
        if (args.length>0) {
            for (int i=0; i<args.length; i++) System.out.println(args[i]);
            TuiInterface console = new TuiInterface();
            console.esempio();
        } else {
            GuiInterface.main(args);
        }
    }
    
}
