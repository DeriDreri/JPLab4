package task1;

import java.util.Random;

public class Variable {
	
	private int value;
	private final boolean isVariable;
	private final char name;
	//For testing
	Random randGenerator = new Random();;
	
	public Variable(int value) {
		this.name = (char) (value + '0');
		this.isVariable = false;
		this.value = value;
	}
	
	public Variable(char name) {
		this.name = name;
		this.isVariable = true;
		//forTesting
		this.value = randGenerator.nextInt();
	}
	
	public int getValue() {
		return this.value;
	}
	
	//For testing
	public void giveRandomValue() {
		this.value = randGenerator.nextInt();
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public char getName() {
		return this.name;
	}
	
	public boolean isVariable() {
		return this.isVariable;
	}

}
