package Librerias;

import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

public class GeneratePDFFile {

	private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
         
    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);    
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	
    private static final String iTextExampleImage = "/home/xules/codigoxules/iText-Example-image.png";
    
    public void createPDF(File pdfNewFile) {
    	
    	// Código para crear el PDF
    	
    	
    	// Creamos el documento e indicamos el nombre del fichero
    	try {
    	    Document document = new Document();
    	    try {
    	        PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
    	    } catch (FileNotFoundException fileNotFoundException) {
    	        System.out.println("No se encontró el fichero para generar el pdf" + fileNotFoundException);
    	    }
    	    document.open();
    	 
    	    
    	    //////// CÓDIGO PARA GENERAR EL PDF ////////
    	    
    	    document.addTitle("Table export to PDF (Exportamos la tabla a PDF)");
    	    document.addSubject("Using iText (usando iText)");
    	    document.addKeywords("Java, PDF, iText");
    	    document.addAuthor("Código Xules");
    	    document.addCreator("Código Xules");
    	    
    	    
    	    // Primera página 
    	    Chunk chunk = new Chunk("Título", chapterFont);
    	    chunk.setBackground(BaseColor.GRAY);
    	    
    	    
    	    // Creemos el primer capítulo
    	    Chapter chapter = new Chapter(new Paragraph(chunk), 1);
    	    chapter.setNumberDepth(0);
    	    chapter.add(new Paragraph("Párrafo", paragraphFont));
    	    
    	    
    	    // Añadimos una imagen
    	    Image image;
    	    try {
    	        image = Image.getInstance(iTextExampleImage);  
    	        image.setAbsolutePosition(2, 150);
    	        chapter.add(image);
    	    } catch (BadElementException ex) {
    	        System.out.println("Image BadElementException" +  ex);
    	    } catch (IOException ex) {
    	        System.out.println("Image IOException " +  ex);
    	    }
    	    document.add(chapter);

    	    
    	    // Segunda página - Algunos elementos
    	    Chapter chapSecond = new Chapter(new Paragraph(new Anchor("Añadimos varios elementos")), 1);
    	    Paragraph paragraphS = new Paragraph("Realizado por Xules", subcategoryFont);

    	    
    	    // Subrayando un párrafo por iText
    	    Paragraph paragraphE = new Paragraph("Esta línea será subrayada con una línea de puntos");
    	    DottedLineSeparator dottedline = new DottedLineSeparator();
    	    dottedline.setOffset(-2);
    	    dottedline.setGap(2f);
    	    paragraphE.add(dottedline);
    	    chapSecond.addSection(paragraphE);
    	    
    	    
    	    // EJEMPLO LISTAS //
    	    Section paragraphMoreS = chapSecond.addSection(paragraphS);
    	    
    	    // Listas por iText
    	    String text = "test 1 2 3 ";
    	    for (int i = 0; i < 5; i++) {
    	    	text = text + text;
    	    }
    	    List list = new List(List.UNORDERED);
    	    ListItem item = new ListItem(text);
    	    item.setAlignment(Element.ALIGN_JUSTIFIED);
    	    list.add(item);
    	    text = "a b c align ";
    	    for (int i = 0; i < 5; i++) {
    	    	text = text + text;
    	    }
    	    item = new ListItem(text);
    	    item.setAlignment(Element.ALIGN_JUSTIFIED);
    	    list.add(item);
    	    text = "supercalifragilisticexpialidocious ";
    	    for (int i = 0; i < 3; i++) {
    	    	text = text + text;
    	    }
    	    item = new ListItem(text);
    	    item.setAlignment(Element.ALIGN_JUSTIFIED);
    	    list.add(item);
    	    paragraphMoreS.add(list);
    	    document.add(chapSecond);

    	    
    	    // UTILIZACIÓN DE PdfPTable //
    	    
    	    // Usamos varios elementos para añadir título y subtítulo
    	    Anchor anchor = new Anchor("Exportamos la tabla a PDF", categoryFont);
    	    anchor.setName("Exportamos la tabla a PDF");            
    	    Chapter chapTitle = new Chapter(new Paragraph(anchor), 1);
    	    Paragraph paragraph = new Paragraph("Realizado por Xules", subcategoryFont);
    	    Section paragraphMore = chapTitle.addSection(paragraph);
    	    paragraphMore.add(new Paragraph("This is a simple example (Este es un ejemplo sencillo)"));
    	    Integer numColumns = 6;
    	    Integer numRows = 120;
    	    
    	    // Creamos la tabla
    	    PdfPTable table = new PdfPTable(numColumns); 
    	    
    	    // Llenamos la tabla del PDF
    	    PdfPCell columnHeader;
    	    
    	    // Rellenamos las columnas de la tabla                
    	    for (int column = 0; column < numColumns; column++) {
    	    	columnHeader = new PdfPCell(new Phrase("COL " + column));
    	    	columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
    	    	table.addCell(columnHeader);
    	    }
    	    table.setHeaderRows(1);
    	    
    	    // Rellenamos las filas de la tabla                
    	    for (int row = 0; row < numRows; row++) {
    	    	for (int column = 0; column < numColumns; column++) {
    	    		table.addCell("Row " + row + " - Col" + column);
    	    	}
    	    }
    	    // Añadimos la tabla
    	    paragraphMore.add(table);
    	    
    	    // Añadimos el elemento con la tabla
    	    document.add(chapTitle);

    	    
    	    document.close();
    	    System.out.println("Se ha generado el PDF");
    	    
    	} catch (DocumentException documentException) {
    	    System.out.println("Se ha producido un error al generar un documento: " + documentException);
    	}
    	
    }
    
    public static void main(String args[]) {
        GeneratePDFFile generatePDFFileIText = new GeneratePDFFile();
        generatePDFFileIText.createPDF(new File("/home/xules/codigoxules/GeneratePDFFileIText.pdf"));
    }
}
