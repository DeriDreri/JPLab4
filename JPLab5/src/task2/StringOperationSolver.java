package task2;

import java.util.LinkedList;

public class StringOperationSolver {

	public String solveOperation(String operation) {
		LinkedList<Character> addSubList = new LinkedList<>();
		LinkedList<Character> allEquationsList = new LinkedList<>();

		String[] addingCut = operation.split("\\+");
		LinkedList<String> addingSubtractingCut = new LinkedList<>();
		LinkedList<String> finalCut = new LinkedList<>();

		for (int i = 0; i < addingCut.length; i++) {
			String[] subtractingElements = addingCut[i].split("-");
			for (int j = 0; j < subtractingElements.length; j++) {
				addingSubtractingCut.add(subtractingElements[j]);
				addSubList.add('-');
			}
			addSubList.removeLast();
			addSubList.add('+');
		}
		addSubList.removeLast();

		for (int j = 0; j < addingSubtractingCut.size(); j++) {
			String[] dividingElements = addingSubtractingCut.get(j).split("/");
			for (int i = 0; i < dividingElements.length; i++) {
				finalCut.add(dividingElements[i]);
				allEquationsList.add('/');
			}
			allEquationsList.removeLast();
			if (addSubList.size() > 0) {
				allEquationsList.add(addSubList.getFirst());
				addSubList.removeFirst();
			}

		}

		String solution = finalCut.get(0);
		for (int i = 0; i < allEquationsList.size(); i++) {
			switch (allEquationsList.get(i)) {
			case '+':
				solution = addStrings(solution, finalCut.get(i+1));
				break;
			case '-':
				solution = subtractString(solution, finalCut.get(i+1));
				break;
			case '/':
				solution = divideStrings(solution, finalCut.get(i+1));
				break;
			default:
				break;
			}

		}
		return "=" + solution;
	}

	public String addStrings(String first, String second) {
		return first + second;
	}

	public String subtractString(String first, String second) {
		if (first.contains(second) == false)
			return first;
		String[] elements = first.split(second);
		StringBuilder toReturn = new StringBuilder(elements[0]);
		for (int i = 1; i < elements.length; i++) {
			toReturn.append(elements[i]);
		}
		return toReturn.toString();
	}

	public String divideStrings(String first, String second) {
		String longestCommon = "";
		for (int i = 0; i < second.length(); i++) {
			StringBuilder potentialCommon = new StringBuilder("");
			for (int j = i; j < second.length(); j++) {
				potentialCommon.append(second.charAt(j));
				if (first.contains(potentialCommon) && longestCommon.length() < potentialCommon.length()) {
					longestCommon = potentialCommon.toString();
				} 
			}
		}

		return longestCommon;
	}

}
