package com.sandsness.uiPanel;

import java.awt.Color;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ComponentSelect extends JPanel
{
	private String selectLabel; //label for dropdown
	private List<String> values; // values to populate dropdown.
	private int dropDownIndex; //defines the index of the drop down
	private JComboBox theDropDown = new JComboBox();
	private JLabel label1 = new JLabel("");
	
	
	//Constructor with label only
			public ComponentSelect(String label)
			{
				
				// create panel and add label
				this.setBackground(Color.CYAN);
				this.add(label1);

				this.add(theDropDown);//add dropdown list
								
			}//end constructor with parameters
	
	
	//Constructor with parameters
		public ComponentSelect(String label, List populate)
		{
			
			// create panel and add label
			this.setBackground(Color.CYAN);
			this.add(label1);

			for(int j = 0; j < populate.size(); j++)
			{
				theDropDown.addItem(populate.get(j));
			}
			
			this.add(theDropDown);//add dropdown list
			
			
		}//end constructor with parameters

//********GETTERS and SETTERS *****************
//*******************************************************
		public String getLabel() 
		{
			return selectLabel;
		}

		public void setLabel(String label) 
		{
			this.selectLabel = label;
		}

		public List<String> getValues() 
		{
			return values;
		}

		public void setValues(List<String> values) 
		{
			this.values = values;
		}
	
		public void addValue(String addString)
		{
			theDropDown.addItem(addString);
			
		}

		/**
		 * @return the dropDownIndex
		 */
		public int getDropDownIndex()
		{
			dropDownIndex = theDropDown.getSelectedIndex();
			return dropDownIndex;
		}

		/**
		 * @param dropDownIndex the dropDownIndex to set
		 */
		public void setDropDownIndex(int dropDownIndex)
		{
			this.dropDownIndex = dropDownIndex;
			theDropDown.setSelectedIndex(dropDownIndex);
		}
		
		

//************************end methods******************		
		
		
}
