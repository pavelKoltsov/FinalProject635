package com.ksproject;

import java.util.ArrayList;

import textio.TextIO;

import com.ksproject.MainPanel;


public class MainPanelTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		MainPanel testMainPanel = new MainPanel("test");
		
		
		//create array list and populate with values		
		ArrayList<String> exampleArrayList = new ArrayList<String>();
		
		
		for (int i = 1; i <= 10; i++)
		{
			exampleArrayList.add("trial" + i);
			
		}
		
		//add single values to each dropdown. do this for just one value at a time.
		testMainPanel.processorSelect.addValue("processor");
		testMainPanel.processorSelect.addValue("processor2");
		testMainPanel.memorySelect.addValue("memory");
		testMainPanel.hardDriveSelect.addValue("hard drive");
		testMainPanel.chipSetSelect.addValue("chip set");
		
		//configure drop down values with an ArrayList	
		testMainPanel.processorSelect.setValues(exampleArrayList);
		testMainPanel.memorySelect.setValues(exampleArrayList);
		testMainPanel.hardDriveSelect.setValues(exampleArrayList);
		testMainPanel.chipSetSelect.setValues(exampleArrayList);
		
		testMainPanel.setSize(400, 400);
		

	}

}
