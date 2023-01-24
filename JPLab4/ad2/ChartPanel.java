package ad2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ChartPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final int PANEL_WIDTH = 652;
	private final int PANEL_HEIGHT = 365;
	private final Color[] colors = { Color.RED, Color.BLACK, Color.BLUE, Color.CYAN, Color.YELLOW, Color.ORANGE,
			Color.MAGENTA, Color.PINK, Color.GREEN, Color.GRAY };
	private Set<Integer> selectedBoxes;
	private int[] valuesOfCharts;

	public ChartPanel() {
		this.setBackground(new Color(255, 255, 255));
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setBounds(10, 11, PANEL_WIDTH, PANEL_HEIGHT);
		selectedBoxes = new TreeSet<Integer>();
		valuesOfCharts = new int[10];
	}

	public void changeChartValue(int index, int value) {
		valuesOfCharts[index] = value;
	}

	private int getMaximumValueOfChars() {
		int max = 0;
		for (int i : selectedBoxes) {
			if (valuesOfCharts[i] > max)
				max = valuesOfCharts[i];
		}
		return max;
	}

	public void addSelection(int i) {
		selectedBoxes.add(i);
	}

	public void removeSelection(int i) {
		selectedBoxes.remove(i);
	}

	@Override
	public void paint(Graphics g) {
		var graphics2D = (Graphics2D) g;
		super.paint(g);
		int step = PANEL_WIDTH / (selectedBoxes.size() + 1);
		double pixelsHeightToValueMultiplayer = 1;
		int graphsWidth = (PANEL_WIDTH - 20 * selectedBoxes.size() + 2) / (selectedBoxes.size() + 1);
		int maxValueInChart = getMaximumValueOfChars();
		double maxValueRangeToPanelHightRatio = ((maxValueInChart - 1) / PANEL_HEIGHT) + 1;
		if (maxValueInChart > 0)
			pixelsHeightToValueMultiplayer = ((PANEL_HEIGHT - 1) * maxValueRangeToPanelHightRatio) / maxValueInChart;
		int i = 1;

		for (int numberOfGraph : selectedBoxes) {
			graphics2D.setColor(colors[numberOfGraph]);
			int chartHeight = (int) ((pixelsHeightToValueMultiplayer * valuesOfCharts[numberOfGraph])
					/ maxValueRangeToPanelHightRatio + 1);
			graphics2D.fillRect(i * step - (graphsWidth / 2), PANEL_HEIGHT - 1, graphsWidth, (-1) * chartHeight + 1);
			i++;
		}

	}
}
