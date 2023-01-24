package task2;

public class StringOperationSolver {

	public String solveOperation(String operation) {
		StringBuilder solution = new StringBuilder("=");
		
		return solution.toString();
	}
	
	public String solveOperation() {
		
		
		return "";
	}
	
	public String addStrings(String first, String second) {
		return first + second;
	}
	
	public String subtractString(String first, String second) {
		if (first.contains(second) == false) return first;
		String[] elements = first.split(second);
		StringBuilder toReturn = new StringBuilder(elements[0]);
		for(int i = 1; i < elements.length; i++) {
			toReturn.append(elements[i]);
		}
		return toReturn.toString();
	}
	
	public String divideStrings(String first, String second) {
		

		return "";
	}
	
	
	public static void main(String[] args) {
		var solver = new StringOperationSolver();
		System.out.println(solver.subtractString("MarmolaMada", "mo"));
	}
}
