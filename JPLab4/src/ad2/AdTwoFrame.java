package ad2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class AdTwoFrame extends JFrame implements ItemListener, DocumentListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GroupedTextField[] textFields;
	private GroupedSelectBox[] checkBoxes;
	private ChartPanel chartPanel;
	private final Color[] colors = { Color.RED, Color.BLACK, Color.BLUE, Color.CYAN, Color.YELLOW, Color.ORANGE, Color.MAGENTA,
			Color.PINK, Color.GREEN, Color.GRAY };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdTwoFrame frame = new AdTwoFrame();
					frame.setVisible(true);
					JOptionPane.showMessageDialog(frame, "Zasiêg wartoœci dla s³upków w przedziale [0, 80080] (ograniczona liczba pikseli).\nDozwolone jedynie liczby naturalne", "Wprowadzenie", JOptionPane.PLAIN_MESSAGE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdTwoFrame() {
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		chartPanel = new ChartPanel();
		contentPane.add(chartPanel);

		textFields = new GroupedTextField[10];
		checkBoxes = new GroupedSelectBox[10];

		for (int i = 0; i < 10; i++) {
			textFields[i] = new GroupedTextField(i);
			textFields[i].setBounds(10 + i * 67, 416, 49, 29);
			textFields[i].getDocument().addDocumentListener(this);
			contentPane.add(textFields[i]);
			textFields[i].setColumns(10);

			checkBoxes[i] = new GroupedSelectBox("", i);
			checkBoxes[i].setBackground(colors[i]);
			checkBoxes[i].setHorizontalAlignment(SwingConstants.CENTER);
			checkBoxes[i].setBounds(10 + i * 67, 383, 49, 26);
			checkBoxes[i].addItemListener(this);
			contentPane.add(checkBoxes[i]);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		GroupedSelectBox box = (GroupedSelectBox) e.getSource();
		if (e.getStateChange() == 1)
			chartPanel.addSelection(box.getNumber());
		else
			chartPanel.removeSelection(box.getNumber());
		chartPanel.repaint();
	}

	
	private void updateChart() {
		for (GroupedTextField i : textFields) {
			try {
				int newValue = Integer.parseInt(i.getText());
				if (newValue < 0 || newValue > 80080) throw new NumberFormatException();
				chartPanel.changeChartValue(i.getNumber(), Integer.parseInt(i.getText()));
				i.setForeground(Color.BLACK);
			} catch (NumberFormatException exception) {
				chartPanel.changeChartValue(i.getNumber(), 0);
				i.setForeground(Color.RED);
			}
		}
		chartPanel.repaint();
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		updateChart();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		updateChart();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		updateChart();
	}

}
