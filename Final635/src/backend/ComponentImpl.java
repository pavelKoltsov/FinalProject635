package backend;

public class ComponentImpl implements Component{
	int benchmarkScore;
	String description;
	static int maxScore;
	static int minScore;
	float rating;
	
	public ComponentImpl(String desc, int score){
		description = desc;
		benchmarkScore = score;
	}

	public String getDescription() {
		return description;
	}

	public float getRating() {
		return rating;
	}

	public void setMaxScore(int mxScore) {
		maxScore = mxScore;
	}
	public void setMinScore(int mnScore) {
		minScore = mnScore;
	}

	public void setRating(int currentScore) {
		int range = maxScore - minScore;
		int scale = currentScore - minScore;
		System.out.println(currentScore);
		System.out.println(minScore);
		System.out.println(scale);
		rating = ((float)scale / range) * 100;
		
	}
}
