package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.User;

/**
 *
 * @author george
 */
public class SQLUserDAO {

    private Statement st;

    public SQLUserDAO(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    //Create a user
    public void createUser(String name, String email, String pass, String phone, String gender, String dob) throws SQLException {
        String columns = "INSERT INTO ISDUSER.\"USER\"(\"NAME\",EMAIL,PASSWORD,PHONE,GENDER,DOB)";
        String values = "VALUES('" + name + "','" + email + "','" + pass + "','" + phone + "','" + gender + "','" + dob + "')";
        st.executeUpdate(columns + values);
    }

    //Read a user by ID and email
    public User readUser(int ID, String password) throws SQLException {
        String fetch = "SELECT * FROM ISDUSER.\"USER\" WHERE ID=" + ID + " AND PASSWORD='" + password + "'";//read from where ID = and password = 

        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int userID = Integer.parseInt(rs.getString(1));
            String userPass = rs.getString(4);

            if (userID == ID && userPass.equals(password)) {
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(5);
                String gender = rs.getString(6);
                String dob = rs.getString(7);

                return new User(ID, name, email, password, phone, gender, dob);
            }
        }
        return null;
    }

    public boolean verifyUser(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM ISDUSER.\"USER\" WHERE EMAIL=" + email + " AND PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String userEmail = rs.getString(3);
            String userPass = rs.getString(4);

            if (userEmail.equals(email) && userPass.equals(password))
                return true;            
        }
        return false;
    }
    
    //Update a user by ID & password
    public void updateUser(int ID, String name, String email, String pass, String phone, String gender, String dob) throws SQLException {
        String update = "UPDATE ISDUSER.\"USER\" SET \"NAME\"='" + name + "',EMAIL='" + email + "',PASSWORD='" + pass + "',PHONE='" + phone + "',GENDER='" + gender + "',DOB='" + dob + "' WHERE ID=" + ID + " AND PASSWORD='" + pass + "'";
        st.executeUpdate(update);
    }

    //Delete a user by ID & password
    public void deleteUser(int ID, String password) throws SQLException {
        String delete = "DELETE FROM ISDUSER.\"USER\" WHERE ID=" + ID + " AND PASSWORD='" + password + "'";
        st.executeUpdate(delete);
    }

    //Fetch all Users from the database [i.e used when displaying a table on the view]
    public ArrayList<User> fecthUsers() throws SQLException {
        String fetch = "select * from ISDUSER.\"USER\"";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> temp = new ArrayList();

        while (rs.next()) {
            int ID = Integer.parseInt(rs.getString(1));
            String name = rs.getString(2);
            String email = rs.getString(3);
            String pass = rs.getString(4);
            String phone = rs.getString(5);
            String gender = rs.getString(6);
            String dob = rs.getString(7);;
            temp.add(new User(ID,email,name,pass,phone,gender,dob));
        }
        return temp;
    }
}
