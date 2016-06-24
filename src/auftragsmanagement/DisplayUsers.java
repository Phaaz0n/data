package auftragsmanagement;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class DisplayUsers extends JFrame{
    
    MyActionListener closeWindow = new MyActionListener();
    int numIndex=0;
    JFrame fUser = new JFrame();
    JPanel p1 = new JPanel();
    JLabel ID[];
    GridLayout gl = new GridLayout();
    int fx=100, fy=100, fx2=400, fy2=700;
    
    
    public DisplayUsers(){
    }
    
        public DisplayUsers(int numIndex){
            this.numIndex = numIndex;
            
            
    }
    
    private void init(){
        fUser.setBounds(fx, fy, fx2, fy2);
        fUser.setVisible(true);
        p1.setLayout(gl);
        fUser.add(p1);
        for(int i=0;i<numIndex;i++){
            p1.add(ID[numIndex]);
        }
        
    }

}
