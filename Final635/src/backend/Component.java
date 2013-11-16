package backend;
public abstract class Component {

	int benchmarkScore;
	String description;
	static int maxScore;
	int tier;
	float rating;

	public abstract String getDescription();

	public abstract float getRating();

	public abstract void setMaxScore(int maxScore);

	public void setRating() {
		rating = (float) benchmarkScore / maxScore * 100;
	}

}
