package backend;

public interface Component {

	public abstract String getDescription();
	public abstract float getRating();
	public abstract void setMaxScore(int maxScore);
	public abstract void setMinScore(int minScore);
    public abstract void setRating(int rate);
    
}
