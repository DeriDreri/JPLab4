package ad2;

import javax.swing.JCheckBox;

public class GroupedSelectBox extends JCheckBox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int count;

	public GroupedSelectBox(String text, int count) {
		super(text);
		this.count = count;
	}

	public int getNumber() {
		return this.count;
	}

}
