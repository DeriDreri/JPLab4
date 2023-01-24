package task2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TaskTwoFrame extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	JButton cButton;
	JButton ceButton;
	JButton dmButton;
	JButton addButton;
	JButton subButton;
	JButton divButton;
	JButton resButton;
	JButton abcButton;
	JButton defButton;
	JButton ghiButton;
	JButton jklButton;
	JButton mnoButton;
	JButton pqrButton;
	JButton stuvButton;
	JButton wxyzButton;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskTwoFrame frame = new TaskTwoFrame();
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
	public TaskTwoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(5, 5, 310, 60);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		cButton = new JButton("C");
		cButton.setBounds(85, 70, 70, 60);
		cButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		cButton.addActionListener(this);
		contentPane.add(cButton);
		
		ceButton = new JButton("CE");
		ceButton.setBounds(165, 70, 70, 60);
		ceButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		ceButton.addActionListener(this);
		contentPane.add(ceButton);
		
		
		addButton = new JButton("+");
		addButton.setBounds(245, 70, 70, 60);
		addButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		addButton.addActionListener(this);
		contentPane.add(addButton);
		
		abcButton = new JButton("abc");
		abcButton.setBounds(5, 141, 70, 60);
		abcButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		abcButton.addActionListener(this);
		contentPane.add(abcButton);
		
		defButton = new JButton("def");
		defButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		defButton.addActionListener(this);
		defButton.setBounds(85, 141, 70, 60);
		contentPane.add(defButton);
		
		ghiButton = new JButton("ghi");
		ghiButton.setBounds(165, 141, 70, 60);
		ghiButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		ghiButton.addActionListener(this);
		contentPane.add(ghiButton);
		
		subButton = new JButton("-");
		subButton.setBounds(245, 141, 70, 60);
		subButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		subButton.addActionListener(this);
		contentPane.add(subButton);
		
		jklButton = new JButton("jkl");
		jklButton.setBounds(5, 212, 70, 60);
		jklButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		jklButton.addActionListener(this);
		contentPane.add(jklButton);
		
		mnoButton = new JButton("mno");
		mnoButton.setBounds(85, 212, 70, 60);
		mnoButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		mnoButton.addActionListener(this);
		contentPane.add(mnoButton);
		
		pqrButton = new JButton("pqr");
		pqrButton.setBounds(165, 212, 70, 60);
		pqrButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		pqrButton.addActionListener(this);
		contentPane.add(pqrButton);
		
		divButton = new JButton("/");
		divButton.setBounds(245, 212, 70, 60);
		divButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		divButton.addActionListener(this);
		contentPane.add(divButton);
		
		dmButton = new JButton("D/M");
		dmButton.setBounds(5, 70, 70, 60);
		dmButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		dmButton.addActionListener(this);
		contentPane.add(dmButton);
		
		stuvButton = new JButton("stuv");
		stuvButton.setBounds(5, 283, 108, 60);
		stuvButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		stuvButton.addActionListener(this);
		contentPane.add(stuvButton);
		
		wxyzButton = new JButton("wxyz");
		wxyzButton.setBounds(123, 283, 108, 60);
		wxyzButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		wxyzButton.addActionListener(this);
		contentPane.add(wxyzButton);
		
		resButton = new JButton("=");
		resButton.setBounds(245, 283, 70, 60);
		resButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		resButton.addActionListener(this);
		contentPane.add(resButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getSource().hashCode()) {
		
		
			default:
				return;
		}
		
	}
}
