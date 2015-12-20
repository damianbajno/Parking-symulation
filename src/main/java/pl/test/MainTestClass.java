package pl.test;

import pl.panels.ParkingSpacesTextBoard;
import pl.pojo.Client;
import pl.tools.Tools;

public class MainTestClass {
	static MainTestClass mainTestClass=new MainTestClass();
	String txt="Damian Class";
	
	public static void main(String[] args) {
	    	TestClass testClass = new MainTestClass.TestClass();
		testClass.print();
	}

	
	public static class TestClass{
	    String txt="Damian Instance Variable";
	    
	    public void print(){
		System.out.println(txt);
	    }
	}
}
