package controller;

import java.sql.*;

import UI.Display;
import backend.CompSystem;
import backend.Component;
import backend.HardDrive;
import backend.Memory;
import backend.Processor;
import backend.Recommendation;

public class MySQLHandler implements InputHandler {

	static final String DATABASE_URL = "jdbc:mysql://localhost/compsystem";
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultset;
	private static CompSystem computer;
	private Recommendation r = new Recommendation();
	public void setProcessor(int indexProcessor, int indexChipset) throws SQLException {

		String desc;
		int score;
		String skt;
		int maxScore = 0;
		int minScore = 0;

		connection = DriverManager
				.getConnection(DATABASE_URL, "Pavel", "12345");
		statement = connection.createStatement();
		resultset = statement
				.executeQuery("SELECT description,benchmark_score,"
						+ "socket FROM processors where id =" + indexProcessor + "");

		if (resultset.next()) {
			desc = resultset.getString(1);
			score = resultset.getInt(2);
			skt = resultset.getString(3);

			resultset = statement
					.executeQuery("SELECT MAX(benchmark_score) FROM processors inner join  "
							+ " chipset_processor on chipset_processor.procid = processors.id "
							+ "inner join chipsets on chipset_processor.chipid = chipsets.id where processors.socket = '"
							+ skt + "'AND chipsets.id = "+ indexChipset +";");
			if (resultset.next())
				maxScore = resultset.getInt(1);
			resultset = statement
					.executeQuery("SELECT MIN(benchmark_score) FROM processors inner join  "
							+ " chipset_processor on chipset_processor.procid = processors.id "
							+ "inner join chipsets on chipset_processor.chipid = chipsets.id where processors.socket = '"
							+ skt + "'AND chipsets.id = "+ indexChipset +";");
			if (resultset.next())
				minScore = resultset.getInt(1);
			System.out.println("Your processor is");
			System.out.println(desc);
			System.out.println();

			computer = new CompSystem();
			Component p = new Processor(desc, score, skt);
			p.setMaxScore(maxScore);
			p.setMinScore(minScore);
			p.setRating(score);
			computer.setProcessor(p);
			System.out.printf(
					"Your processor has %.2f overall rating on 0 to 100 scale",
					p.getRating());
			System.out.println();
			r.setRecommendedProcessors(score, skt, indexChipset, connection, statement);
		}
	}
	
	public void setHardDrive(int index) throws SQLException {

		String desc;
		int score = 0;
		int maxScore = 0;
		int size;		
		resultset = statement
				.executeQuery("SELECT description,benchmark_rating,"
						+ "capacity FROM hard_drive where id =" + index + "");

		if (resultset.next()) {
			desc = resultset.getString(1);
			score = resultset.getInt(2);
			size = resultset.getInt(3);

			resultset = statement
					.executeQuery("SELECT MAX(benchmark_rating) FROM hard_drive");
			if (resultset.next())
				maxScore = resultset.getInt(1);

			System.out.println("Your hard drive is");
			System.out.println(desc);
			System.out.println();

			Component hd = new HardDrive(desc, score, size);
			hd.setMaxScore(maxScore);
			resultset = statement
					.executeQuery("SELECT MIN(benchmark_rating) FROM hard_drive");
			int minScore = 0;
			if (resultset.next())
				minScore = resultset.getInt(1);
			hd.setMinScore(minScore);
			hd.setRating(score);
			computer.setHardDrive(hd);

			System.out
					.printf("Your hard drive has %.2f overall rating on 0 to 100 scale",
							hd.getRating());
			System.out.println();
		}
		r.setRecommendedHardDrives(score, connection, statement);
	}

	public void setMemory(int index) throws SQLException {

		String desc;
		int speed = 0;
		int maxScore = 0;
		int capacity;

		resultset = statement.executeQuery("SELECT description,volume,"
				+ "speed FROM memory where id =" + index + "");

		if (resultset.next()) {
			desc = resultset.getString(1);
			capacity = resultset.getInt(2);
			speed = resultset.getInt(3);
			resultset = statement.executeQuery("SELECT MAX(speed) FROM memory");
			if (resultset.next())
				maxScore = resultset.getInt(1);

			System.out.println("Your memory is");
			System.out.println(desc);
			System.out.println();

			Component mem = new Memory(desc, capacity, speed);
			mem.setMaxScore(maxScore);
			resultset = statement.executeQuery("SELECT MIN(speed) FROM memory");
			int minScore = 0;
			if (resultset.next())
				minScore = resultset.getInt(1);
			mem.setMinScore(minScore);
			mem.setRating(speed);
			computer.setMemory(mem);

			System.out.printf(
					"Your memory has %.2f overall rating on 0 to 100 scale",
					mem.getRating());
			System.out.println();
		 }
		r.setRecommendedMemory(speed, connection, statement);
		computer.setRating();
		new Display(computer, r);
	   }
   
	}

