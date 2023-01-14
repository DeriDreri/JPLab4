package ad2;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ChartPanel extends JPanel{

	
	public ChartPanel() {
		this.setBackground(new Color(255, 255, 255));
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setBounds(10, 11, 652, 265);
	}
}
