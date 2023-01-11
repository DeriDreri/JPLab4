package ad1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.awt.RenderingHints;
import java.awt.*;

import javax.swing.JPanel;

public class PieChartPanel extends JPanel {

	private LinkedList<Arc2D> chartElements;
	private ArrayList<Color> colorsOfChartElements;
	private Random colorRandomizer;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PieChartPanel() {
		this.setBounds(40, 40, 400, 400);
		FlowLayout flowLayout = (FlowLayout) this.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(200);
		flowLayout.setHgap(200);
		this.chartElements = new LinkedList<Arc2D>();
		this.colorRandomizer = new Random();
		var graphics2D = (Graphics2D) this.getGraphics();
		var graphA = new Arc2D.Double(0, 0, 400, 400, 0, 180, Arc2D.PIE);
		var graphB = new Arc2D.Double(0, 0, 400, 400, 180, 180, Arc2D.PIE);
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2D.setStroke(new BasicStroke());
		graphics2D.draw(graphA);
		graphics2D.draw(graphB);
		repaint();
	}

	public void refreshPieGraph(int[] dimensions) {
		int fullSize = 0;
		for (int i : dimensions) {
			fullSize += i;
		}

	}

}
