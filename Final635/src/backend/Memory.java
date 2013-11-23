package backend;

public class Memory implements Component {

	private int volume;
	private ComponentImpl implement;


	public Memory(String desc,int capacity, int speed) {
		
		implement = new ComponentImpl(desc, speed);
		volume = capacity;
		
	}

	@Override
	public String getDescription() {

		return implement.getDescription();
	}

	@Override
	public float getRating() {
		return implement.getRating();
	}

	@Override
	public void setMaxScore(int mxScore) {
		implement.setMaxScore(mxScore);
		
	}

	@Override
	public void setMinScore(int mnScore) {
		implement.setMinScore(mnScore);
		
	}
 
	public int getVolume() {
		return volume;
	}
	
	public void setRating(int currentScore) {
		implement.setRating(currentScore);
	}
}
