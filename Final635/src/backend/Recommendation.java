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
			Connection connection, Statement statement) throws SQLException {
		resultset = statement
				.executeQuery("SELECT description,benchmark_score,"
						+ "socket FROM processors where socket = '" + socket
						+ "'AND benchmark_score > " + score + "");

		while (resultset.next()) {
			String description = resultset.getString(1);
			int bscore = resultset.getInt(2);
			String skt = resultset.getString(3);
			Processor p = new Processor(description, bscore, skt);
			recommended.add(p);
		}
		System.out.println();
		System.out.println("Here are the processors you can use for upgrade:");
		System.out.println();
		for (int i = 0; i < recommended.size(); i++)
			System.out.println(recommended.get(i).getDescription());
		System.out.println();
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
		System.out.println();
		System.out.println("Here are the hard drives you can use for upgrade:");
		System.out.println();

		for (int i = 0; i < recommendedHardDrives.size(); i++)
			System.out.println(recommendedHardDrives.get(i).getDescription());
		System.out.println();
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
		System.out.println();
		System.out
				.println("Here are the memory modules you can use for upgrade:");
		System.out.println();

		for (int i = 0; i < recommendedMemory.size(); i++)
			System.out.println(recommendedMemory.get(i).getDescription());
		System.out.println();
	}

	public List<Memory> getRecommendedMemory() {
		return recommendedMemory;
	}
}
