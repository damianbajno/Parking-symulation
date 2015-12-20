package pl.tools;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FindTextInFile {
    private static String fileDirectory = "/home/damian/Desktop/Coders/TestFiles/19122015 13:25:55 ParkingSpaceLoggerFromBoard.odt";

    public static void main(String[] args) {
	Scanner targetFile=null;
	
	try {
	    targetFile = new Scanner(new BufferedInputStream(new FileInputStream(fileDirectory)));
	    
	    while (targetFile.hasNext()) {
		String lineFromFile = (String) targetFile.next();
		System.out.println(lineFromFile);
//		if (lineFromFile.contains("Finished")) {
//		   System.out.println(lineFromFile);
//		}
		
	    }
	    
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} finally {
	    targetFile.close();
	}

	
    }

}
