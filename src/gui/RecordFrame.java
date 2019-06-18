package gui;

import game.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class RecordFrame extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public RecordFrame() throws Exception {
		setTitle("Records");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(10, 3, 0, 0));
		
		JLabel lable;
		
		ReadRecord file = new ReadRecord("C:/Users/LENOVO/workspace/FifthProject/records.txt");
		String[] data = file.openFile();
		
		for (int i=0; i<data.length; i++) {
			lable = new JLabel(data[i]);
			panel.add(lable);
		}
	}
}
