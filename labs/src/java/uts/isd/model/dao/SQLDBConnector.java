package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author george
 */
public class SQLDBConnector extends SQLDB {
        public SQLDBConnector() throws ClassNotFoundException, SQLException{
                Class.forName(driver);
                super.conn = DriverManager.getConnection(URL+db, dbuser, dbpass);
        }
        
        public Connection connection(){
            return this.conn;
        }
        
        public void closeConnection() throws SQLException{
            this.conn.close();
        }
}
