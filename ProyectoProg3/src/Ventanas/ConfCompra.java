package Ventanas;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import BD.BDprueba2;
import Elementos.Asiento;
import Elementos.Compra;

/**
 * Ventana donde se muestran los datos del ticket una vez confirmada la compra
 * 
 * @author Unai, Mireya y Haizea
 *
 */
public class ConfCompra extends JFrame {

	final static ArrayList<Asiento> codigoAS = new ArrayList<Asiento>();
	static String DNI;

	public ConfCompra() {
		setSize(600, 400);
		setLocation(300, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SalaYAsientos2.getAsientosSeleccionados();
		getDNICliente();

		compra();
		cambiaBD();

	}

	public static void getDNICliente() {
		Connection con = BDprueba2.initBD("Cine2.db");
		try {
			Statement stmt = con.createStatement();
			String sentSQL = "SELECT * FROM cliente where correo = '" + LogIn.correoCliente + "'";
			ResultSet rs = stmt.executeQuery(sentSQL);

			while (rs.next()) {
				String Dni = rs.getString("dni");
				DNI = Dni;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void compra() {
		int iD_compra = 1;
		System.out.println("Entramos a compra");
		System.out.println("Compras realizadas: ");

		for (Asiento asiento : SalaYAsientos2.codigoAS) {
			Compra c = new Compra(iD_compra, asiento.getCodigo(), Integer.parseInt(SalaYAsientos2.codS), DNI);
			System.out.println(c.toString());
			BDprueba2.insertCompra(c);
			iD_compra++;
			

		}
	}

	public static void cambiaBD() {
		System.out.println("Update Asiento");
		for (Asiento a : codigoAS) {
			BDprueba2.updateAsiento(a);

		}
	}

	public static void main(String[] args) {
		ConfCompra vc = new ConfCompra();
		vc.setVisible(true);
	}

}