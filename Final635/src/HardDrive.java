public class HardDrive extends Component {

	private int capacity;

	public HardDrive(String desc, float score, int size) {

		description = desc;
		float bench = score * 10;
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

}

