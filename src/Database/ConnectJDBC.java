package Database;

import java.sql.*;

//public class ConnectJDBC {
//    
//    public Connection c;
//    public Statement s;
//    public ConnectJDBC(){
//        
//        try{
//        
//            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/credit_score","root","zxc@7410");
//            s = c.createStatement();
//        } catch(Exception e){
//            e.printStackTrace();
//        }    
//            
//    }   
//    
//}
    
    
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {

    public static Connection c;
    public static Statement s;
    public static Connection getConnection() {
//        Connection c = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/credit_score?useUnicode=true&characterEncoding=UTF-8", "root", "zxc@7410");
            s = c.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e);
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
        return c;
    }
}
    

