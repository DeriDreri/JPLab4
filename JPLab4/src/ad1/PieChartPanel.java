package ad1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JPanel;

public class PieChartPanel extends JPanel {

	private Random colorRandomizer;
	private ArrayList<Integer> pieChartElements;
	private ArrayList<Color> pieChartColors;
	private int pieChartSum;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PieChartPanel() {
		FlowLayout flowLayout = (FlowLayout) this.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(200);
		flowLayout.setHgap(200);
		this.colorRandomizer = new Random();
		this.pieChartSum = 0;
		this.pieChartElements = new ArrayList<Integer>();
		this.pieChartColors = new ArrayList<Color>();
	}

	public void addPieChartElement(int addedValue) {
		pieChartElements.add(addedValue);
		pieChartColors.add(
				new Color(colorRandomizer.nextInt(255), colorRandomizer.nextInt(255), colorRandomizer.nextInt(255)));
		pieChartSum += addedValue;
		this.repaint();
	}

	public void removePieChartElement(int index) {
		int removedValue = pieChartElements.remove(index);
		pieChartColors.remove(index);
		pieChartSum -= removedValue;
		this.repaint();
	}

	public void editPieChartElement(int index, int newValue) {
		int removedValue = pieChartElements.remove(index);
		pieChartSum -= removedValue;
		pieChartElements.add(index, newValue);
		pieChartSum += newValue;
		this.repaint();

	}

	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.white);
		g2D.fillOval(0, 0, 380, 380);
		int lastAngle = 0;
		for (int i = 0; i < pieChartElements.size(); i++) {
			g2D.setColor(pieChartColors.get(i));
			int arcAngle = (pieChartElements.get(i) * 360) / pieChartSum ;
			System.out.println(arcAngle);
			g2D.fillArc(0, 0, 380, 380, lastAngle, arcAngle);
			lastAngle += arcAngle;

		}
	}

}
