package database;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnector;
import model.*;
import database.DBUtil;

public class Databasequeries {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}

	private static final int MAX_ATTEMPTS = 10;

	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}
	
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();

		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;

			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}

			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}

			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}
	
	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:test.db;create=true");

		// Set autocommit to false to allow execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);

		return conn;
	}
	private void loadEvent(Event result, ResultSet resultSet, int index) throws SQLException {
		// TODO assign an event the proper values
		result.setName(resultSet.getString(index++));
		result.setDescription(resultSet.getString(index++));
		result.setStartDate(resultSet.getInt(index++));
		result.setEndDate(resultSet.getInt(index++));
		result.setTime(resultSet.getInt(index++));
		result.setBusiness(resultSet.getString(index++));
		result.setBusiness(resultSet.getString(index++));
		result.setLocation(resultSet.getString(index++));
	}
	private void LoadUser(User result, ResultSet resultSet, int index) throws SQLException {
		result.setUsername(resultSet.getString(index++));
		result.setPassword(resultSet.getString(index++));
		result.setEmail(resultSet.getString(index++));
		//result.setBusinesses(resultSet.getString(index++));
		result.setUserId(resultSet.getInt(index++));
	}
	
	private void LoadBusiness(Business result, ResultSet resultSet, int index) throws SQLException{
		result.setLocation(resultSet.getString(index++));
		result.setName(resultSet.getString(index++));
		result.setID(resultSet.getInt(index++));
	}
	
	public List<User> insertUser(final String username,final String password,final String email, final String businesses)
	{
		return executeTransaction(new Transaction<List<User>>()
		{
			public List<User> execute(Connection conn) throws SQLException
			{
				PreparedStatement stmt = null;
				ResultSet res = null;
				
				try
				{
					stmt = conn.prepareStatement(
							"insert into Users(username,password,email, businesses)"
							+ "values(?,?,?,?)");
					stmt.setString(1, username);
					stmt.setString(2, password);
					stmt.setString(3, email);
					stmt.setString(4, businesses);
					
					stmt.executeUpdate();
					return null;
				}
				finally
				{
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(res);
				}
			}
		});
	}
	
	public List<Business> insertBusiness(final String name,final String location)
	{
		return executeTransaction(new Transaction<List<Business>>()
		{
			public List<Business> execute(Connection conn) throws SQLException
			{
				PreparedStatement stmt = null;
				ResultSet res = null;
				
				try
				{
					stmt = conn.prepareStatement(
							"insert into Business(name, locaiton)"
							+ "values(?,?)");
					stmt.setString(1, name);
					stmt.setString(2, location);
					
					stmt.executeUpdate();
					return null;
				}
				finally
				{
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(res);
				}
			}
		});
	}
	
	public List<Event> insertEvent(final String name,final String description,final int start, final int end, final int time, final String business, final String location)
	{
		return executeTransaction(new Transaction<List<Event>>()
		{
			public List<Event> execute(Connection conn) throws SQLException
			{
				PreparedStatement stmt = null;
				ResultSet res = null;
				
				try
				{
					stmt = conn.prepareStatement(
							"insert into Event(name, description, start_date, end_date, time, business, location)"
							+ "values(?,?,?,?,?,?,?)");
					stmt.setString(1, name);
					stmt.setString(2, description);
					stmt.setInt(3, start);
					stmt.setInt(4, end);
					stmt.setInt(5, time);
					stmt.setString(6, business);
					stmt.setString(7, location);
					
					
					stmt.executeUpdate();
					return null;
				}
				finally
				{
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(res);
				}
			}
		});
	}
	public List<Event> findEventByStartDate(final int date){
		return executeTransaction(new Transaction<List<Event>>(){
			public List<Event> execute(Connection conn) throws SQLException{
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			List <Event> result = new ArrayList<Event>();
			
			try {

				stmt = conn.prepareStatement(
						"Select * FROM Event" +
						"Where Event.start_date = ?"
						);
				stmt.setInt(1, date);
				resultSet = stmt.executeQuery();
				int index = 0;
				while(resultSet.next()){
					Event event = new Event();
					loadEvent(event, resultSet, index);
					result.add(event);
				}
				return result;
			}
			finally{
				DBUtil.closeQuietly(conn);
	
			}
		}
	});
}

public List<Event> findEventByendDate(final int date){
	return executeTransaction(new Transaction<List<Event>>(){
		public List<Event> execute(Connection conn) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		List <Event> result = new ArrayList<Event>();
		
		try {

			stmt = conn.prepareStatement(
					"Select * FROM Event" +
					"Where Event.end_date = ?"
					);
			stmt.setInt(1, date);
			resultSet = stmt.executeQuery();
			int index = 0;
			while(resultSet.next()){
				Event event = new Event();
				loadEvent(event, resultSet, index);
				result.add(event);
			}
			return result;
		}
		finally{
			DBUtil.closeQuietly(conn);

		}
	}
});
}

