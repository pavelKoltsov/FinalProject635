package backend;
import java.util.ArrayList;
import java.util.List;


public class Recommendation {

	private String recommendation;
	private ArrayList<Processor> recommended;
	private ArrayList<HardDrive> recommendedHardDrives;

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommended(ArrayList<Processor> upgrade) {
		recommended = upgrade;
	}

	public List<Processor> getRecommendedProcessor() {
		return recommended;
	}

	public void setRecommendedHardDrives(ArrayList<HardDrive> upgrade) {
		recommendedHardDrives = upgrade;

	}

	public ArrayList<HardDrive> getRecommendedHardDrives() {
		return recommendedHardDrives;
	}

}
