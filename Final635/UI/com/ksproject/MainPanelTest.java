package com.ksproject;

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
		
		testMainPanel.processorSelect.addValue("processor");
		testMainPanel.processorSelect.addValue("processor2");
		testMainPanel.memorySelect.addValue("memory");
		testMainPanel.hardDriveSelect.addValue("hard drive");
		testMainPanel.chipSetSelect.addValue("chip set");
		
				
		testMainPanel.setSize(400, 400);
		
	}

}
