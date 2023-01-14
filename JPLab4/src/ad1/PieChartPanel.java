package ad1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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
		this.setBackground(Color.white);
		this.setBorder(new LineBorder(Color.black, 1));
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

	public void removePieChartElement(int index) throws IndexOutOfBoundsException{
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
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		super.paint(g2D);
		g2D.setStroke(new BasicStroke(1));
		if(pieChartElements.size() == 0) {
			g2D.setColor(Color.black);
			g2D.drawOval(19, 10, 380, 380);
		}
		
		if(pieChartElements.size() == 1) {
			g2D.setColor(pieChartColors.get(0));
			g2D.fillOval(19, 10, 380, 380);
			g2D.setColor(Color.black);
			g2D.drawOval(19, 10, 380, 380);
			return;
		}
		
		double lastAngle = 0;
		for (int i = 0; i < pieChartElements.size(); i++) {
			g2D.setColor(pieChartColors.get(i));
			double arcAngle = (double)pieChartElements.get(i) / (double)pieChartSum * 360;
			g2D.fill(new Arc2D.Double(19, 10, 380, 380, lastAngle, arcAngle, Arc2D.PIE));
			g2D.setColor(Color.black);
			g2D.draw(new Arc2D.Double(19, 10, 380, 380, lastAngle, arcAngle, Arc2D.PIE));
			lastAngle += arcAngle;

		}
	}

}
