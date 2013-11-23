package backend;

public class HardDrive extends Component {

	private int capacity;

	public HardDrive(String desc, int score, int size) {

		description = desc;
		int bench = score;
		benchmarkScore = (int) bench;
		capacity = size;
	}

	@Override
	public String getDescription() {

		return description;
	}

	@Override
	public float getRating() {

		return rating;
	}

	@Override
	public void setMaxScore(int mxScore) {
		maxScore = mxScore;
	}

	public int getCapacity() {
		return capacity;
	}

	@Override
	public void setMinScore(int mnScore) {
	    minScore = mnScore;		
	}

}

