package com.sandsness.uiPanel;

public class ComponentsSelected
{
	//attributes
	int processorSelectIndex = -1; 
	int hardDriveSelectIndex = -1; 
	int memorySelectIndex = -1; 
	int chipSetSelectIndex = -1;
	
	//set values constructor
	public ComponentsSelected(int processorSelectIndex,
			int hardDriveSelectIndex, int memorySelectIndex,
			int chipSetSelectIndex) 
	{
		super();
		this.processorSelectIndex = processorSelectIndex;
		this.hardDriveSelectIndex = hardDriveSelectIndex;
		this.memorySelectIndex = memorySelectIndex;
		this.chipSetSelectIndex = chipSetSelectIndex;
	}//end set values constructor
	
	
	//default empty constructor
	public ComponentsSelected()
	{
	
	}//end default empty constructor
	
}//end class ComponentsSelected