public List<Event> findEventByName(final String name) throws URISyntaxException{
	return executeTransaction(new Transaction<List<Event>>(){
		public List<Event> execute(Connection conn) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		List <Event> result = new ArrayList<Event>();
		
		try {

			stmt = conn.prepareStatement(
					"Select * FROM events" +
					"Where events.name = ?"
					);
			stmt.setString(1, name);
			resultSet = stmt.executeQuery();
			int index = 0;
			while(resultSet.next()){
				Event event = new Event();
				loadEvent(event, resultSet, index);
				result.add(event);
			}
			return result;
		}
		finally{
			DBUtil.closeQuietly(conn);

		}
	}
});
}


public List<Event> findEventByID(final int id){
	return executeTransaction(new Transaction<List<Event>>(){
		public List<Event> execute(Connection conn) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		List <Event> result = new ArrayList<Event>();
		
		try {

			stmt = conn.prepareStatement(
					"Select * FROM Event" +
					"Where Event.ID = ?"
					);
			stmt.setInt(1, id);
			resultSet = stmt.executeQuery();
			int index = 0;
			while(resultSet.next()){
				Event event = new Event();
				loadEvent(event, resultSet, index);
				result.add(event);
			}
			return result;
		}
		finally{
			DBUtil.closeQuietly(conn);

		}
	}
});
}


public List<Event> editEvent(final String name,final String description,final int start, final int end, final int time, final String business, final String location)
{
	return executeTransaction(new Transaction<List<Event>>()
	{
		public List<Event> execute(Connection conn) throws SQLException
		{
			PreparedStatement stmt = null;
			ResultSet res = null;
			
			try
			{
				stmt = conn.prepareStatement(
						"insert into Event(name, description, start_date, end_date, time, business, location)"
						+ "values(?,?,?,?,?,?,?)");
				stmt.setString(1, name);
				stmt.setString(2, description);
				stmt.setInt(3, start);
				stmt.setInt(4, end);
				stmt.setInt(5, time);
				stmt.setString(6, business);
				stmt.setString(7, location);
				
				
				stmt.executeUpdate();
				return null;
			}
			finally
			{
				DBUtil.closeQuietly(stmt);
				DBUtil.closeQuietly(res);
			}
		}
	});
}
public List<User> findAccountByName(final String name){
	return executeTransaction(new Transaction<List<User>>(){
		public List<User> execute(Connection conn) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		List <User> result = new ArrayList<User>();
		
		try {

			stmt = conn.prepareStatement(
					"Select * FROM User" +
					"Where User.username = ?"
					);
			stmt.setString(1, name);
			resultSet = stmt.executeQuery();
			int index = 0;
			while(resultSet.next()){
				User user = new User();
				LoadUser(user, resultSet, index);
				result.add(user);
			}
			return result;
		}
		finally{
			DBUtil.closeQuietly(conn);

		}
	}
});
}

public List<Business> findBusinessByName(final String name) throws URISyntaxException{
	return executeTransaction(new Transaction<List<Business>>(){
		public List<Business> execute(Connection conn) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		List <Business> result = new ArrayList<Business>();
		
		try {

			stmt = conn.prepareStatement(
					"Select * FROM businesses" +
					"Where businesses.business_name = ?"
					);
			stmt.setString(1, name);
			resultSet = stmt.executeQuery();
			int index = 0;
			while(resultSet.next()){
				Business bn = new Business();
				LoadBusiness(bn, resultSet, index);
				result.add(bn);
			}
			return result;
		}
		finally{
			DBUtil.closeQuietly(conn);

		}
	}
});
}
public List<String> getBusinesssFromAccount(final String name) throws URISyntaxException{


	return executeTransaction(new Transaction<List<String>>(){
		public List<String> execute(Connection conn) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		List <String> result = new ArrayList<String>();
		
		try {

			stmt = conn.prepareStatement(
					"Select business FROM User" +
					"Where User.username = ?"
					);
			stmt.setString(1, name);
			resultSet = stmt.executeQuery();
			int index = 0;
			while(resultSet.next()){
				result.add(resultSet.getString(0));
			}
			return result;
		}
		finally{
			DBUtil.closeQuietly(conn);

		}
	}
});
}

public String hashword(final String password){
	return executeTransaction(new Transaction<String>(){
		public String execute(Connection conn) throws SQLException{
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			String result = null;
			
			try {
				stmt = conn.prepareStatement(
						"Select SHA2(?, 512)"
						);
				stmt.setString(1, password);
				resultSet = stmt.executeQuery();
				result = resultSet.getString(0);
				return result;
			}
			finally{
				DBUtil.closeQuietly(conn);

			}
		}
		
	});
}
}

//verifyAccount not sure where to go about this one

