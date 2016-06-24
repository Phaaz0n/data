package auftragsmanagement;

import java.util.*;
import java.awt.event.*;

public class MyActionListener {
     
   /* Action Event mit Window Closing Funktion.
    Eigene Klasse für ActionEvent Handler.
    */
    public class MyActionEvent implements ActionListener {
        public void actionPerformed(ActionEvent event){
        int id = event.getID();
        System.out.println(id);
        System.out.println(event.getSource().toString());
        if(event.getSource() =="0"){
            System.exit(0);
        }

        
    }
    }
    
}
