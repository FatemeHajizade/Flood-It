package gui;

import game.Game;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
	/**
	 * This frame gets data from user
	 */
public class FirstFrame extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstFrame frame = new FirstFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Number of rows and columns of game board
	 * Number of colors used in game board
	 * Number of choices of user
	 */
	public int row, column, color, choice; 
	/**
	 * Name of user
	 */
	public String name;
	/**
	 * Action performed by start button
	 */
	private final Action action = new SwingAction();
	/**
	 * Text field used for write name of user
	 */
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public FirstFrame() {
		setTitle("Flood It!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		/**
		 * North panel contains name label and text field
		 */
		JPanel northPanel = new JPanel();
		getContentPane().add(northPanel, BorderLayout.NORTH);
		
		JLabel nameLabel = new JLabel("Name:");
		northPanel.add(nameLabel);
		
		textField = new JTextField();
		textField.setToolTipText("Write your name and press enter!");
		northPanel.add(textField);
		textField.setColumns(15);
		
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				name = textField.getText();
			}
		});
		/**
		 * Center panel contains 4 label and 4 spinner for rows, columns, colors and choices
		 */
		JPanel centerPanel = new JPanel();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel rowLabel = new JLabel("Rows");
		centerPanel.add(rowLabel);
		
		JSpinner rowSpinner = new JSpinner();
		rowSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		centerPanel.add(rowSpinner);
			
		rowSpinner.addChangeListener(new ChangeListener() {
				
			@Override
			public void stateChanged(ChangeEvent e) {
				row = (Integer) rowSpinner.getValue();	
				}
			});
		
		JLabel columnLabel = new JLabel("Columns");
		centerPanel.add(columnLabel);
		
		JSpinner columnSpinner = new JSpinner();
		columnSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		centerPanel.add(columnSpinner);
		
		columnSpinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				column = (Integer) columnSpinner.getValue();	
				}
			});
		
		JLabel colorLabel = new JLabel("Colors");
		centerPanel.add(colorLabel);
		
		JSpinner colorSpinner = new JSpinner();
		colorSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		centerPanel.add(colorSpinner);
		
		colorSpinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				color = (Integer) colorSpinner.getValue();	
				}
			});
		
		JLabel choiceLabel = new JLabel("Choices");
		centerPanel.add(choiceLabel);
		
		JSpinner choiceSpinner = new JSpinner();
		choiceSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		centerPanel.add(choiceSpinner);
		
		choiceSpinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				choice = (Integer) choiceSpinner.getValue();	
				}
			});
		/**
		 * South panel contain start button
		 */
		JPanel southPanel = new JPanel();
		getContentPane().add(southPanel, BorderLayout.SOUTH);
		
		JButton startButton = new JButton("Start");
		startButton.setAction(action);
		southPanel.add(startButton);
	}

	private class SwingAction extends AbstractAction {
		/**
		 *  Set name and description of start button
		 */
		public SwingAction() {
			putValue(NAME, "Start");
			putValue(SHORT_DESCRIPTION, "Press to start game!");
		}
		/**
		 * Performing an action when press start button
		 */
		public void actionPerformed(ActionEvent e) {
			dispose();
			if (row==0 || column==0 || color==0 || choice==0)
				System.out.println("Argumants should not be zero!");
			else{
				dispose();
				Game game = new Game();
				game.newGame(name,row,column,color,choice); 
			}
		}
	}
}
