package UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import UI.MainPanel;

public class MainPanelTest {
	static final String DATABASE_URL = "jdbc:mysql://localhost/compsystem";
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultset;

	public void showPanel() throws SQLException {

		MainPanel testMainPanel = new MainPanel("test");

		// create array lists and populate with values
		List<String> processorsDropdown = new ArrayList<String>();
		List<String> hdDropdown = new ArrayList<String>();
		List<String> memoryDropdown = new ArrayList<String>();
		connection = DriverManager
				.getConnection(DATABASE_URL, "Pavel", "12345");
		statement = connection.createStatement();

		resultset = statement
				.executeQuery("SELECT description FROM processors");

		String desc;

		while (resultset.next())

		{
			desc = resultset.getString(1);
			processorsDropdown.add(desc);
		}

		resultset = statement
				.executeQuery("SELECT description FROM hard_drive");
		while (resultset.next()) {
			desc = resultset.getString(1);
			hdDropdown.add(desc);
		}

		resultset = statement.executeQuery("SELECT description FROM memory");
		while (resultset.next()) {
			desc = resultset.getString(1);
			memoryDropdown.add(desc);
		}
		// configure drop down values with an ArrayList
		testMainPanel.processorSelect.setValues(processorsDropdown);
		testMainPanel.memorySelect.setValues(memoryDropdown);
		testMainPanel.hardDriveSelect.setValues(hdDropdown);
		testMainPanel.chipSetSelect.setValues(hdDropdown);
		testMainPanel.setSize(800, 250);
	}

}
