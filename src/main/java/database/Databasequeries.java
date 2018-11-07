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



	

	
	
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;
	
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) throws URISyntaxException {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException, URISyntaxException {
		Connection conn;
			conn = connect();
		
		
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
	

//	
//
//	private static final int MAX_ATTEMPTS = 10;
//
	private Connection connect() throws SQLException, URISyntaxException {
		Connection conn = DatabaseConnector.getConnection();
		
		// Set autocommit to false to allow execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	


	private void loadEvent(Event result, ResultSet resultSet, int index) throws SQLException {
		// TODO assign an event the proper values
		result.setId(resultSet.getInt(index++));
		result.setDescription(resultSet.getString(index++));
		result.setStartDate(resultSet.getInt(index++));
		result.setEndDate(resultSet.getInt(index++));
		result.setName(resultSet.getString(index++));
		result.setTime(resultSet.getInt(index++));
		result.setLocation(resultSet.getString(index++));
		result.setBusiness(resultSet.getString(index++));
	}
private void loadUser(User user, ResultSet resultSet, int index) throws SQLException {
		user.setUserId(resultSet.getInt(index++));
		user.setUsername(resultSet.getString(index++));
		user.setPassword(resultSet.getString(index++));
		user.setEmail(resultSet.getString(index++));
		
	}
	
	private void loadBusiness(Business result, ResultSet resultSet, int index) throws SQLException{
		result.setLocation(resultSet.getString(index++));
		result.setName(resultSet.getString(index++));
		result.setID(resultSet.getInt(index++));
	}
	
public List<User> insertUser(final String username,final String password,final String email,final int userid) throws URISyntaxException
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
						"insert into accounts(username,password,email,user_id)"
						+ "values(?,?,?,?)");
				stmt.setString(1, username);
				stmt.setString(2, password);
				stmt.setString(3, email);
				stmt.setInt(4, userid);
		
				
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
	public List<User> removeUser(final String username) throws URISyntaxException
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
							"delete from accounts "
							+ "where username = ?");
					stmt.setString(1, username);
					
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
	public List<Business> insertBusiness(final String name,final String location,final int id) throws URISyntaxException
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
							"insert into businesses(business_name, business_location, business_id)"
							+ "values(?,?,?)");
					stmt.setString(1, name);
					stmt.setString(2, location);
					stmt.setInt(3, id);
					
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
	public List<Business> removeBusiness(final String name) throws URISyntaxException
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
							"delete from businesses "+
							"where business_name = ?");
					stmt.setString(1, name);
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
	public List<Event> insertEvent(final String name,final String description,final int start, final int end, final int time, final String business, final String location,final int id) throws URISyntaxException
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
							"insert into events(name, event_description, start_date, end_date, time, business, location, event_id)"
							+ "values(?,?,?,?,?,?,?,?)");
					stmt.setString(1, name);
					stmt.setString(2, description);
					stmt.setInt(3, start);
					stmt.setInt(4, end);
					stmt.setInt(5, time);
					stmt.setString(6, business);
					stmt.setString(7, location);
					stmt.setInt(8, id);
					
					
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
	public List<Event> removeEvent(final String name,final String business) throws URISyntaxException
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
							"delete from events " +
							"where name = ? AND business = ?");
					stmt.setString(1, name);
					stmt.setString(2, business);
					
					
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
	
	public List<User> insertRelation(final String u_id, final String b_id) throws URISyntaxException
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
							"insert into relations(business_name, username) "
							+ "values(?,?)");
					stmt.setString(1, b_id);
					stmt.setString(2, u_id);
			
					
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
		public List<User> removeRelation(final String u_id,final String b_id) throws URISyntaxException
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
								"delete from relations "
								+ "where username = ? AND business_name = ?");
						stmt.setString(1, u_id);
						stmt.setString(2, b_id);
						
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
	
	
	
	public List<Event> findEventByStartDate(final int date) throws URISyntaxException{
		return executeTransaction(new Transaction<List<Event>>(){
			public List<Event> execute(Connection conn) throws SQLException{
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			List <Event> result = new ArrayList<Event>();
			
			try {

				stmt = conn.prepareStatement(
						"select Events.* " +
						"  from Events " +
						" where Events.start_date = ? "
						);
				stmt.setInt(1, date);
				resultSet = stmt.executeQuery();
				// for testing that a result was returned
				Boolean found = false;
				
				while (resultSet.next()) {
					found = true;
					
					// create new User object
					// retrieve attributes from resultSet starting with index 1
					Event event = new Event();
					loadEvent(event, resultSet, 1);
					
					result.add(event);
				}
				
				// check if the title was found
				if (!found) {
					System.out.println("<" + date + "> was not found in the event table");
				}
				
				return result;
			} finally {
				DBUtil.closeQuietly(resultSet);
				DBUtil.closeQuietly(stmt);
			}
		}
	});
}
//
public List<Event> findEventByEndDate(final int date) throws URISyntaxException{
	return executeTransaction(new Transaction<List<Event>>(){
		public List<Event> execute(Connection conn) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		List <Event> result = new ArrayList<Event>();
		
		try {

			stmt = conn.prepareStatement(
					"select Events.* " +
					"  from Events " +
					" where Events.end_date = ? "
					);
			stmt.setInt(1, date);
			resultSet = stmt.executeQuery();
			// for testing that a result was returned
			Boolean found = false;
			
			while (resultSet.next()) {
				found = true;
				
				// create new User object
				// retrieve attributes from resultSet starting with index 1
				Event event = new Event();
				loadEvent(event, resultSet, 1);
				
				result.add(event);
			}
			
			// check if the title was found
			if (!found) {
				System.out.println("<" + date + "> was not found in the event table");
			}
			
			return result;
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
		}
	}
});
}
//
public List<Event> findEventByName(final String name) throws URISyntaxException{
	return executeTransaction(new Transaction<List<Event>>() {
		//@Override
		public List<Event> execute(Connection conn) throws SQLException {
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			
			try {
				// retreive all attributes from both Books and Authors tables
				stmt = conn.prepareStatement(
						"select Events.* " +
						"  from Events " +
						" where Events.name = ? " 
				);
				stmt.setString(1, name);
				
				List <Event> result = new ArrayList<Event>();
				
				resultSet = stmt.executeQuery();
				
				// for testing that a result was returned
				Boolean found = false;
				
				while (resultSet.next()) {
					found = true;
					
					// create new User object
					// retrieve attributes from resultSet starting with index 1
					Event event = new Event();
					loadEvent(event, resultSet, 1);
					
					result.add(event);
				}
				
				// check if the title was found
				if (!found) {
					System.out.println("<" + name + "> was not found in the event table");
				}
				
				return result;
			} finally {
				DBUtil.closeQuietly(resultSet);
				DBUtil.closeQuietly(stmt);
			}
		}
	});
	}

