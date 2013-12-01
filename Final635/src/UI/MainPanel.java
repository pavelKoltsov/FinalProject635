package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

	// constructor
	public MainPanel(String windowLabel) {

		this.setTitle(windowLabel);
		configureMainPanel();
		button1.addActionListener(new ListenForButton());

	}// end constructor

	class ListenForButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			InputHandler input = new MySQLHandler();
			String s = (String) chipSetSelect.theDropDown.getSelectedItem();
			processorSelect.pholder.getIndexSelected(s);
			try {
				input.setProcessor(processorSelect.getDropDownIndex() + 1,
						processorSelect.pholder.getId());
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
		// mainPanel.setBackground(Color.BLUE);
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
		// prepare
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack(); // pack frame
		this.setLocationRelativeTo(null);// start frame in center of screen
		this.setVisible(true);
	}// end private method configureMainPanel

	public void configureOutput() {

		JTextArea textArea = new JTextArea();
		Font font = new Font("Verdana", Font.BOLD, 12);
		textArea.setFont(font);
		textArea.setForeground(Color.BLACK);
		this.remove(mainPanel);
		this.remove(button1);
		main = new JPanel();

		textArea.insert("\n", 0);
		textArea.append("\tThis is your current system configuration:\n");
		textArea.append("\n");
		textArea.append("\t\tYour processor is:\n");
		textArea.append("\t\t"
				+ Display.selectedSystem.getParts().get(0).getDescription()
				+ "\n");
		textArea.append("\t\t It has rating of "
				+ Display.selectedSystem.getParts().get(0).getRating()
				+ " on scale of 0 to 100 \n\n");
		textArea.append("\t\tYour hard drive is:\n");
		textArea.append("\t\t"
				+ Display.selectedSystem.getParts().get(1).getDescription()
				+ "\n");
		textArea.append("\t\tIt has rating of "
				+ Display.selectedSystem.getParts().get(1).getRating()
				+ " on scale of 0 to 100 \n\n");
		textArea.append("\t\tYour memory is:\n");
		textArea.append("\t\t"
				+ Display.selectedSystem.getParts().get(2).getDescription()
				+ "\n");
		textArea.append("\t\tIt has rating of "
				+ Display.selectedSystem.getParts().get(2).getRating()
				+ " on scale of 0 to 100 \n\n");
		textArea.append("\tYour overall system rating is "
				+ Display.selectedSystem.getRating()
				+ " on scale 0 to 100 \n\n");

		if (Display.myComponents.getRecommendedProcessor().size() != 0) {
			textArea.append("\tHere is what you can use to upgrade your processor:\n\n");
			for (int i = 0; i < Display.myComponents.getRecommendedProcessor()
					.size(); i++)
				textArea.append("\t\t"
						+ Display.myComponents.getRecommendedProcessor().get(i)
								.getDescription() + "\n");
			textArea.append("\n");
		} else
			textArea.append("\tYou have the best processor available\n\n");

		if (Display.myComponents.getRecommendedHardDrives().size() != 0) {
			textArea.append("\tHere is what you can use to upgrade your hard drive:\n\n");
			for (int i = 0; i < Display.myComponents.getRecommendedHardDrives()
					.size(); i++)
				textArea.append("\t\t"
						+ Display.myComponents.getRecommendedHardDrives()
								.get(i).getDescription() + "\n");

		} else
			textArea.append("\tYou have the best hard drive available\n");
		textArea.append("\n");

		if (Display.myComponents.getRecommendedMemory().size() != 0) {
			textArea.append("\tHere is what you can use to upgrade your memory:\n\n");
			for (int i = 0; i < Display.myComponents.getRecommendedMemory()
					.size(); i++)
				textArea.append("\t\t"
						+ Display.myComponents.getRecommendedMemory().get(i)
								.getDescription() + "\n");

		} else
			textArea.append("\tYou have the best memory available\n");

		main.add(textArea);
		main.setBackground(Color.DARK_GRAY);
		JScrollPane scrPane = new JScrollPane(main);
		this.setSize(getMaximumSize());
		scrPane.setPreferredSize(new Dimension(this.getWidth() - 45, this
				.getHeight() - 105));
		this.add(scrPane);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);// start frame in center of screen

	}
}
