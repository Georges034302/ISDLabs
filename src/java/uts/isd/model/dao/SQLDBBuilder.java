/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import org.apache.ibatis.jdbc.ScriptRunner;
import java.util.logging.Logger;

/**
 *
 * @author george
 */
public class SQLDBBuilder {

    private Logger LOGGER = Logger.getLogger("InfoLogging");
    private static Scanner in = new Scanner(System.in);
    SQLDBConnecter connector;
    
    public SQLDBBuilder() throws ClassNotFoundException, SQLException {   
        connector = new SQLDBConnecter();
    }

    private File file(String filename) {      
         return new File("./web/db/", filename);
    }

    private String read(String prompt){
        System.out.print(prompt+": ");
        return in.nextLine();
    }
    
    private void executeSqlScript(File file, Connection conn) throws Exception {
        Reader reader = new BufferedReader(new FileReader(file));
        LOGGER.log(Level.INFO, "Running script from file: " + file.getCanonicalPath());
        ScriptRunner sr = new ScriptRunner(conn);
        sr.setAutoCommit(true);
        sr.setStopOnError(true);
        sr.runScript(reader);
        LOGGER.info("Done.");
    }

    private void buildUserTable() throws Exception{
        System.out.print("Run SQL script: ");
        String script = in.nextLine();
        File f = file(script);
        executeSqlScript(f, connector.connection());
    }
    
    private void run() throws ClassNotFoundException, SQLException, Exception{        
        char c = read("Choice (u/p/x)").charAt(0);
        while (c != 'x'){
            switch(c){
                case 'u': buildUserTable(); break;
                default: help(); break;
            }
            c = read("Choice (u/p/x)").charAt(0);
        }
         LOGGER.info("DB Build completed");
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
        new SQLDBBuilder().run();
    }
    
    private void help(){
        System.out.println("\n u - build user table \n"
                + "p - build product table \n"
                + "x - exit \n");
    }
}
