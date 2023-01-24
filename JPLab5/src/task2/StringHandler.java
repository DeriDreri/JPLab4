package task2;

import java.util.ArrayList;

public class StringHandler {
	
	private String screenString;
	private ButtonPressed lastButtonPressed;
	private boolean inputBigLetters;
	private final ArrayList<Character> operationSigns;
	private final StringOperationSolver operationSolver;
	private boolean wasSolved;
	
	public StringHandler() {
		this.screenString = "";
		this.lastButtonPressed = ButtonPressed.OTHER;
		this.inputBigLetters = false;
		this.operationSigns = new ArrayList<Character>();
		this.operationSigns.add('+');
		this.operationSigns.add('-');
		this.operationSigns.add('/');
		this.operationSolver = new StringOperationSolver();
		this.wasSolved = false;
	}
	
	public String getScreenString() {
		return screenString;
	}
	
	public void refresh() {
		if(wasSolved) {
			screenString = "";
			wasSolved = false;
		}
	}

	public void addSign(ButtonPressed buttonInput) {
		
		int indexOfChar;
		if(!buttonInput.equals(lastButtonPressed)) {
			indexOfChar = 0;
		}
		else {
			char lastChar = screenString.charAt(screenString.length()-1);
			if(lastChar < 97) lastChar += 32;
			indexOfChar = buttonInput.toString().indexOf(lastChar);
			indexOfChar++;
			if(indexOfChar >= buttonInput.toString().length()) indexOfChar = 0;
			removeLastSign();
		}
		
		char signToAdd = buttonInput.toString().charAt(indexOfChar);
		if (inputBigLetters) signToAdd = (char) (signToAdd - 32);
		screenString += signToAdd;
		lastButtonPressed = buttonInput;
	}
	
	public void switchSmallBigLetters() {
		lastButtonPressed = ButtonPressed.OTHER;
		if(inputBigLetters) inputBigLetters = false;
		else inputBigLetters = true;
	}
	
	public void removeLastSign() {
		lastButtonPressed = ButtonPressed.OTHER;
		int stringLength = screenString.length();
		if (stringLength == 0) return;
		screenString = screenString.substring(0, stringLength-1);
	}
	
	public void removeAllSigns() {
		lastButtonPressed = ButtonPressed.OTHER;
		screenString = "";
	}
	
	public void addOpperationSymbol(String operation) throws IllegalArgumentException {
		if (!operationSigns.contains(operation.charAt(0)) || operation.length() != 1 || screenString.length() == 0) throw new IllegalArgumentException();
		int stringLength = screenString.length();
		char lastSign = screenString.charAt(stringLength-1);
		if (operationSigns.contains(lastSign)) removeLastSign();
		lastButtonPressed = ButtonPressed.OTHER;
		screenString += operation;
	}
	
	public void solveOperation() {
		lastButtonPressed = ButtonPressed.OTHER;
		char lastSign = screenString.charAt(screenString.length()-1);
		if (operationSigns.contains(lastSign)) removeLastSign(); 
		screenString += operationSolver.solveOperation(screenString);
		wasSolved = true;
	}

}
