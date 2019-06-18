package game;

import java.io.*;

public class WriteRecord {
	private String path;
	private boolean appendToFile = false;
	
	public static void main(String[] args) throws IOException{
		String filePath = "C:/Users/LENOVO/workspace/FifthProject/records.txt";
		
		try {
			ReadRecord file = new ReadRecord(filePath);
			String[] aryLine = file.openFile();
			
			for(int i=0; i<aryLine.length; i++)
				System.out.println(aryLine[i]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		WriteRecord data = new WriteRecord(filePath, true);
		data.writeToFile("fateme");
		System.out.println( "Text File Written To" );
	}
	
	public WriteRecord(String filePath){
		path = filePath;
	}
	public WriteRecord(String filePath , boolean appendValue) {
		path = filePath;
		appendToFile = appendValue;
		 
		}
	
	public void writeToFile(String textLine) throws IOException {
		FileWriter fw = new FileWriter(path , appendToFile);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.printf( "%s" + "%n" , textLine);
		pw.close();
	}
}
