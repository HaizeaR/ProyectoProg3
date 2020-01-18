package Ventanas;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import Elementos.Tabla;
import Elementos.TablaHorario;

/** Clase de ventana para muestra de datos de tabla en una JTable integrada. Necesita una instancia de la clase Tabla que tiene los datos que se visualizarán<br/>
 * Hereda de JInternalFrame, de modo que debe incluirse en una ventana que esté preparada para ventanas internas
 * (Clase asociada preparada: VentanaGeneral)
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
@SuppressWarnings("serial")
public class VentanaTabla extends JInternalFrame {

	/** Interfaz para gestionar eventos en las celdas de la JTable
	 * @author andoni.eguiluz @ ingenieria.deusto.es
	 */
	public static interface EventoEnCelda {
		/** Evento que se lanzará al actuar sobre la celda
		 * @param vTabla	Ventana de tabla de datos
		 * @param fila	Fila de la celda
		 * @param columna	Columna de la celda
		 */
		public void evento( VentanaTabla vTabla, int fila, int columna );
	}

	private JTable tDatos;    // JTable de datos de la ventana
	private Tabla tablaDatos; // Tabla de datos de la ventana
	private JScrollPane spDatos; // Scrollpane de la jtable
	private JLabel lMensaje;  // Label de mensaje
	private JPanel pBotonera; // Panel de botones


	private EventoEnCelda dobleClick;
	private EventoEnCelda dobleClickHeader;
	private  EventoEnCelda enter;
	// t5
	private JInternalFrame internal ;
	private PeliculaIndividual ventMadre; 



	/** Añade un botón a la ventana
	 * @param texto	Texto del botón
	 * @param runnable	Objeto runnable con código a ejecutar (run()) cuando el botón se pulse
	 */
	public void addBoton( String texto, Runnable runnable ) {
		JButton b = new JButton( texto );
		pBotonera.add( b );
		b.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				runnable.run();
			}
		});
	}

	
	/** Devuelve la JTable asociada a esta ventana
	 * @return	Objeto de tabla visual
	 */
	public JTable getJTable() { return tDatos; }

	
	/** Crea una nueva ventana de tabla
	 * @param ventMadre	Ventana principal en la que se incluirá
	 * @param titulo	Título de la ventana
	 * @param horizontalScroll	true si se quiere que la tabla se adapte al panel de scroll
	 */
	public VentanaTabla( PeliculaIndividual ventMadre, String titulo, boolean... horizontalScroll ) {
		super( titulo, true, true, true, true ); //  resizable, closable, maximizable, iconifiable
		this.ventMadre = ventMadre;
		// Configuración general
		setTitle( titulo );
		setSize( 800, 600 ); // Tamaño por defecto
		setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
		// Creación de componentes y contenedores




		pBotonera = new JPanel();
		tDatos = new JTable() {
			// Para tooltips de headers
			protected JTableHeader createDefaultTableHeader() {
				return new JTableHeader(columnModel) {
					public String getToolTipText(MouseEvent e) {
						java.awt.Point p = e.getPoint();
						int index = columnModel.getColumnIndexAtX(p.x);
						if (index<0 || index>=columnModel.getColumnCount()) return null;
						int realIndex = columnModel.getColumn(index).getModelIndex();
						return columnModel.getColumn(realIndex).getHeaderValue().toString();
					}
				};
			}
			// Para tooltips de celdas
			@Override
			public String getToolTipText(MouseEvent e) {
				String tip = null;
				try {
					java.awt.Point p = e.getPoint();
					int rowIndex = rowAtPoint(p);
					int colIndex = columnAtPoint(p);
					int realColumnIndex = convertColumnIndexToModel(colIndex);  // Real column in model, not in view
					Object o = getValueAt( rowIndex, realColumnIndex );
					if (o==null) {
						tip = "NULO";
					} else if (o instanceof String) {  // Tip for strings
						tip = (String) o;
						// } else { tip = super.getToolTipText(e);
					} else if (o instanceof Integer) {
						tip = o.toString();
					} else {
						tip = o.toString();
					}
					// if (tip.length() < 5) tip = "";   // If string too short, don't make tip
				} catch (Exception e2) {
					tip = "";
				}
				return tip;
			}
		};
		tDatos.setShowGrid( true );
		tDatos.setGridColor( Color.LIGHT_GRAY );
		tDatos.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		lMensaje = new JLabel( " " );
		// Asignación de componentes
		if (horizontalScroll.length>0 && horizontalScroll[0]) {
			spDatos = new JScrollPane( tDatos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
			tDatos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		} else {
			spDatos = new JScrollPane( tDatos );
		}
		getContentPane().add( spDatos, BorderLayout.CENTER );
		getContentPane().add( pBotonera, BorderLayout.SOUTH );
		getContentPane().add( lMensaje, BorderLayout.NORTH );
		



		tDatos.getTableHeader().addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()>=2) {
					int columna = tDatos.columnAtPoint( e.getPoint() );
					if (dobleClickHeader!=null) dobleClickHeader.evento( VentanaTabla.this, -1, columna );
				}
			}

		});
		tDatos.getTableHeader().addMouseMotionListener( new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int columna = tDatos.columnAtPoint( e.getPoint() );
				if (columna>=0) {
					Object valor = tDatos.getTableHeader().getColumnModel().getColumn(columna).getHeaderValue().toString();
				}
			}
		});
		tDatos.addKeyListener( new KeyAdapter() {
			boolean ctrlPulsado = false;
			boolean ultimaBusquedaEnCol = false; // Indica si la última búsqueda ha sido en columna (true) o en tabla (false)
			String ultimaBusqueda = ""; // Texto de la última búsqueda
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (enter!=null && tDatos!=null) {
						enter.evento( VentanaTabla.this, tDatos.getSelectedRow(), tDatos.getSelectedColumn() );
						e.consume();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_CONTROL ) {
					ctrlPulsado = true;
				} else if (e.getKeyCode() == KeyEvent.VK_F && ctrlPulsado) {  // Ctrl+B = Buscar en la columna actual
					ultimaBusqueda = JOptionPane.showInputDialog( VentanaTabla.this, "Texto a buscar en la columna actual:", ultimaBusqueda );
					ultimaBusquedaEnCol = true;
					hacerBusqueda();
				} else if (e.getKeyCode() == KeyEvent.VK_B && ctrlPulsado) {  // Ctrl+F = Buscar en toda la tabla (primero hacia abajo luego hacia la derecha)
					ultimaBusqueda = JOptionPane.showInputDialog( VentanaTabla.this, "Texto a buscar en la tabla desde la posición actual:", ultimaBusqueda );
					ultimaBusquedaEnCol = false;
					hacerBusqueda();
				} else if (e.getKeyCode() == KeyEvent.VK_K && ctrlPulsado) {  // Ctrl+K = Buscar de nuevo (repetir la última búsqueda)
					hacerBusqueda();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL ) {
					ctrlPulsado = false;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
					if (ctrlPulsado) {
						// Buscar siguiente dato vacío de la columna actual
						int colActual = tDatos.getSelectedColumn();
						int row = tDatos.getSelectedRow();
						if (colActual!=-1 && row>=0) {
							row++;
							while (row<tDatos.getModel().getRowCount()) {
								if (tDatos.getValueAt( row, colActual ).toString().isEmpty()) {
									hacerScrollHastaFila( row, colActual );  // Seleccionar fila encontrada en la ventana
									return;
								}
								row++;
							}
						}
					}
				} else if (e.getKeyCode()==KeyEvent.VK_C && !e.isControlDown()) { // C copia al portapapeles (sin Control)
					(new Thread() {
						@Override
						public void run() {
							StringBuffer texto = new StringBuffer();
							for (String header : tablaDatos.getCabeceras()) {
								texto.append( header==null ? "" : header + "\t" );
							}
							texto.append( "\n" );
							for (int f=0; f<tablaDatos.size(); f++) {
								for (int c=0; c<tablaDatos.getWidth(); c++) {
									Object o = tablaDatos.get( f, c );
									String s = (o==null) ? "null" : o.toString();
									texto.append( (s==null?"":s) + "\t" );
								}
								texto.append( "\n" );
							}
							Toolkit.getDefaultToolkit().getSystemClipboard().setContents( new StringSelection(texto.toString()), null );
							JOptionPane.showMessageDialog( ventMadre, "Contenido de tabla " + getTitle() + " copiado al portapapeles.", "Copia de " + tablaDatos.size() + " filas", JOptionPane.INFORMATION_MESSAGE );
						}
					}).start();
					// JOptionPane.showMessageDialog( kaw, "Copiándose la tabla de interacciones al portapapeles...", "Puedes seguir trabajando mientras", JOptionPane.INFORMATION_MESSAGE );
				}
			}
			private void hacerScrollHastaFila( int row, int col ) {  // Mostrar en el scrollpane la fila,col indicada
				tDatos.getSelectionModel().setSelectionInterval( row, row );
				Rectangle rect = tDatos.getCellRect( row, col, true );
				rect.setLocation(rect.x, rect.y+25);  // Y un poquito más abajo (para que no quede demasiado justo)
				tDatos.scrollRectToVisible( rect );
			}
			private void hacerBusqueda() {
				if (ultimaBusqueda==null || ultimaBusqueda.isEmpty()) return;
				int col = tDatos.getSelectedColumn();
				int row = tDatos.getSelectedRow();
				if (col<0) col = 0; if (row<0) row = 0;
				String aBuscar = ultimaBusqueda.toUpperCase();
				row++;
				if (ultimaBusquedaEnCol) {
					while (row<tDatos.getModel().getRowCount()) {
						if (tDatos.getValueAt( row, col ).toString().toUpperCase().contains( aBuscar )) {
							hacerScrollHastaFila( row, col );  // Seleccionar fila encontrada en la ventana
							return;
						}
						row++;
					}
				} else {
					while (row<tDatos.getModel().getRowCount() && col<tDatos.getModel().getColumnCount()) {
						if (tDatos.getValueAt( row, col ).toString().toUpperCase().contains( aBuscar )) {
							hacerScrollHastaFila( row, col );  // Seleccionar fila encontrada en la ventana
							return;
						}
						row++;
						if (row>=tDatos.getModel().getRowCount()) {
							row = 0;
							col = col + 1;
						}
					}
				}
			}
		}); 

	}

	public void setMensaje( String mens ) {
		if (mens==null || mens.isEmpty()) mens = " ";
		lMensaje.setText( mens );
	}

	/** Asigna una tabla de datos a la JTable principal de la ventana
	 * @param tabla	Tabla de datos a visualizar
	 */
	public void setTabla( Tabla tabla ) {
		tablaDatos = tabla;
		tDatos.setModel( tabla.getTableModel() );
	}

	/** Devuelve la tabla de datos asignada a la ventana
	 * @return	tabla de datos asignada, null si no la hay
	 */
	public Tabla getTabla() {
		return tablaDatos;
	}

	/** Oculta las columnas indicadas en la visual
	 * @param colD	columna inicial (0 a n-1)
	 * @param colH	columna final (0 a n-1)
	 */
	public void ocultaColumnas( final int colD, final int colH ) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for (int i=colH; i>=colD; i--)
					tDatos.removeColumn(tDatos.getColumnModel().getColumn( i ));
			}
		};
		if (SwingUtilities.isEventDispatchThread()) r.run(); else SwingUtilities.invokeLater( r );
	}

	/** Asocia escuchador al doble click de la celda
	 * @param evento	Escuchador a asociar
	 */
	public void setDobleClickCelda( EventoEnCelda evento ) {
		dobleClick = evento;
	}

	/** Asocia escuchador al doble click de la cabecera
	 * @param evento	Escuchador a asociar
	 */
	public void setDobleClickHeader( EventoEnCelda evento ) {
		dobleClickHeader = evento;
	}

	/** Asocia escuchador a la pulsación de enter de la celda
	 * @param evento	Escuchador a asociar
	 */
	public void setEnterCelda( EventoEnCelda evento ) {
		enter = evento;
	}

	/** Busca la columna para un nombre de columna dado
	 * @param nomCol	Nombre de columna a buscar
	 * @param nomExacto	true si la coincidencia debe ser exacta, si no se busca coincidencia parcial
	 * @return	Número de la columna, -1 si no se encuentra
	 */
	public int getColumnWithHeader( String nomCol, boolean nomExacto ) {
		TableColumnModel cols = tDatos.getTableHeader().getColumnModel();
		for (int col = 0; col<cols.getColumnCount(); col++) {
			String nom = cols.getColumn(col).getHeaderValue() + "";
			if (nomExacto && nom.equals( nomCol )) return col;
			if (!nomExacto && nom.toUpperCase().startsWith( nomCol.toUpperCase() ) ) return col;
		}
		return -1;
	}



}

