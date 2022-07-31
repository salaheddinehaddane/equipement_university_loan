/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author mimi
 */
public class JConnection {
    
    public static void main(String[] args) throws SQLException {
        
        // load the driver manager
        String className = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(className);
            System.out.println("Driver loaded Successfully");
            
        }catch (ClassNotFoundException e){
            System.out.println("Driver Failed To load Successfully");
            System.out.println(e.getMessage());
        }
        // get a connection to the database
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prêt_uca", "root", "");
            // create a satement
            Statement st = conn.createStatement();
            // Execute SQL query (select query)
            ResultSet res = st.executeQuery("select * from user");
            // Process the result set
            while (res.next()){
                System.out.println(res.getString("id_user")+" , "+res.getString("nom")+" , "+res.getString("prenom"));
            }
            
            /* // create a satement
            Statement st2 = conn.createStatement();
            // Execute SQL query (insert query)
            String sql = "insert into user(id_user, nom, prenom)"
                    + "values(2, 'salah din', 'Haddane')";
            st2.executeUpdate(sql);
            System.out.println("insert compeled");
            */
            
        }catch(Exception e){
            System.out.println("database Failed To connect Successfully");
            System.out.println(e.getMessage());
        }
        
    
    }
    
}
