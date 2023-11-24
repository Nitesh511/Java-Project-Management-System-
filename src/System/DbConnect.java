package System;

import java.sql.*;
import javax.swing.*;
class DbConnect {
//    Connection con=null;
    public static Connection Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?","root","*#123Nitesh*#");
            // JOptionPane.showMessageDialog(null, "Connected to database");
            return con;
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
