package auftragsmanagement;


import java.sql.*;
import java.io.PrintStream;

public class DBconnection {
    
    public static Connection con;
    public static Statement stmt;
    public static ResultSet resSet;
    public static String url ="jdbc:mysql://localhost:3306/test";
    public static String user="";
    public static String passwort="";
    public static String data;
    public static String insert = "INSERT INTO benutzer(vorname, nachname) VALUES('John', 'Smith');";
    public static String sqlQuery = "SELECT * FROM benutzer;";
    public static String showDB = "SHOW TABLES FROM test;";
    
    public DBconnection(){
        
    }
    
    //Konstruktor für eine Session mit Übergabe eines Statements
    public DBconnection(String statement){
        sqlQuery = statement;
    }
    
    public void connectDb() throws SQLException {
        try {
            con = DriverManager.getConnection(url); //erstellt eine Verbindung zur Datenbank(Session) über den Driver Manager
            stmt = (Statement) con.createStatement(); //erstellt ein Statement Objekt für das senden von Statements an die Datenbank
            //stmt.executeUpdate(insert);
            resSet = stmt.executeQuery(sqlQuery); //Übergibt eine Ergebnismenge eines Querys, welches ein SQL Statement ausführt
            //Erste REIHE
            resSet.first();
            //resSet.getString(1); Ausgabe eines String der ersten SPALTE der Aktiven REIHE!
            System.out.println(resSet.getString(1));
            System.out.println(resSet.getString(2));
            System.out.println(resSet.getString(3));
            //Nächste REIHE
            resSet.next();
            System.out.println(resSet.getString(1));
            System.out.println(resSet.getString(2));
            System.out.println(resSet.getString(3));

            /*resSet = stmt.executeQuery(showDB);
            resSet.first();
            while(resSet.next()){
            System.out.println(resSet.getInt("id"));
            System.out.println(resSet.getString("vorname"));
            System.out.println(resSet.getString("nachname"));
            */
            
        } catch(SQLException e){
            System.out.println("connectDB:");
            System.out.println(e);
        }
    }
    
     public ResultSet getUserData() throws SQLException {
         ResultSet resSet2 = null;
        try {
            
            con = DriverManager.getConnection(url); //erstellt eine Verbindung zur Datenbank(Session) über den Driver Manager
            stmt = (Statement) con.createStatement();
            resSet2 = stmt.executeQuery(sqlQuery);
            resSet2.first();
            
            
            } catch(SQLException e){
                System.out.println("ResultSet getUserData():");
                System.out.println(e);
        }
        return resSet2;
    }
    
}
