package controller;

import java.sql.SQLException;

public interface InputHandler {

	public abstract void setProcessor(int i, int j) throws SQLException;
	public void setHardDrive(int k) throws SQLException;
	public void setMemory(int l) throws SQLException;
	
}
