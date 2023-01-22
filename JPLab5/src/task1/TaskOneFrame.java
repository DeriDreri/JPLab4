package task1;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TaskOneFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	// a3, a2, a1, b3, b2, b1, c3, c2, c1, c0
	private JTextField[] equationElementsFields;
	private JTextField operationField;
	private TextField solutionField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskOneFrame frame = new TaskOneFrame();
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
	public TaskOneFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		equationElementsFields = new JTextField[10];

		equationElementsFields[0] = new JTextField();
		equationElementsFields[0].setBounds(260, 11, 70, 40);
		equationElementsFields[0].setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(equationElementsFields[0]);
		equationElementsFields[0].setColumns(10);

		equationElementsFields[1] = new JTextField();
		equationElementsFields[1].setColumns(10);
		equationElementsFields[1].setBounds(180, 11, 70, 40);
		contentPane.add(equationElementsFields[1]);

		equationElementsFields[2] = new JTextField();
		equationElementsFields[2].setColumns(10);
		equationElementsFields[2].setBounds(100, 11, 70, 40);
		contentPane.add(equationElementsFields[2]);

		equationElementsFields[5] = new JTextField();
		equationElementsFields[5].setColumns(10);
		equationElementsFields[5].setBounds(100, 62, 70, 40);
		contentPane.add(equationElementsFields[5]);

		equationElementsFields[4] = new JTextField();
		equationElementsFields[4].setColumns(10);
		equationElementsFields[4].setBounds(180, 62, 70, 40);
		contentPane.add(equationElementsFields[4]);

		equationElementsFields[3] = new JTextField();
		equationElementsFields[3].setColumns(10);
		equationElementsFields[3].setBounds(260, 62, 70, 40);
		contentPane.add(equationElementsFields[3]);

		equationElementsFields[8] = new JTextField();
		equationElementsFields[8].setColumns(10);
		equationElementsFields[8].setBounds(100, 120, 70, 40);
		contentPane.add(equationElementsFields[8]);

		equationElementsFields[7] = new JTextField();
		equationElementsFields[7].setColumns(10);
		equationElementsFields[7].setBounds(180, 120, 70, 40);
		contentPane.add(equationElementsFields[7]);

		equationElementsFields[6] = new JTextField();
		equationElementsFields[6].setColumns(10);
		equationElementsFields[6].setBounds(260, 120, 70, 40);
		contentPane.add(equationElementsFields[6]);

		equationElementsFields[9] = new JTextField();
		equationElementsFields[9].setColumns(10);
		equationElementsFields[9].setBounds(20, 120, 70, 40);
		contentPane.add(equationElementsFields[9]);

		for (JTextField equationElementField : equationElementsFields) {
			equationElementField.setHorizontalAlignment(SwingConstants.CENTER);
			equationElementField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}

		operationField = new JTextField();
		operationField.setColumns(10);
		operationField.setBounds(20, 62, 70, 40);
		contentPane.add(operationField);

		Button solutionButton = new Button("Rozwi\u0105\u017C");
		solutionButton.setActionCommand("button");
		solutionButton.setBounds(20, 166, 310, 22);
		solutionButton.addActionListener(this);
		contentPane.add(solutionButton);

		solutionField = new TextField();
		solutionField.setEditable(false);
		solutionField.setBounds(20, 194, 310, 73);
		contentPane.add(solutionField);
	}

	private Variable[] generateVariablesTable() {
		Variable[] toReturn = new Variable[equationElementsFields.length];
		for (int i = 0; i < equationElementsFields.length; i++) {

			String text = equationElementsFields[i].getText();

			if (text.isEmpty()) {
				toReturn[i] = new Variable(0);
				continue;
			}
			try {
				int value = Integer.parseInt(text);
				toReturn[i] = new Variable(value);
			} catch (NumberFormatException e) {
				var potentialNewVariable = new Variable(text.charAt(0));

				int detected = -1;
				for (int j = 0; j < toReturn.length; j++) {
					if (toReturn[j] == null) continue;
					if (toReturn[j].getName() == potentialNewVariable.getName()) {
						detected = j;
						break;
					}
				}
				if (detected > -1) {
					toReturn[i] = toReturn[detected];
					continue;
				}
				toReturn[i] = potentialNewVariable;
			}
		}
		return toReturn;
	}

	private String buildSolutionString() {
		StringBuilder textBuilder = new StringBuilder("");
		for (int i = 0; i < 3; i++) {
			textBuilder.append("a" + (i + 1) + " = " + equationElementsFields[i].getText() + ", ");
		}
		textBuilder.append("\n");
		for (int i = 0; i < 3; i++) {
			textBuilder.append("b" + (i + 1) + " = " + equationElementsFields[3 + i].getText() + ",");
		}
		textBuilder.append("\n");
		for (int i = 0; i < 4; i++) {
			textBuilder.append("c" + (i + 1) + " = " + equationElementsFields[6 + i].getText() + ",");
		}
		return textBuilder.toString();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		var solver = new EquationSolver(generateVariablesTable());
		/*
		 * solver.printElements(); System.out.println("---");
		 * solver.printIteratableElements(); System.out.println("---");
		 * solver.printElements(); System.out.println("-------------");
		 */
		//solutionField.setText(buildSolutionString());
	}
}
