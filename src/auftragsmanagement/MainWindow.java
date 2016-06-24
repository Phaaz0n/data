package auftragsmanagement;

import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainWindow extends JFrame implements ActionListener {

  
    private JPanel p1, p2;
    private WindowListener wl1;
    private WindowEvent we1;
    private JFrame mainFrame; 
    private JButton b1;
    private JButton getData;
    private JButton nextData;
    private JButton previousData;
    private JTextField sqlStatement;
    private ResultSet rs1 = null;
    //private MyActionEvent event = new MyActionEvent();  //Instantiiert die Action Handler Klasse
    private JLabel showData;
   
    public MainWindow(){
        init();
    }
    
    public void init() {
        p1 = new JPanel();
        p1.setLayout(new BorderLayout()); // Panel hat standardmäßig kein Layout
        p2 = new JPanel();
        p2.setLayout(new BorderLayout()); // Panel hat standardmäßig kein Layout

        b1 = new JButton("test");
        b1.addActionListener(this);
        sqlStatement = new JTextField();
        getData = new JButton("execute Query");
        getData.addActionListener(this);
        showData = new JLabel("Fenster initialisiert");
        nextData = new JButton("show next");
        nextData.addActionListener(this);
        previousData = new JButton("show previous");
        previousData.addActionListener(this);
        mainFrame = new JFrame("Hauptfenster");
        mainFrame.addWindowListener(wl1);
        mainFrame.setBounds(100, 100, 700, 400);
        mainFrame.setVisible(true);
        mainFrame.add(p1);
        
        p1.add(b1, BorderLayout.NORTH);
        p1.add(sqlStatement, BorderLayout.CENTER);
        p1.add(p2, BorderLayout.SOUTH);
        p2.add(getData, BorderLayout.CENTER);
        p2.add(nextData, BorderLayout.EAST);
        p2.add(previousData, BorderLayout.WEST);
        p2.add(showData, BorderLayout.SOUTH);
        
    }
    //--------------------------------------------------------------------------
    private void exec() {
        try{
            this.getStatement();
            rs1.first();
            DisplayUsers du1 = new DisplayUsers(rs1.getFetchSize());
            //System.out.println(rs1.getString(1)+rs1.getString(2)+rs1.getString(3));
            //showData.setText(rs1.getString(1)+rs1.getString(2)+rs1.getString(3));
        }
        catch(SQLException se){
            System.out.println("void exec():");
            System.out.println(se);
        }
    }
    //--------------------------------------------------------------------------
    //SELECT * FROM benutzer;
    public void getStatement(){
        try{
        DBconnection db1 = new DBconnection(sqlStatement.getText());
        rs1 = db1.getUserData();
        }
        catch(SQLException se){
            se.printStackTrace();
        }
    }
    //--------------------------------------------------------------------------
    private void getNextData(){
        try{
        int i;
        if(rs1.next()==true){
            //rs1.next();
            for(i=1;i<4;i++){
            System.out.println(rs1.getString(i));
            }
        } else{
            System.out.println("NextData: Empty");
        }
        }
        catch(SQLException se){
            se.printStackTrace();
            System.out.println("getNextData");
        }
    }
    //--------------------------------------------------------------------------
    private void getPreviousData(){
        try{
        int i;
        if(rs1.previous()==true){
            //rs1.previous();
            for(i=1;i<4;i++){
            System.out.println(rs1.getString(i));
        }
            
        } else{
            System.out.println("PreviousData: Empty");
        }
        
        }
        catch(SQLException se){
            se.printStackTrace();
            System.out.println("getPreviousData");
        }
    }
    //--------------------------------------------------------------------------
    //overrides actionPerformed: must have, wenn "implements ActionListener"
    public void actionPerformed(ActionEvent eventThis){
        if(eventThis.getSource() == this.b1){
            
        }
        if(eventThis.getSource() == this.getData){
            this.exec();
            //this.getStatement();
        }
        if(eventThis.getSource() == this.nextData){
            this.getNextData();
        }
        if(eventThis.getSource() == this.previousData){
            getPreviousData();
        }
        if(eventThis.getSource() == this.mainFrame){
            System.exit(0);
        }
    }
    
    public String displayData(int i){
        String string="";
        try{
           string = rs1.getString(i);
        }
        catch(SQLException se){
            
        }
       return string;
    }
    public Integer getDataSize(){
        int size=0;
         try{
           size = rs1.getFetchSize();
        }
        catch(SQLException se){
            
        }
         return size;
    }
    
    /*
    Action Event mit Window Closing Funktion.
    Eigene Klasse für ActionEvent Handler.
    
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
    */
    
    
   /*public void windowClosing(WindowEvent e){
            if(e.getID() == 201){
                System.exit(0);
                    };
    } 
    */
    
    }
    

