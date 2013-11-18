package UI;

import java.awt.Color;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ComponentSelect extends JPanel {
	private int dropDownIndex; // defines the index of the drop down
	private JComboBox<String> theDropDown = new JComboBox<String>();
	private JLabel label1 = new JLabel("");

	// Constructor
	public ComponentSelect(String label) {
		label1.setText(label);// create panel and add label
		this.setBackground(Color.CYAN);
		this.add(label1);
		this.add(theDropDown);// add dropdown list
	}// end constructor

	public void setValues(List<String> values) {
		// add values in dropdown
		for (int i = 0; i < values.size(); i++)
			theDropDown.addItem(values.get(i));
	}

	public int getDropDownIndex() {
		dropDownIndex = theDropDown.getSelectedIndex();
		return dropDownIndex;
	}

	public void setDropDownIndex(int dropDownIndex) {
		this.dropDownIndex = dropDownIndex;
	}
}
