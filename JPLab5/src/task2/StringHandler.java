package task2;

import java.util.ArrayList;

import javax.swing.JTextField;

public class StringHandler {
	
	private String screenString;
	private boolean lastButtonWasNumberButton;
	private boolean inputBigLetters;
	private final ArrayList<Character> operationSigns;
	private final StringOperationSolver operationSolver;
	
	public StringHandler(JTextField screenField) {
		this.screenString = "";
		this.lastButtonWasNumberButton = false;
		this.inputBigLetters = false;
		this.operationSigns = new ArrayList<Character>();
		this.operationSigns.add('+');
		this.operationSigns.add('-');
		this.operationSigns.add('/');
		this.operationSolver = new StringOperationSolver();
	}
	
	public String getScreenString() {
		return screenString;
	}
	
	public void switchSmallBigLetters() {
		lastButtonWasNumberButton = false;
		if(inputBigLetters) inputBigLetters = false;
		else inputBigLetters = true;
	}
	
	public void removeLastSign() {
		lastButtonWasNumberButton = false;
		int stringLength = screenString.length();
		if (stringLength == 0) return;
		screenString = screenString.substring(0, stringLength-2);
	}
	
	public void removeAllSigns() {
		lastButtonWasNumberButton = false;
		screenString = "";
	}
	
	public void addOpperationSymbol(String operation) throws IllegalArgumentException {
		if (!operationSigns.contains(operation.charAt(0)) || operation.length() != 1) throw new IllegalArgumentException();
		int stringLength = screenString.length();
		char lastSign = screenString.charAt(stringLength-2);
		if (operationSigns.contains(lastSign)) removeLastSign();
		lastButtonWasNumberButton = false;
		screenString += operation;
	}
	
	public void solveOperation() {
		lastButtonWasNumberButton = false;
		screenString += operationSolver.solveOperation(screenString);
	}

}
