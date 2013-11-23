package UI;

import java.util.ArrayList;

public class PureFabricated {

	private ArrayList<String> chipset = new ArrayList <String>();
	private ArrayList<Integer> indexes = new ArrayList<Integer>();	
	private int index;
	private int id;
	
	public void getIndexSelected(String s){
		
		for(int i = 0; i< chipset.size(); i++){
        if(s.equals(chipset.get(i)))
        	index = chipset.indexOf(s);
		}
		locateID();
	}

	private void locateID() {
		
		id = indexes.get(index);
	}
	
	public void setIndexes(ArrayList<Integer> indexes) {
		this.indexes = indexes;
	}
	public PureFabricated(ArrayList<String> chipsetDropdown1, ArrayList<Integer> indexes2) {
    chipset = chipsetDropdown1;
    indexes = indexes2;
	}

	public int getId() {
		return id;
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
