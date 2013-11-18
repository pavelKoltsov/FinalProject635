package backend;

public class Memory extends Component {

	private int volume;

	public int getVolume() {
		return volume;
	}

	public Memory(String desc, int capacity, int speed) {
		description = desc;
		volume = capacity;
		benchmarkScore = speed;
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

}
