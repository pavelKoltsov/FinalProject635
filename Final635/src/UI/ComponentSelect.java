package UI;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ComponentSelect extends JPanel implements DBtype{
	private int dropDownIndex; // defines the index of the drop down
	JComboBox<String> theDropDown = new JComboBox<String>();
	private JLabel label1 = new JLabel("");
	PureFabricated pholder;
	ArrayList<Integer> indexes = new ArrayList<Integer>();
	ArrayList<String> chipsetDropdown1 = new ArrayList<String>();
	static final String DATABASE_URL = "jdbc:mysql://localhost/compsystem";
	private Connection connection;
	private Statement statement;
	private ResultSet resultset;
	String query;
    ItemListen il = new ItemListen();
	
    
	// Constructor
	public ComponentSelect(String label) {
		label1.setText(label);// create panel and add label
		this.setBackground(Color.lightGray);
		this.add(label1);
		this.add(theDropDown);// add dropdown list

	}// end constructor

	public void setValues(List<String> values) {

		for (int i = 0; i < values.size(); i++)
			theDropDown.addItem(values.get(i));
	}

	public class ItemListen implements ItemListener {
		
		private int indexChosen;

		@Override
		public void itemStateChanged(ItemEvent event) {
			ArrayList<String> chipsetDropdown = new ArrayList<String>();
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			indexes.clear();
			chipsetDropdown.clear();
			try {
				connection = DriverManager.getConnection(DATABASE_URL, "Pavel",
						"12345");

				statement = connection.createStatement();

				if (event.getStateChange() == ItemEvent.SELECTED) {

					indexChosen = theDropDown.getSelectedIndex() + 1;
					query = "SELECT chipsets.* FROM chipsets inner join "
							+ "chipset_processor on chipsets.id = chipset_processor.chipid "
							+ "inner join processors on chipset_processor.procid = processors.id "
							+ "where (processors.id = " + indexChosen + ")";
					resultset = statement.executeQuery(query);

					while (resultset.next()) {
						String desc = resultset.getString(1);
						int id = resultset.getInt(2);
						chipsetDropdown.add(desc);
						indexes.add(id);
					}
					getDescChosen(chipsetDropdown,indexes);
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void getDescChosen(ArrayList<String> chipsetDropdown, ArrayList<Integer> indexes1) {
        indexes.clear();
		chipsetDropdown1.clear();
		for (int i = 0; i < chipsetDropdown.size(); i++) {
            indexes.add(indexes1.get(i));
			String member = chipsetDropdown.get(i);
			chipsetDropdown1.add(member);
		}
		pholder = new PureFabricated(chipsetDropdown1, indexes);
		MainPanel.chipSetSelect.theDropDown.removeAllItems();
		MainPanel.chipSetSelect.setValues(pholder.getChipset());
	}
	
	public int getDropDownIndex() {
		dropDownIndex = theDropDown.getSelectedIndex();
		return dropDownIndex;
	}
	
	public void setDropDownIndex() {
		theDropDown.addItemListener(il);	
	
	}
	
	public ArrayList<String> getPlaceholderChipset() {
		return pholder.getChipset();

	}

	public void initialValues() throws SQLException {

		ArrayList<String> chipsetDropdown = new ArrayList<String>();
		ArrayList<Integer> initial = new ArrayList<Integer>();
		connection = DriverManager
				.getConnection(DATABASE_URL, "Pavel", "12345");

		statement = connection.createStatement();
		query = "SELECT chipsets.* FROM chipsets inner join "
				+ "chipset_processor on chipsets.id = chipset_processor.chipid "
				+ "inner join processors on chipset_processor.procid = processors.id "
				+ "where (processors.id = 1)";
		resultset = statement.executeQuery(query);
		while (resultset.next()) {
			String desc = resultset.getString(1);
			int i = resultset.getInt(2);
			chipsetDropdown.add(desc);
			initial.add(i);
			
		}
		pholder = new PureFabricated(chipsetDropdown,initial);
	}
	}
	
		
