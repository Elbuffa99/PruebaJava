package gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.text.DecimalFormat;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class Vender extends JFrame implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox cboTipo;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JLabel lblNewLabel;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JButton btnVender;
	private JButton btnCerrar;

	int datoCombobox () {
		
		return cboTipo.getSelectedIndex();		
	}
	
	int datoCantidad () {
		
		return Integer.parseInt(txtCantidad.getText());
	}
	
	
	
	// Primer modelo Standar //

	public static String modelo0 = "Standar";
	public static double precio0 = 89.90;
	public static double alto0   = 20.0;
	public static double largo0  = 26.0;
	public static double peso0   = 250.0;
	public static int contenido0 = 4;

	// Primer modelo Queen-Standar //

	public static String modelo1 = "Queen-Standar";
	public static double precio1 = 99.90;
	public static double alto1   = 20.0;
	public static double largo1  = 30.0;
	public static double peso1   = 275.0;
	public static int contenido1 = 4;

	// Primer modelo King-Standar //

	public static String modelo2 = "King-Standar";
	public static double precio2 = 115.90;
	public static double alto2   = 20.0;
	public static double largo2  = 36.0;
	public static double peso2   = 300.0;
	public static int contenido2 = 5;

	// Primer modelo Europeo //

	public static String modelo3 = "Europeo";
	public static double precio3 = 99.99;
	public static double alto3   = 25.0;
	public static double largo3  = 25.0;
	public static double peso3  = 275.0;
	public static int contenido3 = 5;

	// Primer modelo Europeo-Eco//

	public static String modelo4 = "Europeo-Eco";
	public static double precio4 = 100.90;
	public static double alto4   = 15.0;
	public static double largo4  = 15.0;
	public static double peso4   = 200.0;
	public static int contenido4 = 7;

	// Porcentaje descuento //

	public static double porcentaje1 = 0.065;
	public static double porcentaje2 = 0.10;
	public static double porcentaje3 = 0.135;
	public static double porcentaje4 = 0.20;

	// Obsequio //

	public static String tipoObsequio = "Pantuflas";
	public static int obseCantidad1 = 10;
	public static int obseCantidad2 = 30;
	public static int obseCantidad3 = 40;

	//Cantidad optimas vendidas por día //

	public static int cantidadOptima = 10;

	//Cuota diaria //

	public static double cuotaDiaria = 3000;
	private JScrollPane scrollPane;
	private JTextArea txtResultado;
	
	//Contador//
	
	public static int contador;
	public static int chan;
	
	//Acumulador//
	
	public static double acumuladorFinal;
	
	
	double Precio (int x, int y) {
		double p=0;
		
		switch (x) {
		case 0:
			p = precio0 * y;
		break;
		case 1:
			p = precio1 * y;
		break;
		case 2:
			p = precio2 * y;
		break;
		case 3:
			p = precio3 * y;
		break;
		case 4:
			p = precio4 * y;
		break;
		}
		return p;
	}
	
	double descuento (int x, double y) {
		
		double d=0;
		if (x <= 5) {			
			d = porcentaje1 * y; 			
		}
		else if (x >= 6 && x <= 10) {			
			d = porcentaje2 * y; 			
		}
		else if (x >= 11 && x <= 15) {			
			d = porcentaje3 * y; 			
		}
		else if (x > 15) {		
			d = porcentaje4 * y;
		}	
		return d;
	}
	
	double preFinal (double x, double y) {
		
		double b = 0;
		b = x - y;
		return b;
	}
	
	int regaloPantuflas () {
		
		int r=0;			
		if (chan >= 5 && chan <= 10) {
			r = obseCantidad1;
		}
		else if (chan >= 11 && chan <= 20) {
			r = obseCantidad2;
		}
		else if (chan > 20) {
			r = obseCantidad3;
		}
		return r;	
	}
	

	double txtPrecio (int x) {
		
		double t=0;
		
		if (x==0) {
			t = precio0;
		}
		else if (x==1) {
			t = precio1;	
		}
		else if (x==2) {
			t = precio2;	
		}
		else if(x==3) {
			t = precio3;	
		}
		else if(x==4) {
			t = precio4;	
		}
		txtPrecio.setText(""+t);
		return t;	
	}
	
	
	
	void Reporte (int x) {
		
		double precio,desc,prefinal;
		int r,regalo;
		precio = Precio (datoCombobox (), datoCantidad ());
		desc = descuento (datoCombobox (), Precio (datoCombobox (),datoCantidad ()));
		prefinal = preFinal (Precio (datoCombobox (), datoCantidad ()), descuento (datoCombobox (), Precio (datoCombobox (),datoCantidad ())));
		
		r = datoCantidad ();
		
		
		// ACUMULADORES //
		chan+=r;
		contador++;
		DecimalFormat df = new DecimalFormat("#.00");
		acumuladorFinal += prefinal;
		regalo = regaloPantuflas ();
			
		switch (x) {
		case 0:
			txtResultado.setText("BOLETA DE VENTA"+"\n"+"\n");
			txtResultado.append("Modelo"+"\t"+"\t"+": "+modelo0+"\n");
			txtResultado.append("Precio"+"\t"+"\t"+": S/."+txtPrecio (datoCombobox ())+"\n");
			txtResultado.append("Cantidades adquiridas"+"\t"+": "+datoCantidad ()+"\n");
			txtResultado.append("Importe compra"+"\t"+"\t"+": S/."+precio +"\n");
			txtResultado.append("Importe descuento"+"\t"+": S/."+df.format(desc) +"\n");
			txtResultado.append("Importe pagar"+"\t"+"\t"+": S/."+prefinal +"\n");
			txtResultado.append("Importe acumulado"+"\t"+": S/."+df.format(acumuladorFinal) +"\n");
			txtResultado.append("Tipo de obsequio"+"\t"+": "+tipoObsequio+"\n");
			txtResultado.append("Unidades obsequiadas"+"\t"+": "+regalo+"\n");
		break;
		
		case 1:
			txtResultado.setText("BOLETA DE VENTA"+"\n"+"\n");
			txtResultado.append("Modelo"+"\t"+"\t"+": "+modelo1+"\n");
			txtResultado.append("Precio"+"\t"+"\t"+": S/."+txtPrecio (datoCombobox ())+"\n");
			txtResultado.append("Cantidades adquiridas"+"\t"+": "+datoCantidad ()+"\n");
			txtResultado.append("Importe compra"+"\t"+"\t"+": S/."+precio +"\n");
			txtResultado.append("Importe descuento"+"\t"+": S/."+df.format(desc) +"\n");
			txtResultado.append("Importe pagar"+"\t"+"\t"+": S/."+prefinal +"\n");
			txtResultado.append("Importe acumulado"+"\t"+": S/."+df.format(acumuladorFinal) +"\n");
			txtResultado.append("Tipo de obsequio"+"\t"+": "+tipoObsequio+"\n");
			txtResultado.append("Unidades obsequiadas"+"\t"+": "+regalo+"\n");
		break;
		
		case 2:
			txtResultado.setText("BOLETA DE VENTA"+"\n"+"\n");
			txtResultado.append("Modelo"+"\t"+"\t"+": "+modelo2+"\n");
			txtResultado.append("Precio"+"\t"+"\t"+": S/."+txtPrecio (datoCombobox ())+"\n");
			txtResultado.append("Cantidades adquiridas"+"\t"+": "+datoCantidad ()+"\n");
			txtResultado.append("Importe compra"+"\t"+"\t"+": S/."+precio +"\n");
			txtResultado.append("Importe descuento"+"\t"+": S/."+df.format(desc) +"\n");
			txtResultado.append("Importe pagar"+"\t"+"\t"+": S/."+prefinal +"\n");
			txtResultado.append("Importe acumulado"+"\t"+": S/."+df.format(acumuladorFinal) +"\n");
			txtResultado.append("Tipo de obsequio"+"\t"+": "+tipoObsequio+"\n");
			txtResultado.append("Unidades obsequiadas"+"\t"+": "+regalo+"\n");
		break;
		
		case 3:
			txtResultado.setText("BOLETA DE VENTA"+"\n"+"\n");
			txtResultado.append("Modelo"+"\t"+"\t"+": "+modelo3+"\n");
			txtResultado.append("Precio"+"\t"+"\t"+": S/."+txtPrecio (datoCombobox ())+"\n");
			txtResultado.append("Cantidades adquiridas"+"\t"+": "+datoCantidad ()+"\n");
			txtResultado.append("Importe compra"+"\t"+"\t"+": S/."+precio +"\n");
			txtResultado.append("Importe descuento"+"\t"+": S/."+df.format(desc) +"\n");
			txtResultado.append("Importe pagar"+"\t"+"\t"+": S/."+prefinal +"\n");
			txtResultado.append("Importe acumulado"+"\t"+": S/."+df.format(acumuladorFinal) +"\n");
			txtResultado.append("Tipo de obsequio"+"\t"+": "+tipoObsequio+"\n");
			txtResultado.append("Unidades obsequiadas"+"\t"+": "+regalo+"\n");
		break;
		
		case 4:
			txtResultado.setText("BOLETA DE VENTA"+"\n"+"\n");
			txtResultado.append("Modelo"+"\t"+"\t"+": "+modelo4+"\n");
			txtResultado.append("Precio"+"\t"+"\t"+": S/."+txtPrecio (datoCombobox ())+"\n");
			txtResultado.append("Cantidades adquiridas"+"\t"+": "+datoCantidad ()+"\n");
			txtResultado.append("Importe compra"+"\t"+"\t"+": S/."+precio +"\n");
			txtResultado.append("Importe descuento"+"\t"+": S/."+df.format(desc) +"\n");
			txtResultado.append("Importe pagar"+"\t"+"\t"+": S/."+prefinal +"\n");
			txtResultado.append("Importe acumulado"+"\t"+": S/."+df.format(acumuladorFinal) +"\n");
			txtResultado.append("Tipo de obsequio"+"\t"+": "+tipoObsequio+"\n");
			txtResultado.append("Unidades obsequiadas"+"\t"+": "+regalo+"\n");
		break;
		}		
		
				double c;		
				c = (acumuladorFinal*100)/cuotaDiaria;				
				
											
				if (contador%5==0 && contador > 0) 
				{			
					JOptionPane.showMessageDialog(null,"Numero de ventas "+contador+"\n" +"Importe total generado acumulado:  S/."+ df.format(acumuladorFinal)+  "\n"+  "Porcentaje de la cuota diaria: "+df.format(c)+"%");
					}			
	}			
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vender frame = new Vender();
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
	public Vender() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			cboTipo = new JComboBox();
			cboTipo.addItemListener(this);
			cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Standar", "Queen-Standar", "King-Standar", "Europeo", "Europeo-Eco"}));
			cboTipo.setBounds(150, 58, 192, 22);
			contentPane.add(cboTipo);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setBounds(150, 91, 192, 20);
			contentPane.add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setColumns(10);
			txtCantidad.setBounds(150, 122, 192, 20);
			contentPane.add(txtCantidad);
		}
		{
			lblNewLabel = new JLabel("Modelo");
			lblNewLabel.setBounds(42, 58, 58, 22);
			contentPane.add(lblNewLabel);
		}
		{
			lblPrecio = new JLabel("Precio (S/.)");
			lblPrecio.setBounds(42, 89, 98, 22);
			contentPane.add(lblPrecio);
		}
		{
			lblCantidad = new JLabel("Cantidad");
			lblCantidad.setBounds(42, 120, 58, 22);
			contentPane.add(lblCantidad);
		}
		{
			btnVender = new JButton("Vender");
			btnVender.addActionListener(this);
			btnVender.setBounds(498, 58, 89, 23);
			contentPane.add(btnVender);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(498, 90, 89, 23);
			contentPane.add(btnCerrar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(44, 171, 543, 156);
			contentPane.add(scrollPane);
			{
				txtResultado = new JTextArea();
				scrollPane.setViewportView(txtResultado);
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
	}
	protected void actionPerformedBtnVender(ActionEvent e) {	
		Reporte (datoCombobox ());
	
	}
	
	public JTextArea getTxtResultado() {
		return txtResultado;
}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		this.dispose();
		
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboTipo) {
			itemStateChangedCboTipo(e);
		}
	}
	protected void itemStateChangedCboTipo(ItemEvent e) {
		txtPrecio (datoCombobox ());
		
	}
}