package game;

import java.io.*;

public class ReadRecord {
	private String path;

	public static void main(String[ ] args) throws IOException {
		String filePath = "C:/Users/LENOVO/workspace/FifthProject/records.txt";
		try {
			ReadRecord file = new ReadRecord(filePath);
			String[] aryLine = file.openFile();
			
			for(int i=0; i<aryLine.length; i++)
				System.out.println(aryLine[i]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ReadRecord(String filePath){
		path = filePath;
	}
	
	public String[] openFile() throws Exception{
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		
		int numberOfLines = 10;
		String[] textData = new String[numberOfLines];
		
		for (int i=0; i<numberOfLines; i++) {
			textData[i] = br.readLine();
		}
		br.close();
		 
		return textData;
	}
	
//	public int readLine() throws IOException{
//		FileReader fr = new FileReader(path);
//		BufferedReader br = new BufferedReader(fr);
//	
//		String aLine = br.readLine();
//		int numberOfLines = 0;
//		
//		while(aLine != null){
//			numberOfLines++;
//		}
//		br.close();
//		return numberOfLines;
//	}
}
