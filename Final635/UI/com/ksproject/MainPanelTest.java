package com.ksproject;

//import CompSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import textio.TextIO;

import com.ksproject.MainPanel;
import com.mysql.jdbc.ResultSetMetaData;


public class MainPanelTest
{
	static final String DATABASE_URL = "jdbc:mysql://localhost/compsystem";
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultset;
	private static ResultSetMetaData meta;
//	private static CompSystem computer;
	
	public static void main(String[] args)throws SQLException
	{
		// TODO Auto-generated method stub
		
		MainPanel testMainPanel = new MainPanel("test");
		
		
		//create array lists and populate with values		
		ArrayList<String> processorsDropdown = new ArrayList<String>();
		ArrayList<String> hdDropdown = new ArrayList<String>();
		
		connection = DriverManager
				.getConnection(DATABASE_URL, "Pavel", "12345");
		statement = connection.createStatement();
		
		resultset = statement
			.executeQuery("SELECT description FROM processors");
		
		String desc;
		
			while(resultset.next())
				
			{
		 desc = resultset.getString(1);
		 processorsDropdown.add(desc);			
			}
			
			resultset = statement
					.executeQuery("SELECT description FROM hard_drive");
			while(resultset.next())
			{
				desc = resultset.getString(1);
		 hdDropdown.add(desc);			
		}		
		//add single values to each dropdown. do this for just one value at a time.
//		testMainPanel.processorSelect.addValue("processor");
//		testMainPanel.processorSelect.addValue("processor2");
//		testMainPanel.memorySelect.addValue("memory");
//		testMainPanel.hardDriveSelect.addValue("hard drive");
//		testMainPanel.chipSetSelect.addValue("chip set");
		
		//configure drop down values with an ArrayList	
		testMainPanel.processorSelect.setValues(processorsDropdown);
		testMainPanel.memorySelect.setValues(hdDropdown);
		testMainPanel.hardDriveSelect.setValues(hdDropdown);
		testMainPanel.chipSetSelect.setValues(hdDropdown);
		
		testMainPanel.setSize(800, 600);
		

	}

}
