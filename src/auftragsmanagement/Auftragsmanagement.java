package auftragsmanagement;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Auftragsmanagement {

    public static void main(String[] args) {
        DBconnection db = new DBconnection();
        try {
            db.connectDb();
        } catch (Exception ex) {
            Logger.getLogger(Auftragsmanagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MainWindow m1 = new MainWindow();

    }
    
}
