package pl.panel;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import pl.constantsandstrings.Constants;
import pl.constantsandstrings.Names_PL;

public class ParkingSpacesTextBoard extends JPanel {
    private static final String APPLICATION_LOGGER = "TextBoardLogger";
    private static ParkingSpacesTextBoard parkingSpacesTextBoard;
    private static JTextArea jTextArea = new JTextArea();

    private final String FILE_DIRECTORY = "/home/damian/Desktop/Coders/TestFiles/%s ParkingSpaceLoggerFromBoard.odt";
    private Logger logger = Logger.getLogger(APPLICATION_LOGGER);

    public static ParkingSpacesTextBoard getInstance() {

	if (parkingSpacesTextBoard == null) {
	    synchronized (ParkingSpacesTextBoard.class) {
		if (parkingSpacesTextBoard == null) {
		    parkingSpacesTextBoard = new ParkingSpacesTextBoard();
		}
	    }
	}
	return parkingSpacesTextBoard;
    }

    private ParkingSpacesTextBoard() {
	jTextArea.setEditable(false);
	jTextArea.setFont(new Font(Font.SERIF, Font.PLAIN, 12));
	jTextArea.setPreferredSize(Constants.PARKING_BOARD_TEXT_AREA_DIMENSION);
	jTextArea.setAutoscrolls(true);
	jTextArea.setLineWrap(true);
	jTextArea.setBorder(BorderFactory.createTitledBorder(null,
		Names_PL.PARKING_BOARD_TITLE,
		TitledBorder.DEFAULT_JUSTIFICATION,
		TitledBorder.DEFAULT_POSITION, new Font(Font.SERIF, Font.PLAIN,
			17)));

	add(jTextArea);
	
	DefaultCaret defaultCaret = (DefaultCaret) jTextArea.getCaret();
	defaultCaret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
	
	
	initializeHandler();
    }

    private AtomicInteger numberOfWritedLines =new AtomicInteger(5);

    public void append(String text) {
	
	synchronized (jTextArea) {
	    jTextArea.setRows(jTextArea.getLineCount() + 2);
	}
	// setRows(numberOfWritedLines.get());
	// logger.info(text);

	final String str1 = text;
	EventQueue.invokeLater(new Runnable() {

	    public void run() {
		jTextArea.append(str1);

	    }
	});
    }

    public int getRows() {
	return jTextArea.getRows();
    }

    public void setRows(int rows) {
	jTextArea.setRows(rows);
    }

    private void initializeHandler() {
	try {
	    Handler fileHandeler = new FileHandler(
		    getFileDirectoryWithDateTime(), true);
	    logger.addHandler(fileHandeler);
	} catch (SecurityException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    private String getFileDirectoryWithDateTime() {
	DateTime dateTime = new DateTime(DateTimeZone.getDefault());
	DateTimeFormatter dateTimeFormatter = DateTimeFormat
		.forPattern("ddMMyyyy HH:mm:ss");
	return String.format(FILE_DIRECTORY,
		dateTime.toString(dateTimeFormatter));
    }

}
