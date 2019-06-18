package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LostFrame extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public LostFrame() {
		setTitle("Flood It!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		/**
		 * panel contains a label and a photo
		 */
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lostLabel = new JLabel("YOU LOST!");
		lostLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lostLabel, BorderLayout.NORTH);
		
		JLabel imgLable = new JLabel(new ImageIcon("C:/Users/LENOVO/workspace/FifthProject/img/2.JPG"));
		panel.add(imgLable);
	}

}