//
//
public List<Event> findEventByID(final int id) throws URISyntaxException{
	return executeTransaction(new Transaction<List<Event>>() {
		//@Override
		public List<Event> execute(Connection conn) throws SQLException {
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			
			try {
				// retreive all attributes from both Books and Authors tables
				stmt = conn.prepareStatement(
						"select Events.* " +
						"  from Events " +
						" where Events.event_id = ? " 
				);
				stmt.setInt(1, id);
				
				List <Event> result = new ArrayList<Event>();
				
				resultSet = stmt.executeQuery();
				
				// for testing that a result was returned
				Boolean found = false;
				
				while (resultSet.next()) {
					found = true;
					
					// create new User object
					// retrieve attributes from resultSet starting with index 1
					Event event = new Event();
					loadEvent(event, resultSet, 1);
					
					result.add(event);
				}
				
				// check if the title was found
				if (!found) {
					System.out.println("<" + id + "> was not found in the event table");
				}
				
				return result;
			} finally {
				DBUtil.closeQuietly(resultSet);
				DBUtil.closeQuietly(stmt);
			}
		}
	});
	}
//
//
//public List<Event> editEvent(final String name,final String description,final int start, final int end, final int time, final String business, final String location,final int id) throws URISyntaxException
//{
//	return executeTransaction(new Transaction<List<Event>>()
//	{
//		public List<Event> execute(Connection conn) throws SQLException
//		{
//			PreparedStatement stmt = null;
//			ResultSet res = null;
//			
//			try
//			{
//				stmt = conn.prepareStatement(
//						"insert into events(name, event_description, start_date, end_date, time, business, location, event_id)"
//						+ "values(?,?,?,?,?,?,?,?)");
//				stmt.setString(1, name);
//				stmt.setString(2, description);
//				stmt.setInt(3, start);
//				stmt.setInt(4, end);
//				stmt.setInt(5, time);
//				stmt.setString(6, business);
//				stmt.setString(7, location);
//				stmt.setInt(8, id);
//				
//				
//				stmt.executeUpdate();
//				return null;
//			}
//			finally
//			{
//				DBUtil.closeQuietly(stmt);
//				DBUtil.closeQuietly(res);
//			}
//		}
//	});
//}
public List<User> findAccountByName(final String name) throws URISyntaxException{
	return executeTransaction(new Transaction<List<User>>() {
		//@Override
		public List<User> execute(Connection conn) throws SQLException {
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			
			try {
				// retreive all attributes from both Books and Authors tables
				stmt = conn.prepareStatement(
						"select Accounts.* " +
						"  from Accounts " +
						" where Accounts.username = ? " 
				);
				stmt.setString(1, name);
				
				List <User> result = new ArrayList<User>();
				
				resultSet = stmt.executeQuery();
				
				// for testing that a result was returned
				Boolean found = false;
				
				while (resultSet.next()) {
					found = true;
					
					// create new User object
					// retrieve attributes from resultSet starting with index 1
					User user = new User();
					loadUser(user, resultSet, 1);
					
					result.add(user);
				}
				
				// check if the title was found
				if (!found) {
					System.out.println("<" + name + "> was not found in the users table");
				}
				
				return result;
			} finally {
				DBUtil.closeQuietly(resultSet);
				DBUtil.closeQuietly(stmt);
			}
		}
	});
}

