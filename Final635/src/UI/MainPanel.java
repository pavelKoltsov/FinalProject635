package UI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import backend.InputHandler;

@SuppressWarnings("serial")
public class MainPanel extends JFrame {

	ComponentSelect processorSelect = new ComponentSelect("Processor");
	ComponentSelect hardDriveSelect = new ComponentSelect("Hard Drive");
	ComponentSelect memorySelect = new ComponentSelect("Memory");
	ComponentSelect chipSetSelect = new ComponentSelect("Chipset");

	JButton button1 = new JButton();
	// constructor
	public MainPanel(String windowLabel) {

		this.setTitle(windowLabel);
		configureMainPanel();
		button1.addActionListener(new ListenForButton());// add listener for															
		//
	}// end constructor

	private class ListenForButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			InputHandler input = new InputHandler();
			try {
				input.setProcessor(processorSelect.getDropDownIndex() + 1);
				input.setHardDrive(hardDriveSelect.getDropDownIndex() + 1);
				input.setMemory(memorySelect.getDropDownIndex() + 1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}// end method action performed

	}// end private class ListenForButton

	private void configureMainPanel() {
		// create the primary internal panel
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.CYAN);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setSize(800, 400);
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
		this.setLayout(new BoxLayout(rootPane, BoxLayout.Y_AXIS));

		// prepare
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack(); // pack frame
		this.setLocationRelativeTo(null);// start frame in center of screen
		this.setVisible(true);

	}// end private method configureMainPanel
}// end class MainPanel
