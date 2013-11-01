import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static final String DATABASE_URL = "jdbc:mysql://localhost/compsystem";
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultset;
	private static CompSystem computer;

	public static void main(String[] args) throws SQLException {

		setProcessor();
		setHardDrive();

	}

	private static void setProcessor() throws SQLException {
		System.out.println("Enter processor id");

		Scanner input = new Scanner(System.in);
		int key = input.nextInt();
		String desc;
		int score;
		String skt;
		int maxScore = 0;

		connection = DriverManager
				.getConnection(DATABASE_URL, "Pavel", "12345");
		statement = connection.createStatement();
		resultset = statement
				.executeQuery("SELECT description,benchmark_score,"
						+ "socket FROM processors where id =" + key + "");

		if (resultset.next()) {
			desc = resultset.getString(1);
			score = resultset.getInt(2);
			skt = resultset.getString(3);

			resultset = statement
					.executeQuery("SELECT MAX(benchmark_score) FROM processors where socket = '"
							+ skt + "'");
			if (resultset.next())
				maxScore = resultset.getInt(1);

			System.out.println("Your processor is");
			System.out.println(desc);
			System.out.println();

			computer = new CompSystem();
			Processor p = new Processor(desc, score, skt);
			p.setMaxScore(maxScore);
			p.setRating();
			computer.setProcessor(p);
			System.out.printf(
					"Your processor has %.2f overall rating on 0 to 100 scale",
					p.getRating());
			System.out.println();

			getAvailableProcessors(score, skt);
		}

	}

	private static void getAvailableProcessors(int score, String socket)
			throws SQLException {

		ArrayList<Processor> upgrade = new ArrayList<Processor>();
		Statement statement = connection.createStatement();
		Recommendation r = new Recommendation();
		resultset = statement
				.executeQuery("SELECT description,benchmark_score,"
						+ "socket FROM processors where socket = '" + socket
						+ "'AND benchmark_score > " + score + "");

		while (resultset.next()) {
			String description = resultset.getString(1);
			int bscore = resultset.getInt(2);
			String skt = resultset.getString(3);

			Processor p = new Processor(description, bscore, skt);
			upgrade.add(p);
		}

		r.setRecommended(upgrade);
		System.out.println();
		System.out.println("Here are the processors you can use for upgrade:");
		System.out.println();
		for (int i = 0; i < r.getRecommended().size(); i++)
			System.out.println(r.getRecommended().get(i).getDescription());
		System.out.println();
	}

	private static void setHardDrive() throws SQLException {
		System.out.println("Enter hard drive id");

		Scanner input = new Scanner(System.in);
		int key = input.nextInt();
		String desc;
		float score = 0;
		int maxScore = 0;
		int size;

		connection = DriverManager
				.getConnection(DATABASE_URL, "Pavel", "12345");
		statement = connection.createStatement();
		resultset = statement
				.executeQuery("SELECT description,benchmark_rating,"
						+ "capacity FROM hard_drive where id =" + key + "");

		if (resultset.next()) {
			desc = resultset.getString(1);
			score = resultset.getFloat(2);
			size = resultset.getInt(3);

			resultset = statement
					.executeQuery("SELECT MAX(benchmark_rating) FROM hard_drive");
			if (resultset.next())
				maxScore = resultset.getInt(1);

			System.out.println("Your hard drive is");
			System.out.println(desc);
			System.out.println();

			HardDrive hd = new HardDrive(desc, score, size);
			hd.setMaxScore(maxScore * 10);
			hd.setRating();
			computer.setHardDrive(hd);

			System.out
					.printf("Your hard drive has %.2f overall rating on 0 to 100 scale",
							hd.getRating());
			System.out.println();
		}
		getAvailableHardDrives(score);
	}

	private static void getAvailableHardDrives(float score) throws SQLException {

		
		ArrayList<HardDrive> upgrade = new ArrayList<HardDrive>();
		Statement statement = connection.createStatement();
		Recommendation r = new Recommendation();
		
		resultset = statement
				.executeQuery("SELECT description,benchmark_rating,"
						+ "capacity FROM hard_drive where benchmark_rating >"
						+ score  + "");

		while (resultset.next()) {
			String description = resultset.getString(1);
			int bscore = resultset.getInt(2);
			int capacity = resultset.getInt(3);

			HardDrive hd = new HardDrive(description, bscore, capacity);
			upgrade.add(hd);
		}
		System.out.println(upgrade.get(upgrade.size()-1).getDescription());
		r.setRecommendedHardDrives(upgrade);
		
		System.out.println();

		System.out.println("Here are the hard drives you can use for upgrade:");
		System.out.println();

		for (int i = 0; i < r.getRecommendedHardDrives().size(); i++)
			System.out.println(r.getRecommendedHardDrives().get(i)
					.getDescription());
		System.out.println();
	}
}
