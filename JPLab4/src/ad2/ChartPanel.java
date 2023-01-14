package ad2;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ChartPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	final int PANEL_WIDTH = 652;
	final int PANEL_HEIGHT = 265;
	
	
	public ChartPanel() {
		this.setBackground(new Color(255, 255, 255));
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setBounds(10, 11, PANEL_WIDTH, PANEL_HEIGHT);
	}
}
