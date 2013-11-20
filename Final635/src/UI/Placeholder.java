package UI;

import java.util.ArrayList;

public class Placeholder {

	private ArrayList<String> chipset = new ArrayList <String>();
	
	public Placeholder(ArrayList<String> chipsetDropdown1) {
    chipset = chipsetDropdown1;
	}
	public ArrayList<String> getChipset() {
		return chipset;
	}
	public void setChipset(ArrayList<String> chipset) {
		this.chipset.clear();
		for(int i = 0; i < chipset.size(); i++)		
		this.chipset.add(chipset.get(i));
	}
}
