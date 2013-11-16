package backend;

public class Processor extends Component {

	private String socket;

	public Processor(String desc, int score, String skt) {
		socket = skt;
		benchmarkScore = score;
		description = desc;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public String getSocket() {
		return socket;
	}

	public int getBenchmarkScore() {
		return benchmarkScore;
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
