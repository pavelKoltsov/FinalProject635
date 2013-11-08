package com.ksproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import com.sandsness.uiPanel.ComponentSelect;
import com.sandsness.uiPanel.ComponentsSelected;

import textio.TextIO;
import textio.TextIO.*;


public class MainPanel extends JFrame
{
	//variables
	private int windowXDimension;
	private int windowYDimension;
	
//	List<String> processorOptions	= new ArrayList<String>();
//	List<String> hardDriveOptions	= new ArrayList<String>();
//	List<String> memoryOptions 		= new ArrayList<String>();
//	List<String> chipSetOptions = new ArrayList<String>();
	List<Integer> valuesSelected = new ArrayList<Integer>();
	
	ComponentSelect processorSelect = new ComponentSelect("Processor");
	ComponentSelect hardDriveSelect = new ComponentSelect("Hard Drive");
	ComponentSelect memorySelect = new ComponentSelect("Memory");
	ComponentSelect chipSetSelect = new ComponentSelect("Chipset");
	
	ComponentsSelected chosenParts = new ComponentsSelected();
	
	JButton button1 = new JButton();
	
	/**
	 * @param args
	 */
	
	//constructor
	public MainPanel (String windowLabel)
	{
		
	
//		create the primary internal panel
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.CYAN);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setSize(400, 400);
		mainPanel.setVisible(true);

		
		//these items are for when this class extends JFrame
		this.setSize(500,500);
		

		mainPanel.add(processorSelect);
		mainPanel.add(hardDriveSelect);
		mainPanel.add(memorySelect);
		mainPanel.add(chipSetSelect);
				
		// add button to panel
		button1.setText("Generate Report");
		
		this.add(mainPanel);
		this.add(button1);
		this.setLayout(new BoxLayout(rootPane, BoxLayout.Y_AXIS));
		
		//prepare
		this.setTitle(windowLabel);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack(); // pack frame
		this.setLocationRelativeTo(null);// start frame in center of screen
		this.setVisible(true);
			
		button1.addActionListener(new ListenForButton());
		
	}//end constructor

	
	//**************************************************************************************************************************

	private class ListenForButton implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			
			//clear list of values.
			valuesSelected.clear();
			
			
			valuesSelected.add(processorSelect.getDropDownIndex());
			valuesSelected.add(hardDriveSelect.getDropDownIndex());
			valuesSelected.add(chipSetSelect.getDropDownIndex());
			valuesSelected.add(memorySelect.getDropDownIndex());
			
			for (int i = 0; i < valuesSelected.size(); i++)
			{
				TextIO.putln(valuesSelected.get(i));
			}
			
			
		}//end method action performed
		
	}//end private class ListenForButton
	

}//end class MainPanel
