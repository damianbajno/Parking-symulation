package pl.tools;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ComperFiles {

	public static void main(String[] args) {
		try {
			Scanner targetFile=new Scanner(new BufferedInputStream(new FileInputStream("/home/damian/jstackpid5364.txt")));
			Scanner fileToComper=new Scanner(new BufferedInputStream(new FileInputStream("/home/damian/jstack-pid5364-afterProgramClosed.txt")));
			
			
			StringBuilder fileToComperText=new StringBuilder();
			while (fileToComper.hasNext()) {
				String textLine =(String) fileToComper.next();
				fileToComperText.append(textLine+"/n");
			}
			String fileToComperString=new String(fileToComperText);
			
			while (targetFile.hasNextLine()){
				String lineTargetFile = targetFile.nextLine();
				if (!fileToComperString.contains(lineTargetFile)) {
					System.out.println(lineTargetFile);
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
