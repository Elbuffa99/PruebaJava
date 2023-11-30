package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class GenerarReportes extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("New label");
	private JComboBox btn;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton btnCerrar;
	private JLabel label;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	
	
	
	
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarReportes frame = new GenerarReportes();
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
	public GenerarReportes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(44, -26, 98, 31);
		contentPane.add(lblNewLabel);
		{
			btn = new JComboBox();
			btn.setBounds(123, 28, 206, 22);
			contentPane.add(btn);
		}
		{
			textField = new JTextField();
			textField.setForeground(new Color(0, 0, 0));
			textField.setEditable(false);
			textField.setBounds(123, 61, 206, 20);
			contentPane.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(123, 92, 206, 20);
			contentPane.add(textField_1);
		}
		{
			btnNewButton = new JButton("Vender");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(398, 28, 89, 23);
			contentPane.add(btnNewButton);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.setBounds(398, 60, 89, 23);
			contentPane.add(btnCerrar);
		}
		{
			label = new JLabel("New label");
			label.setBounds(23, 32, 17, 0);
			contentPane.add(label);
		}
		{
			lblNewLabel_1 = new JLabel("Modelo");
			lblNewLabel_1.setBounds(33, 32, 80, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Precio");
			lblNewLabel_2.setBounds(33, 64, 62, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Cantidad");
			lblNewLabel_3.setBounds(33, 95, 80, 14);
			contentPane.add(lblNewLabel_3);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		
		
		
		
	}
}
