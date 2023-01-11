package ad1;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AdOneFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList list;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdOneFrame frame = new AdOneFrame();
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
	public AdOneFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 700);
		contentPane = new AdOneContentPane();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new PieChartPanel();
		panel.setBounds(40, 40, 418, 400);
		
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(518, 40, 104, 399);
		contentPane.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.PLAIN, 27));
		list.setBackground(new Color(255, 255, 255));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"10", "20", "30"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		textField = new JTextField();
		textField.setBounds(518, 456, 104, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Edytuj");
		btnNewButton.setBounds(353, 456, 104, 41);
		contentPane.add(btnNewButton);
		
		JButton btnUsu = new JButton("Usu\u0144");
		btnUsu.setBounds(200, 456, 104, 41);
		contentPane.add(btnUsu);
		
		JButton btnNewButton_1_1 = new JButton("Dodaj");
		btnNewButton_1_1.setBounds(40, 456, 104, 41);
		contentPane.add(btnNewButton_1_1);
	}
}