public List<User> findAccountById(final int id) throws URISyntaxException{
	return executeTransaction(new Transaction<List<User>>() {
		//@Override
		public List<User> execute(Connection conn) throws SQLException {
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			
			try {
				// retreive all attributes from both Books and Authors tables
				stmt = conn.prepareStatement(
						"select Accounts.* " +
						"  from Accounts " +
						" where Accounts.user_id = ? " 
				);
				stmt.setInt(1, id);
				
				List <User> result = new ArrayList<User>();
				
				resultSet = stmt.executeQuery();
				
				// for testing that a result was returned
				Boolean found = false;
				
				while (resultSet.next()) {
					found = true;
					
					// create new User object
					// retrieve attributes from resultSet starting with index 1
					User user = new User();
					loadUser(user, resultSet, 1);
					
					result.add(user);
				}
				
				// check if the title was found
				if (!found) {
					System.out.println("<" + id + "> was not found in the users table");
				}
				
				return result;
			} finally {
				DBUtil.closeQuietly(resultSet);
				DBUtil.closeQuietly(stmt);
			}
		}
	});
}






public List<Business> findBusinessByName(final String name) throws URISyntaxException{
	return executeTransaction(new Transaction<List<Business>>() {
		//@Override
		public List<Business> execute(Connection conn) throws SQLException {
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			
			try {
				// retreive all attributes from both Books and Authors tables
				stmt = conn.prepareStatement(
						"select businesses.* " +
						"  from businesses " +
						" where businesses.business_name = ? " 
				);
				stmt.setString(1, name);
				
				List <Business> result = new ArrayList<Business>();
				
				resultSet = stmt.executeQuery();
				
				// for testing that a result was returned
				Boolean found = false;
				
				while (resultSet.next()) {
					found = true;
					
					// create new User object
					// retrieve attributes from resultSet starting with index 1
					Business b = new Business();
					loadBusiness(b, resultSet, 1);
					
					result.add(b);
				}
				
				// check if the title was found
				if (!found) {
					System.out.println("<" + name + "> was not found in the business table");
				}
				
				return result;
			} finally {
				DBUtil.closeQuietly(resultSet);
				DBUtil.closeQuietly(stmt);
			}
		}
	});
}
public List<Business> findBusinessById(final int id) throws URISyntaxException{
	return executeTransaction(new Transaction<List<Business>>() {
		//@Override
		public List<Business> execute(Connection conn) throws SQLException {
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			
			try {
				// retreive all attributes from both Books and Authors tables
				stmt = conn.prepareStatement(
						"select businesses.* " +
						"  from businesses " +
						" where businesses.business_id = ? " 
				);
				stmt.setInt(1, id);
				
				List <Business> result = new ArrayList<Business>();
				
				resultSet = stmt.executeQuery();
				
				// for testing that a result was returned
				Boolean found = false;
				
				while (resultSet.next()) {
					found = true;
					
					// create new User object
					// retrieve attributes from resultSet starting with index 1
					Business b = new Business();
					loadBusiness(b, resultSet, 1);
					
					result.add(b);
				}
				
				// check if the title was found
				if (!found) {
					System.out.println("<" + id + "> was not found in the business table");
				}
				
				return result;
			} finally {
				DBUtil.closeQuietly(resultSet);
				DBUtil.closeQuietly(stmt);
			}
		}
	});
}
public List<Business> findBusinesssFromAccount(final String id) throws URISyntaxException{


	return executeTransaction(new Transaction<List<Business>>(){
		public List<Business> execute(Connection conn) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		List <Business> result = new ArrayList<Business>();
		
		try {

			stmt = conn.prepareStatement(
					"Select * FROM Businesses " +
					"INNER JOIN relations on relations.business_name=businesses.business_name "
					+ "where relations.username = ?"
					);
			stmt.setString(1, id);
			resultSet = stmt.executeQuery();
			// for testing that a result was returned
			Boolean found = false;
			
			while (resultSet.next()) {
				found = true;
				
				// create new User object
				// retrieve attributes from resultSet starting with index 1
				Business b = new Business();
				loadBusiness(b, resultSet, 1);
				
				result.add(b);
			}
			
			// check if the title was found
			if (!found) {
				System.out.println("<" + id + "> was not found in the business table");
			}
			
			return result;
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
		}
	}
});
}
//
public String hashword(final String password) throws URISyntaxException{
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
//

}
//
////verifyAccount not sure where to go about this one
//
