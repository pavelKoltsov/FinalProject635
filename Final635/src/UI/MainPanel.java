package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.InputHandler;
import controller.MySQLHandler;

@SuppressWarnings("serial")
public class MainPanel extends JFrame {

	static ComponentSelect processorSelect = new ComponentSelect("Processor");
	ComponentSelect hardDriveSelect = new ComponentSelect("Hard Drive");
	ComponentSelect memorySelect = new ComponentSelect("Memory");
	static ComponentSelect chipSetSelect = new ComponentSelect("Chipset");
	JButton button1 = new JButton();
	JPanel mainPanel, main;
	private MainPanel tmp ;
	// constructor
	public MainPanel(String windowLabel) {

		this.setTitle(windowLabel);
		
		configureMainPanel();
		button1.addActionListener(new ListenForButton());// add listener for
		//
	}// end constructor
	

	class ListenForButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			InputHandler input = new MySQLHandler();
			
			String s = (String) chipSetSelect.theDropDown.getSelectedItem();
		
			processorSelect.pholder.getIndexSelected(s);
			try {
				input.setProcessor(processorSelect.getDropDownIndex() + 1, processorSelect.pholder.getId());
				input.setHardDrive(hardDriveSelect.getDropDownIndex() + 1);
				input.setMemory(memorySelect.getDropDownIndex() + 1);

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			configureOutput();
			}// end method action performed

	}// end private class ListenForButton

	private void configureMainPanel() {
		// create the primary internal panel

		mainPanel = new JPanel();
		mainPanel.setBackground(Color.CYAN);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		mainPanel.setVisible(true);
		// adds drop downs to main panel
		mainPanel.add(processorSelect);
		mainPanel.add(hardDriveSelect);
		mainPanel.add(memorySelect);
		mainPanel.add(chipSetSelect);
		// add button to panel
		button1.setText("Generate Report");
		
		this.add(mainPanel);
		this.add(button1);
	//	this.setLayout(new BoxLayout(rootPane, BoxLayout.Y_AXIS));
		// prepare
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack(); // pack frame
		this.setLocationRelativeTo(null);// start frame in center of screen
		this.setVisible(true);
	}// end private method configureMainPanel

	public void configureOutput() {
		
		JTextArea textArea = new JTextArea(28,60);
	
		this.remove(mainPanel);
		this.remove(button1);
		main = new JPanel();
		
		textArea.insert("This is your current system configuration:\n", 0);
		textArea.append("Your processor is:\n");
		textArea.append(Display.selectedSystem.getParts().get(0).getDescription()+"\n");
	    textArea.append("It has rating of " + Display.selectedSystem.getParts().get(0).getRating()+" on scale of 0 to 100 ");
	    textArea.append("Your processor is:\n");
		textArea.append(Display.selectedSystem.getParts().get(0).getDescription()+"\n");
	    textArea.append("It has rating of " + Display.selectedSystem.getParts().get(0).getRating()+" on scale of 0 to 100 ");
		textArea.setVisible(true);
        main.add(textArea);
       
		this.add(main);
		
		this.setSize(800, 510);
		this.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);// start frame in center of screen
		
	}

	public void setItself(MainPanel testMainPanel) {
		tmp = testMainPanel;
				}
}
