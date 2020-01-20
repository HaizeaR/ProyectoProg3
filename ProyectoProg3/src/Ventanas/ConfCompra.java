package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

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
	private JButton btnCompra;

	public ConfCompra() {
		setSize(600, 400);
		setLocation(300, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SalaYAsientos2.getAsientosSeleccionados();
		getDNICliente();
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setLayout(new GridLayout(1,1));
		add(panelPrincipal, BorderLayout.CENTER);
		btnCompra = new JButton("Ticket");
		btnCompra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Document document = new Document();
					try {
						String pdf = "ticket.pdf";
						PdfWriter.getInstance(document, new FileOutputStream(new File(pdf)));
					}catch(FileNotFoundException e2) {
						e2.printStackTrace();
					}
					document.open();
					document.addTitle("Ticket");
					document.addKeywords("Java, PDF,iText");
					
					Chunk chunk = new Chunk("Ticket");
					Chapter chapter = new Chapter(new Paragraph(chunk), 1);
					chapter.setNumberDepth(0);
					chapter.add(new Paragraph(""));
					chapter.add(new Paragraph("Titulo: " + SalaYAsientos2.pelicula));
					chapter.add(new Paragraph("Sala: " + SalaYAsientos2.id_sala));
					chapter.add(new Paragraph("Asiento: " + SalaYAsientos2.codigoAS));
					chapter.add(new Paragraph("Fecha: " + SalaYAsientos2.fecha));
					chapter.add(new Paragraph("Hora: " + SalaYAsientos2.horaI));
					
					document.add(chapter);
					document.close();
					
					
					
				}catch(DocumentException e3) {
					e3.printStackTrace();
				}
				
			}
		});
		panelPrincipal.add(btnCompra);
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
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void compra() {
		//int iD_compra = 2;
		System.out.println("Entramos a compra");
		System.out.println("Compras realizadas: ");

		for (Asiento asiento : SalaYAsientos2.codigoAS) {
			Compra c = new Compra( asiento.getCodigo(), Integer.parseInt(SalaYAsientos2.codS), DNI);
			System.out.println(c.toString());
			BDprueba2.insertCompra(c);
			//iD_compra++;
			

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