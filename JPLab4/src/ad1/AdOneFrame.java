package ad1;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.*;

public class AdOneFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList list;
	private DefaultListModel model;
	private JTextField textField;
	private JButton[] buttons;

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
		model = new DefaultListModel();
		list.setModel(model);
		
		textField = new JTextField();
		textField.setBounds(518, 456, 104, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		buttons = new JButton[3];
		buttons[0] = new JButton("Edytuj");
		buttons[0].setBounds(353, 456, 104, 41);
		buttons[0].addActionListener(this);
		contentPane.add(buttons[0]);
		
		buttons[1] = new JButton("Usu\u0144");
		buttons[1].setBounds(200, 456, 104, 41);
		buttons[1].addActionListener(this);
		contentPane.add(buttons[1]);
		
		buttons[2] = new JButton("Dodaj");
		buttons[2].setBounds(40, 456, 104, 41);
		buttons[2].addActionListener(this);
		contentPane.add(buttons[2]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttons[2]) {
			model.addElement(textField.getText());
		}
	}
}
