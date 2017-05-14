package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Pedro Victori
 *
 */

public class TextFile{
	private File file;
	private String path = "./src/res/";

	//Constructor
	public TextFile(String fileName){
		file = new File(path+fileName);
	}

	public int getLinesNumber(){ 
		int lines = 0;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while (reader.readLine() != null){
				lines++;
			}
			reader.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							file + "'");                
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '" 
							+ file + "'");                  
		}
		return lines;
	}
	public String[] parseCSVLine(int nLine){ //We input the number of the line we want to read, it returns every CSV as an element of an array.
		String separator = ",";
		String[] parsedCSVLine = getLine(nLine).split(separator);
		return parsedCSVLine;
	}
	
	public ArrayList<String> getAllLines(){
		ArrayList<String> lines = new ArrayList<String>();
		String line = null;
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null){
				lines.add(line);
			}
			reader.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							file + "'");                
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '" 
							+ file + "'");                  
		}
		return lines;
	}
	public String getLine(int nLine){
		// This will reference one line at a time
		String line = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		int counter = 0;
		try {
			// FileReader reads text files in the default encoding.
			fileReader = new FileReader(file);

			// Always wrap FileReader in BufferedReader.
			bufferedReader = new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				counter++;
				if(counter == nLine) break;
			}  

		}
		
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							file + "'");  
		}
		
		catch(IOException ex) {
			System.out.println(
					"Error reading file '" 
							+ file + "'");                  
			// Or we could just do this: 
			// ex.printStackTrace();
		}
		
		finally
		{
			if(fileReader != null){
				// Always close files.
				try{
					bufferedReader.close();
				} 
				catch(IOException e){
					System.out.println("IO exception at finally block");
					e.printStackTrace();
				}            
			}
		}
		
		return line;
	}
}
