package Ventanas;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BD.BDprueba2;
import Elementos.Admin;
import Elementos.Cliente;


public class listadoAdmin extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;





	public static void main(String[] args) {
		listadoAdmin vLA = new listadoAdmin(); 
		vLA.mostrar();
		vLA.setVisible(true);
	}

	JButton bVolver, bBorrar; 
	JTable tablaAdmin; 
	JPanel pBotonera, pPrincipal; 
	JTableHeader header; 
	DefaultTableModel modelo;
	Object valor; 
	





	public listadoAdmin() {
		setSize(600,400);
		setLocation(300, 200);

		setTitle("Listado Admin");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );

		pBotonera = new JPanel(); 

		bVolver = new JButton("volver"); 
		bBorrar = new JButton("Borrar fila"); 

		pBotonera.add(bVolver); 
		pBotonera.add(bBorrar); 

		pPrincipal = new JPanel(); 
		
	
		tablaAdmin = new JTable(modelo);

		pPrincipal.add(new JScrollPane(tablaAdmin));

		
		



		getContentPane().add(pPrincipal, BorderLayout.CENTER);
		getContentPane().add(pBotonera, BorderLayout.SOUTH); 


		tablaAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (e.getClickCount()>=2) {
					int fila = tablaAdmin.rowAtPoint( e.getPoint() );
					int col = tablaAdmin.rowAtPoint(e.getPoint());
					valor = tablaAdmin.getValueAt( fila, col );
					

				
				}
			
			}
		});
		
		
		bVolver.addActionListener((ActionEvent e ) -> {volver(); });


	}


	public void volver() {

		setVisible(false);
		FuncionesAdmin.main(null); 
		dispose();
	}				

	
	
	
	

	
	

	private void mostrar() {

		
		String column_names[]= {"DNI", "Nombre", "Apellido","Correo"};
		
		modelo = new DefaultTableModel(column_names,0);


		Connection conn = BDprueba2.initBD("Cine2.db");
		String SQL = ""; 
		try {
			Statement stat = conn.createStatement();
			SQL = "select DNI,nombre,apellido,correo from admin "; 



			ResultSet rs = stat.executeQuery( SQL );
			while(rs.next()) {
				
				modelo.addRow(new Object[] {rs.getString("DNI"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo")});

			}
			
			tablaAdmin.setModel(modelo);
			
		}catch(Exception e){
			System.out.println(e);

		}

	}
}
