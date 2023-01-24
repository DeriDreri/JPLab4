package ad2;

import javax.swing.JTextField;

public class GroupedTextField extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int count;
	
	public GroupedTextField(int count) {
		this.count = count;
	}
	
	public int getNumber() {
		return this.count;
	}
	
}
