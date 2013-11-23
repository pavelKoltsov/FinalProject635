package backend;

public class Processor implements Component {

	private String socket;
	private ComponentImpl implement;
	
	public Processor(String desc, int score, String skt) {
		socket = skt;
		implement = new ComponentImpl(desc, score);
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
 
	public void setRating(int currentScore) {
		implement.setRating(currentScore);
	}
	

	public String getSocket() {
		return socket;
	}
}
