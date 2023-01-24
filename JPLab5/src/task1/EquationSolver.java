package task1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class EquationSolver {

	private final Variable[] equationElements;
	private LinkedList<Variable> variablesForIterations;
	private Operation desiredOperation;

	public EquationSolver(Variable[] variablesTable) {
		this.equationElements = variablesTable;
		Set<Variable> variablesForIterations = new HashSet<>();
		for (Variable i : variablesTable) {
			if (i.isVariable())
				variablesForIterations.add(i);
		}
		this.variablesForIterations = new LinkedList<Variable>(variablesForIterations);


	}
	
	public boolean findSolution(Operation desiredOperation) {
		if (variablesForIterations.size() == 0) throw new IllegalArgumentException("Brak symboli");
		this.desiredOperation = desiredOperation;
		return iterate(this.variablesForIterations);
	}
	
	public LinkedList<Variable> getSolutions() {
		return this.variablesForIterations;
	}
	
	private boolean iterate(LinkedList<Variable> variablesLeftToIterate) {
		boolean solutionFound = false;
		Variable iteratableVariable = variablesLeftToIterate.get(0);
		LinkedList<Variable> variablesLeftToIterateAgain = new LinkedList<>(variablesLeftToIterate);
		variablesLeftToIterateAgain.removeFirst();
		for (int i = 0; i < 10; i++) {
			iteratableVariable.setValue(i);
			
			if (variablesLeftToIterateAgain.size() != 0) solutionFound = iterate(variablesLeftToIterateAgain);
			else
				switch(desiredOperation) {
				
				case ADDING:
					solutionFound = solveAdding();
					break;
				
				case SUBTRACTING:
					solutionFound = solveSubtracting();
					break;
				
				case MULTIPLYING:
					solutionFound = solveMultiplying();
					break;
				
				default:
					continue;
				}
			
			if(solutionFound) {
				return solutionFound;
			}
		}

		return solutionFound;
	}
	
	private boolean solveAdding() {
		int power0 = equationElements[0].getValue() + equationElements[3].getValue() - equationElements[6].getValue();
		int power1 = equationElements[1].getValue() + equationElements[4].getValue() - equationElements[7].getValue();
		int power2 = equationElements[2].getValue() + equationElements[5].getValue() - equationElements[8].getValue();
			
		int sum = power0 + power1 * 10 + power2 * 100 - equationElements[9].getValue() * 1000;
		
		return (sum == 0);
	}

	private boolean solveSubtracting() {
		int power0 = equationElements[0].getValue() - equationElements[3].getValue() - equationElements[6].getValue();
		int power1 = equationElements[1].getValue() - equationElements[4].getValue() - equationElements[7].getValue();
		int power2 = equationElements[2].getValue() - equationElements[5].getValue() - equationElements[8].getValue();
			
		int sum = power0 + power1 * 10 + power2 * 100 - equationElements[9].getValue() * 1000;
		
		return (sum == 0);
		
	}

	private boolean solveMultiplying() {
		int power4 = equationElements[2].getValue() * equationElements[5].getValue();
		if (power4 != 0) return false;
		
		int power0 = equationElements[0].getValue() * equationElements[3].getValue() - equationElements[6].getValue();
		if (power0 % 10 != 0) return false;
		
		int power3 = equationElements[1].getValue() * equationElements[5].getValue() + equationElements[2].getValue() * equationElements[4].getValue() - equationElements[9].getValue();
		int power2 = equationElements[2].getValue() * equationElements[3].getValue() + equationElements[1].getValue() * equationElements[4].getValue() + equationElements[5].getValue() * equationElements[0].getValue() - equationElements[8].getValue();
		int power1 = equationElements[0].getValue() * equationElements[4].getValue() + equationElements[1].getValue() * equationElements[3].getValue() - equationElements[7].getValue();
		
		int sum = power0 + power1 * 10 + power2 * 100 + power3 * 1000;
	
		return (sum == 0);
	}

}
