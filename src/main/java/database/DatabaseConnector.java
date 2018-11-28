package database;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
//	public static Connection getConnection() throws URISyntaxException, SQLException {
//	    URI dbUri = new URI(System.getenv("DATABASE_URL"));
//
//	    String username = dbUri.getUserInfo().split(":")[0];
//	    String password = dbUri.getUserInfo().split(":")[1];
//	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";
//
//	    return DriverManager.getConnection(dbUrl, username, password);
//	}
		public static Connection getConnection() throws URISyntaxException, SQLException {
		   

	    String username = "rpekxmxqsxmdwe";
	    String password = "faeebdfaeadb66b2a05f2068a23f432601ef62b7bce3703508f4c2883755bbba";
	    String dbUrl = "jdbc:postgresql://" + "ec2-54-243-187-30.compute-1.amazonaws.com" + ':' + "5432" + "/ddom7rq32t4sja" + "?sslmode=require";

	    return DriverManager.getConnection(dbUrl, username, password);
	}

	
}
