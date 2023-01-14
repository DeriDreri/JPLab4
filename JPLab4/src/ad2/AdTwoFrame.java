package ad2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AdTwoFrame extends JFrame implements ActionListener{


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField[] textFields;
	private JCheckBox[] checkBoxes;
	private ChartPanel chartPanel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdTwoFrame frame = new AdTwoFrame();
					frame.setVisible(true);
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
		setBounds(100, 100, 687, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		chartPanel = new ChartPanel();
		contentPane.add(chartPanel);

		textFields = new JTextField[10];
		checkBoxes = new JCheckBox[10];

		textFields[0] = new JTextField();
		textFields[0].setBounds(10, 316, 49, 29);
		contentPane.add(textFields[0]);
		textFields[0].setColumns(10);

		checkBoxes[0] = new JCheckBox("");
		checkBoxes[0].setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxes[0].setBounds(10, 283, 49, 26);
		contentPane.add(checkBoxes[0]);

		textFields[1] = new JTextField();
		textFields[1].setColumns(10);
		textFields[1].setBounds(77, 316, 49, 29);
		contentPane.add(textFields[1]);

		checkBoxes[1] = new JCheckBox("");
		checkBoxes[1].setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxes[1].setBounds(77, 283, 49, 26);
		contentPane.add(checkBoxes[1]);

		textFields[2] = new JTextField();
		textFields[2].setColumns(10);
		textFields[2].setBounds(144, 316, 49, 29);
		contentPane.add(textFields[2]);

		checkBoxes[2] = new JCheckBox("");
		checkBoxes[2].setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxes[2].setBounds(144, 283, 49, 26);
		contentPane.add(checkBoxes[2]);

		textFields[3] = new JTextField();
		textFields[3].setColumns(10);
		textFields[3].setBounds(211, 316, 49, 29);
		contentPane.add(textFields[3]);

		checkBoxes[3] = new JCheckBox("");
		checkBoxes[3].setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxes[3].setBounds(211, 283, 49, 26);
		contentPane.add(checkBoxes[3]);

		textFields[4] = new JTextField();
		textFields[4].setColumns(10);
		textFields[4].setBounds(278, 316, 49, 29);
		contentPane.add(textFields[4]);

		checkBoxes[4] = new JCheckBox("");
		checkBoxes[4].setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxes[4].setBounds(278, 283, 49, 26);
		contentPane.add(checkBoxes[4]);

		textFields[5] = new JTextField();
		textFields[5].setColumns(10);
		textFields[5].setBounds(345, 316, 49, 29);
		contentPane.add(textFields[5]);

		checkBoxes[5] = new JCheckBox("");
		checkBoxes[5].setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxes[5].setBounds(345, 283, 49, 26);
		contentPane.add(checkBoxes[5]);

		textFields[9] = new JTextField();
		textFields[9].setColumns(10);
		textFields[9].setBounds(613, 316, 49, 29);
		contentPane.add(textFields[9]);

		textFields[8] = new JTextField();
		textFields[8].setColumns(10);
		textFields[8].setBounds(546, 316, 49, 29);
		contentPane.add(textFields[8]);

		textFields[7] = new JTextField();
		textFields[7].setColumns(10);
		textFields[7].setBounds(479, 316, 49, 29);
		contentPane.add(textFields[7]);

		textFields[6] = new JTextField();
		textFields[6].setColumns(10);
		textFields[6].setBounds(412, 316, 49, 29);
		contentPane.add(textFields[6]);

		checkBoxes[6] = new JCheckBox("");
		checkBoxes[6].setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxes[6].setBounds(412, 283, 49, 26);
		contentPane.add(checkBoxes[6]);

		checkBoxes[7] = new JCheckBox("");
		checkBoxes[7].setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxes[7].setBounds(479, 283, 49, 26);
		contentPane.add(checkBoxes[7]);

		checkBoxes[8] = new JCheckBox("");
		checkBoxes[8].setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxes[8].setBounds(546, 283, 49, 26);
		contentPane.add(checkBoxes[8]);

		checkBoxes[9] = new JCheckBox("");
		checkBoxes[9].setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxes[9].setBounds(613, 283, 49, 26);
		contentPane.add(checkBoxes[9]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
