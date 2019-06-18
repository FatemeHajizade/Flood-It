package game;

import gui.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class Game {
	public Game(){
	}
	/**
	 * This method make game ready to start
	 * @param name is name of user
	 * @param row is rows of game board
	 * @param column is columns of game board
	 * @param color is number of colors of game board
	 * @param choice is choices of user for pressing color button
	 */
	public void newGame(String name, int row, int column, int color, int choice){
		MainFrame frame = new MainFrame(name, row, column, color, choice);
		frame.setVisible(true);
	}
	/**
	 * This method is listening for pressing color button
	 * @param steps is number of time that user pressed color button
	 * @param time show time of which game has been started 
	 * @throws IOException
	 */
	public void colorButtonListener(String name, int row, int column,int choice, int steps, JLabel[][] gameBoard, Color newColor,int time) throws IOException{
			colorChange(0,0,row,column,gameBoard,newColor);
			state(name,row,column,choice,steps,gameBoard,newColor,time);
	}
	/**
	 * This method change the color of game board
	 * @param i is zero
	 * @param j is zero
	 * @param newColor is is color of button that has been pressed
	 */
	public void colorChange(int i, int j, int row,int column, JLabel[][] gameBoard, Color newColor){
		try{
			Color clr = gameBoard[i][j].getBackground();
			gameBoard[i][j].setBackground(newColor);
			
			if(j<column-1 && gameBoard[i][j+1].getBackground().equals(clr))
				colorChange(i, j+1, row, column, gameBoard, newColor);
			if(j>0 && gameBoard[i][j-1].getBackground().equals(clr))
				colorChange(i, j-1, row, column, gameBoard, newColor);
			if(i<row-1 && gameBoard[i+1][j].getBackground().equals(clr))
				colorChange(i+1, j, row, column, gameBoard, newColor);
			if(i>0 && gameBoard[i-1][j].getBackground().equals(clr))
				colorChange(i-1, j, row, column, gameBoard, newColor);	

		}
		catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
	}
	/**
	 * This method checks state of player
	 * @throws IOException
	 */
	public void state(String name, int row, int column, int choice, int steps, JLabel[][] gameBoard, Color newColor, int time) throws IOException{
		int record=0;
		float pow=1/3;
		
		if (steps==choice)
			lose();
		
		boolean flag = false;
		A:{
			for (int i=0; i<row; i++)
				for (int j=0; j<column; j++)
					if(!(gameBoard[i][j].getBackground().equals(newColor))){
						flag = true;
						break A;
					}
		}
		if (!flag){
			record = (int) ((row*column*100)/steps*(Math.pow(time, pow)));
			win(record);
			setRecord(name,record);
		}

	}
	/**
	 * This method make some change when player wins
	 * @param record is record of player
	 */
	public void win (int record){
		gui.WinFrame frame = new WinFrame(record);
		frame.setVisible(true);
	}
	/**
	 * This method make some change when player loses
	 */
	public void lose(){
			gui.LostFrame frame = new LostFrame();
			frame.setVisible(true);
	}
	/**
	 * This method write record of player in a text file
	 * @throws IOException
	 */
	public void setRecord(String name, int record) throws IOException{

		WriteRecord data = new WriteRecord("C:/Users/LENOVO/workspace/FifthProject/records.txt", true);
		data.writeToFile(name+": "+record);
	}
}
