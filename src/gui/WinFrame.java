package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WinFrame extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public WinFrame(int record) {
		setTitle("Flood It!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 450, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		/**
		 * panel contains 2 other panels
		 */
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		/**
		 * North panel contain 2 label
		 */
		JPanel northPanel = new JPanel();
		panel.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel winLabel = new JLabel("YOU WIN!");
		winLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		winLabel.setHorizontalAlignment(SwingConstants.CENTER);
		northPanel.add(winLabel, BorderLayout.NORTH);
		
		JLabel scoreLabel = new JLabel("Your score: "+record);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		northPanel.add(scoreLabel, BorderLayout.CENTER);
		/**
		 * Center panel contain photo
		 */
		JPanel centerPanel = new JPanel();
		panel.add(centerPanel, BorderLayout.CENTER);
		
		JLabel imgLable = new JLabel(new ImageIcon("C:/Users/LENOVO/workspace/FifthProject/img/1.JPG"));
		centerPanel.add(imgLable);
	}

}
