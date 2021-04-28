package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import uts.isd.model.User;

/**
 *
 * @author george
 */
public class UserManager {
    private Statement st;
    
    public UserManager(Connection conn) throws SQLException{
            st = conn.createStatement();
    }
    
    //Create a user
    public void createUser(String name, String email, String pass, String phone,String gender, String dob) throws SQLException{
            String columns = "INSERT INTO ISDUSER.\"USER\"(\"NAME\",EMAIL,PASSWORD,PHONE,GENDER,DOB)";
            String values =  "VALUES('"+name+"','"+email+"','"+pass+"','"+phone+"','"+gender+"','"+dob+"')";
            st.executeUpdate(columns+values);
    }
    
    //Read a user by ID and email
    public User readUser(int ID, String password) throws SQLException{
        String fetch ="SELECT * FROM ISDUSER.\"USER\" WHERE ID="+ID+" AND PASSWORD='"+password+"'";//read from where ID = and password = 
        
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()){
            int userID = Integer.parseInt(rs.getString(1));
            String userPass = rs.getString(4);
            
            if(userID == ID && userPass.equals(password)){
                 String name = rs.getString(2);
                 String email = rs.getString(3);
                 String phone = rs.getString(5);
                 String gender = rs.getString(6);
                 String dob = rs.getString(7);
                 
                 return new User(ID,name,email,password,phone,gender,dob);
            }
        }
        return null;
    }
    
    //Update a user by ID & password
    public void updateUser(int ID, String name, String email, String pass, String phone,String gender, String dob) throws SQLException{
        String update = "UPDATE ISDUSER.\"USER\" SET \"NAME\"='"+name+"',EMAIL='"+email+"',PASSWORD='"+pass+"',PHONE='"+phone+"',GENDER='"+gender+"',DOB='"+dob+"' WHERE ID="+ID+" AND PASSWORD='"+pass+"'";                       
        st.executeUpdate(update);
    }
    
    //Delete a user by ID & password
    public void deleteUser(int ID, String password) throws SQLException{
        String delete = "DELETE FROM ISDUSER.\"USER\" WHERE ID="+ID+" AND PASSWORD='"+password+"'";
        st.executeUpdate(delete);
    }
}
