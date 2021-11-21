package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

public class Form04ClienteMes extends JDialog {

	private final JPanel contentPanel = new JPanel();

	Controlador controlador;



	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public static void main(String[] args) {
		try {
			Form04ClienteMes dialog = new Form04ClienteMes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Form04ClienteMes() {
		setTitle("ClienteMes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new OkButtonActionListener());
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new BtnCancelActionListener());
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}
	
	
	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class BtnCancelActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			controlador.mostrarF01Inicial();
		}
	}

}
