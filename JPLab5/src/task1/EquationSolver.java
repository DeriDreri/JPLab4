package task1;

import java.util.HashSet;
import java.util.Set;

public class EquationSolver {
	
	private final Variable[] equationElements;
	private Set<Variable> variablesForIterations;
	
	
	public EquationSolver(Variable[] variablesTable) {
		this.equationElements = variablesTable;
		variablesForIterations = new HashSet<>();
		for(Variable i : variablesTable) {
			if(i.isVariable()) variablesForIterations.add(i);
		}
	}
	
	//For testing
	public void printElements() {
		for(Variable element : equationElements) {
			System.out.println(element.getName() + ":" + element.getValue());
		}
	}
	
	//For testing
	public void printIteratableElements() {
		for (Variable element : variablesForIterations) {
			element.giveRandomValue();
			System.out.println(element.getName() + ":" + element.getValue());
		}
	}
	
	
	
	
	public int[] solveAdding() {
		int[] solutions = new int[10];
		
		boolean isSolution = ((equationElements[0].getValue() + equationElements[3].getValue() + (equationElements[1].getValue() + equationElements[4].getValue() ) * 10 + (equationElements[2].getValue() + equationElements[5].getValue()) * 100) == equationElements[6].getValue() + equationElements[7].getValue() * 10 + equationElements[8].getValue() * 100 + equationElements[9].getValue() * 1000);
		
		return solutions;
	}
	
	public int[] solveSubtracting() {
		int[] solutions = new int[10];
		
		boolean isSolution = ((equationElements[0].getValue() - equationElements[3].getValue() + (equationElements[1].getValue() - equationElements[4].getValue() ) * 10 + (equationElements[2].getValue() - equationElements[5].getValue()) * 100) == equationElements[6].getValue() + equationElements[7].getValue() * 10 + equationElements[8].getValue() * 100 + equationElements[9].getValue() * 1000);
		
		return solutions;
	}
	
	public int[] solveMultiplaying() {
		int[] solutions = new int[10];
		
		boolean isSolution = (equationElements[0].getValue() * equationElements[3].getValue() + (equationElements[0].getValue() * equationElements[4].getValue() + equationElements[1].getValue() * equationElements[3].getValue()) * 10 + (equationElements[2].getValue() * equationElements[3].getValue() + equationElements[5].getValue() * equationElements[0].getValue() + equationElements[1].getValue() * equationElements[4].getValue()) * 100 + (equationElements[2].getValue() * equationElements[4].getValue() + equationElements[1].getValue() * equationElements[5].getValue()) * 1000 + equationElements[2].getValue() * equationElements[5].getValue() * 10000 == equationElements[6].getValue() + equationElements[7].getValue() * 10 + equationElements[8].getValue() * 100 + equationElements[9].getValue() * 1000);
		
		return solutions;
	}

}
