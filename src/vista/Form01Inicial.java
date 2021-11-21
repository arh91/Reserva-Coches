package vista;

import javax.swing.JFrame;

import controlador.Controlador;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class Form01Inicial extends JFrame implements ActionListener {

	JButton btnNuevaReserva;
	JButton btnListadoReservas;
	JButton btnClientes;
	JButton btnSalir;
	
	Controlador controlador;
	

	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	

	public Form01Inicial() {
        getContentPane().setLayout(null);
        
        btnSalir=new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        btnSalir.setBounds(280,126,116,25);
        getContentPane().add(btnSalir);
        
        
        btnClientes = new JButton("Clientes");
        btnClientes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
    			controlador.mostrarF05Clientes();
        	}
        });
        btnClientes.setBounds(74, 126, 116, 25);
        getContentPane().add(btnClientes);
        
        
        btnListadoReservas = new JButton("Listado Reservas");
        btnListadoReservas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
    			controlador.mostrarF03ListadoReservas();
        	}
        });
        btnListadoReservas.setBounds(277, 51, 116, 25);
        getContentPane().add(btnListadoReservas);
        
        
        btnNuevaReserva = new JButton("Nueva Reserva");
        btnNuevaReserva.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
    			controlador.mostrarF02NuevaReserva();
        	}
        });
        btnNuevaReserva.setBounds(74, 51, 116, 25);
        getContentPane().add(btnNuevaReserva);
        
        }
    
	
    public static void main(String[] args) {
        Form01Inicial frame=new Form01Inicial();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        frame.setSize(width/2, height/2);		
        frame.pack();
        //frame.setLocationRelativeTo(null);	
        //frame.setSize(500, 500);
        //frame.setBounds(30,30,450,350);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
