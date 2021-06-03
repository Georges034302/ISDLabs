package uts.isd.model.dao.sql;

import java.sql.Connection;

/**
 *
 * @author george
 */
public abstract class SQLDB {
        protected String URL = "jdbc:derby://localhost:1527/";
        protected String db = "demodb";
        protected String dbuser = "isduser";
        protected String dbpass = "admin";
        protected String driver = "org.apache.derby.jdbc.ClientDriver";
        protected Connection conn;
}
