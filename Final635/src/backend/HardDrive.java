package backend;

public class HardDrive implements Component {

	private int capacity;
	private ComponentImpl implement;

	public HardDrive(String desc, int score, int size) {

	    implement = new ComponentImpl(desc, score);
		capacity = size;
	}

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

	public int getCapacity() {
		return capacity;
	}

	@Override
	public void setMinScore(int mnScore) {
	  implement.setMinScore(mnScore);	
	}

	public void setRating(int currentScore) {
		implement.setRating(currentScore);
	}
}

