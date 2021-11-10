package com.suisse.credit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.suisse.credit.models.EventRecord;

public class SaveRecords {

	private static final Log logger = LogFactory.getLog(SaveRecords.class);
	private static Connection connection;

	public SaveRecords() {

		logger.info("Process of saving the records has started.");
		
		try {

			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			String connectionString = "jdbc:hsqldb:hsql://localhost/testdb"; //jdbc:hsqldb:hsql://localhost/testdb , jdbc:hsqldb:file:hsqldb/testdb
			connection = DriverManager.getConnection(connectionString, "SA", "");
			
			if(connection != null) {
				logger.info("Connection established.");
			}else {
				logger.info("Connection not established.");
			}
			
		} catch (ClassNotFoundException e) {
			logger.error("Something went wrong while establishing connection to database");
			e.printStackTrace();
		} catch (SQLException se) {
			logger.error("Something went wrong while establishing connection to database");
			se.printStackTrace();
		}


	}
	
	public void saveRecords(Map<String, EventRecord> eventMap) {
		
		String createEventsTable;
		Set<String> keyset;
		String addEvent;
		PreparedStatement preparedStatement;

        try {
        	
			  createEventsTable = "CREATE TABLE IF NOT EXISTS Events (" 
			  + "id VARCHAR(50) NOT NULL,"
			  + "duration FLOAT NOT NULL, " 
			  + "type VARCHAR(50), " 
			  + "host VARCHAR(10), " 
			  + "alert BOOLEAN )";
			  
			  connection.createStatement().executeUpdate(createEventsTable);
			  
			 keyset = eventMap.keySet();
			 for(String str : keyset) {
				 
				 addEvent = "INSERT INTO Events (id, duration, type, host, alert)  VALUES (?, ?, ?, ?, ?)";
					logger.info("Inserting record for '"+str+"' "+addEvent);
					
					preparedStatement = connection.prepareStatement(addEvent);
			        preparedStatement.setString(1, eventMap.get(str).getId());
			        preparedStatement.setFloat(2, eventMap.get(str).getDuration());
			        preparedStatement.setString(3, eventMap.get(str).getType());
			        preparedStatement.setString(4, eventMap.get(str).getHost());
			        preparedStatement.setBoolean(5, eventMap.get(str).isAlert());

			        preparedStatement.executeUpdate();
			        
			 }
			  
			connection.close();
			logger.info("Connection is now closed.");
			logger.info("All records saved to database.");
	        
	        
		} catch (SQLException e) {
			logger.error("Something went wrong while saving records.");
			e.printStackTrace();
		}
        
	}
    

}
