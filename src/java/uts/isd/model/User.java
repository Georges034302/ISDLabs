package uts.isd.model;

import java.io.Serializable;
import java.util.Random;
/**
 *
 * @author george
 */
public class User implements Serializable{
    //Fields or properties
    private String email;
    private String name;
    private String password;
    private String phone;
    private int ID;
    
    public User() {
    }

    public User(int ID, String email, String name, String password, String phone) {
        this.ID = ID;
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
}
