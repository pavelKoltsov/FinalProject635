package backend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Recommendation {

	private static ResultSet resultset;
	private String recommendation;
	private List<Processor> recommended = new ArrayList<Processor>();
	private List<HardDrive> recommendedHardDrives = new ArrayList<HardDrive>();
	private List<Memory> recommendedMemory = new ArrayList<Memory>();
	
	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendedProcessors(int score, String socket,
			int indexChipset, Connection connection, Statement statement) throws SQLException {
		resultset = statement
				.executeQuery("SELECT processors.description, benchmark_score, socket" +
						" FROM processors inner join  "
							+ " chipset_processor on chipset_processor.procid = processors.id "
							+ "inner join chipsets on chipset_processor.chipid = chipsets.id where (processors.socket = '" + socket
						+ "' AND chipsets.id = " + indexChipset + " AND processors.benchmark_score > " + score + ");");

		while (resultset.next()) {
			String description = resultset.getString(1);
			int bscore = resultset.getInt(2);
			String skt = resultset.getString(3);
			Processor p = new Processor(description, bscore, skt);
			recommended.add(p);
		}
	}

	public List<Processor> getRecommendedProcessor() {
		return recommended;
	}

	public void setRecommendedHardDrives(float score, Connection connection,
			Statement statement) throws SQLException {
		resultset = statement
				.executeQuery("SELECT description,benchmark_rating,"
						+ "capacity FROM hard_drive where benchmark_rating >"
						+ score + "");

		while (resultset.next()) {
			String description = resultset.getString(1);
			int bscore = resultset.getInt(2);
			int capacity = resultset.getInt(3);
			HardDrive hd = new HardDrive(description, bscore, capacity);
			recommendedHardDrives.add(hd);
		}
	}

	public List<HardDrive> getRecommendedHardDrives() {
		return recommendedHardDrives;
	}

	public void setRecommendedMemory(int speed, Connection connection,
			Statement statement) throws SQLException {
		resultset = statement.executeQuery("SELECT description,volume,"
				+ "speed FROM memory where speed >" + speed + "");

		while (resultset.next()) {
			String description = resultset.getString(1);
			int volume = resultset.getInt(2);
			speed = resultset.getInt(3);
			Memory mem = new Memory(description, volume, speed);
			recommendedMemory.add(mem);
		}
	
	}
	
	public List<Memory> getRecommendedMemory() {
		return recommendedMemory;
	}
}
