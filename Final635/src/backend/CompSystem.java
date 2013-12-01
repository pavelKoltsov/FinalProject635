package backend;

import java.util.ArrayList;
import java.util.List;

public final class CompSystem {

	
	private List<Component>parts = new ArrayList <Component>();
	private float rating;


	public float getRating() {
		return rating;
	}


	public void setRating() {
		float total = 0;
		for(int i = 0; i < parts.size();i++)
			total = total + parts.get(i).getRating();
	    rating = total / parts.size();
	    rating = (float) (Math.round(rating * 100.0)/100.0);
	}


	public List <Component> getParts() {
		return parts;
	}


	public void setMemory(Component mem) {
		parts.add(mem);
	}

	public void setProcessor(Component p2) {
		parts.add(p2);
	}

	public void setHardDrive(Component hd2) {
		parts.add(hd2);
	}

}
