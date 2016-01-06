package pl.tools;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.Box.Filler;

public class ComperFiles {

    private static final String TO_COMPER_FILE_DIRECTORY = "/home/damian/jstack-pid5364-afterProgramClosed.txt";
    private static final String TARGET_FILE_DIRECTORY = "/home/damian/jstackpid5364.txt";

    public static void main(String[] args) {
	
	Scanner targetFile;
	Scanner fileToComper;
	
	try {
	    targetFile = new Scanner(new BufferedInputStream(
		    new FileInputStream(TARGET_FILE_DIRECTORY)));
	    fileToComper = new Scanner(
		    new BufferedInputStream(
			    new FileInputStream(
				    TO_COMPER_FILE_DIRECTORY)));

	    StringBuilder fileToComperText = new StringBuilder();
	    while (fileToComper.hasNext()) {
		String textLine = (String) fileToComper.next();
		fileToComperText.append(textLine + "/n");
	    }
	    String fileToComperString = new String(fileToComperText);

	    while (targetFile.hasNextLine()) {
		String lineTargetFile = targetFile.nextLine();
		if (!fileToComperString.contains(lineTargetFile)) {
		    System.out.println(lineTargetFile);
		}
	    }

	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} finally {
	    
	}
    }

}
