package gui;

import game.Game;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;



public class MainFrame extends JFrame {
	int time=0;
	int steps=0;

	/**
	 * Create the frame.
	 */
	public MainFrame(String name,int row, int column, int color, int choice) {
		setTitle("Flood It!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 0, 700, 600);
		getContentPane().setLayout(new BorderLayout());
		/**
		 * Left panel contain 2 panel
		 */
		JPanel leftPanel = new JPanel();
		getContentPane().add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new BorderLayout());
		/**
		 * Panel_1 contain name and photo of user, timer, step updating, new game button and record button
		 */
		JPanel panel_1 = new JPanel();
		leftPanel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(6, 1, 4, 4));

		JLabel imgLable = new JLabel(new ImageIcon("C:/Users/LENOVO/workspace/FifthProject/img/3.JPG"));
		panel_1.add(imgLable);
		
		JLabel nameLabel = new JLabel("Name: "+name);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(nameLabel);
		
		JButton recordButton = new JButton("Records");
		recordButton.addActionListener(new ActionListener() {
			/**
			 * Open record window when record button is pressed
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new RecordFrame().setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
		panel_1.add(recordButton);
		
		JButton exitButton = new JButton("New Game");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FirstFrame().setVisible(true);
			}
		});
		panel_1.add(exitButton);
	
		JLabel timeLabel = new JLabel();
		Timer timer = new Timer(1000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              time = time+1;
              timeLabel.setText(" Time: "+String.valueOf(time));
              timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            }
            
          });
        timer.start();
		panel_1.add(timeLabel);
		
		JLabel stepLable = new JLabel(0+"/"+choice);
        stepLable.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(stepLable);
		/**
		 * Panel_2 contains color buttons
		 */
		JPanel panel_2 = new JPanel();
		leftPanel.add(panel_2, BorderLayout.CENTER);
		GridLayout gl_panel_2 = new GridLayout(color, 1, 4, 4);
		panel_2.setLayout(gl_panel_2);
		/**
		 * Main panel contains game board
		 */
		JPanel mainPanel = new JPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridLayout(row, column, 0, 0));
		/**
		 * lblNewLabel_1 is used for label of game board
		 * lblNewLabel_2 is used for color buttons
		 */
		JLabel lblNewLabel_1;
		JLabel lblNewLabel_2;
		/**
		 * rand is used for choose a random number
		 */
		Random rand=new Random();
		/**
		 * colors array list is used for saving color of color buttons
		 */
		ArrayList<Color> colors = new ArrayList<Color>();
		/**
		 * game board array is used for saving color of labels of game board
		 */
		JLabel[][] gameBoard = new JLabel[row][column];
		/**
		 * create color buttons
		 */
		for (int i=0; i<color; i++) {
			float r = rand.nextFloat();
			float g = rand.nextFloat();
			float b = rand.nextFloat();
			Color randomColor = new Color(r, g, b);
			colors.add(randomColor);

			lblNewLabel_2=new JLabel(""+(i+1));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setOpaque(true);
			lblNewLabel_2.setBackground(colors.get(i));
			panel_2.add(lblNewLabel_2);
			
			Color backgroundClr = lblNewLabel_2.getBackground();
			/**
			 * Make some changes when color button pressed
			 */
			lblNewLabel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					steps++;
					stepLable.setText(steps+"/"+choice);
					
					Game game = new Game();
					try {
						game.colorButtonListener(name,row,column,choice,steps,gameBoard,backgroundClr,time);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
					
		}
		/**
		 * Create game board
		 */
		for(int i=0; i<row; i++)
			for(int j=0; j<column; j++) {					
				lblNewLabel_1=new JLabel();
				lblNewLabel_1.setOpaque(true);	
				int random=(int)(Math.random()*colors.size());
				lblNewLabel_1.setBackground(colors.get(random));
				gameBoard[i][j] = lblNewLabel_1;
				mainPanel.add(lblNewLabel_1);
			}
	}
	  
}
