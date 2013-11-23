package backend;

public abstract class Component {

	int benchmarkScore;
	String description;
	static int maxScore;
	static int minScore;
	float rating;

	public abstract String getDescription();

	public abstract float getRating();

	public abstract void setMaxScore(int maxScore);
	public abstract void setMinScore(int minScore);

	public void setRating(int currentScore) {
		int range = maxScore - minScore;
		int scale = currentScore - minScore;
		rating = ((float)scale/ range) * 100;
	}

}
