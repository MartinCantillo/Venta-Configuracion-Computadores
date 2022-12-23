package Controller;

import Model.Centralunit;
import Model.Customer;
import Model.Input;
import Model.Outs;
import Model.Peripherals;
import Model.Sales;
import View.Register;
import View.ViewFrame;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
//importo las librerias de pdf
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marti
 */
public class ControlRegister implements ActionListener {

    private Register regist;
    private Centralunit comput;
    private Customer custo;
    private Input inp;
    private Outs out;
    private Peripherals peri;
    private Sales sal;
    ArrayList<Centralunit> listaP = new ArrayList();
    ViewFrame view;
    private int precioE = 0;
    private int precioS = 0;
    DefaultTableModel modelo = new DefaultTableModel();
    ArrayList<Input> inpt = new ArrayList();
    ArrayList<Outs> ot = new ArrayList();
//    ArrayList<Outs> ot = new ArrayList();

    public ControlRegister() {
    }

    public ControlRegister(Register registt) {
        this.regist = registt;
        regist.jbagregar.addActionListener(this);
        regist.txtCambio.addActionListener(this);
        regist.jbeliminar.addActionListener(this);
        regist.jbpdf.addActionListener(this);
        regist.txtPago.addActionListener(this);
        String titulo[] = new String[]{"Unidad Central", "Precio", "D.Entrada", "Precio", "D.Salida", "Precio"};
        modelo.setColumnIdentifiers(titulo);

    }

    public void limpiarjcombo() {
        regist.txtUnidadCentral.setText("");
        regist.txtPrecioUCentral.setText("");
        regist.jComboBox1Entrada.setSelectedIndex(0);
        regist.txtCodigoentrada.setText("");
        regist.txtPrecioEntrada.setText("");
        regist.txtEntradaFabricamte.setText("");
        regist.txtentradalModelo.setText("");
        regist.jComboBox2Salida.setSelectedIndex(0);
        regist.txtCodigoSalida.setText("");
        regist.txtPrecioSalida.setText("");
        regist.txtSalidaFabricamte.setText("");
        regist.txtsalidaModelo.setText("");
    }

    public ControlRegister(Register registr, Centralunit comput, Customer custo, Input inp, Outs out, Peripherals peri, Sales sal) {
        this.regist = registr;
        this.comput = comput;
        this.custo = custo;
        this.inp = inp;
        this.out = out;
        this.peri = peri;
        this.sal = sal;
        regist.jbagregar.addActionListener(this);
        regist.txtCambio.addActionListener(this);
        regist.jbeliminar.addActionListener(this);
        regist.jbpdf.addActionListener(this);
        regist.txtPago.addActionListener(this);
        String titulo[] = new String[]{"Unidad Central", "Precio", "D.Entrada", "Precio", "D.Salida", "Precio"};
        modelo.setColumnIdentifiers(titulo);
    }

    public void agregar() {

        modelo.addRow(new Object[]{
            regist.txtUnidadCentral.getText(), regist.txtPrecioUCentral.getText(), regist.jComboBox1Entrada.getSelectedItem().toString(),
            regist.txtPrecioEntrada.getText(), regist.jComboBox2Salida.getSelectedItem().toString(), regist.txtPrecioSalida.getText()});

    }

    public void mostrarPanel(JPanel p) {
//        p.setSize(1400, 700);
        p.setLocation(0, 0);
        ViewFrame.jPanel3Princial.removeAll();
        ViewFrame.jPanel3Princial.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        ViewFrame.jPanel3Princial.revalidate();
        ViewFrame.jPanel3Princial.repaint();
    }

    public int calculartotalBrutoEntradas() {
        int suma = 0, registro;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            // aqui le mando la colunna de donde esta el precio de los productos

            if (modelo.getValueAt(i, 3).toString().equalsIgnoreCase("")) {

            } else {
                registro = Integer.parseInt(modelo.getValueAt(i, 3).toString());
                suma = suma + registro;
            }
        }

        return suma;
    }

    public int calculartotalBrutoSalida() {
        int suma = 0, registro;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            // aqui le mando la colunna de donde esta el precio de los productos

            if (modelo.getValueAt(i, 5).toString().equalsIgnoreCase("")) {

            } else {
                registro = Integer.parseInt(modelo.getValueAt(i, 5).toString());
                suma = suma + registro;
            }
        }

        return suma;
    }

    public int calculartotalUnidadCentral() {
        int suma = 0, registro;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            // aqui le mando la colunna de donde esta el precio de los productos
            if (modelo.getValueAt(i, 1).toString().equalsIgnoreCase("")) {

            } else {
                registro = Integer.parseInt(modelo.getValueAt(i, 1).toString());
                suma = suma + registro;
            }

        }

        return suma;
    }

    public double CalcularTotalPagar() {

        int suma = calculartotalBrutoEntradas() + calculartotalUnidadCentral() + calculartotalBrutoSalida();
        regist.txtSubtotal.setText(String.valueOf(suma));
        double op = suma * 0.19;
        double total = suma + op;
        regist.txtotalpagar.setText(String.valueOf(total));
//        JOptionPane.showMessageDialog(null, " valor de subtotal " + regist.txtSubtotal.getText());
//        JOptionPane.showMessageDialog(null, " calculartotalBrutoEntradas() " + calculartotalBrutoEntradas());
//        JOptionPane.showMessageDialog(null, "  calculartotalUnidadCentral() " + calculartotalUnidadCentral());
//        JOptionPane.showMessageDialog(null, " calculartotalBrutoSalida() " + calculartotalBrutoSalida());
        return total;
    }
//        if (regist.txtSubtotal.getText().equals("")) {
//            JOptionPane.showMessageDialog(null, " entro al if!", "Alerta", JOptionPane.WARNING_MESSAGE);
//            regist.txtSubtotal.setText("0");
//            int suma = Integer.parseInt(regist.txtSubtotal.getText());
//            suma = calculartotalBrutoEntradas() + calculartotalUnidadCentral() + calculartotalBrutoSalida();
//            regist.txtSubtotal.setText(String.valueOf(suma));
//            double iva = 0.19;
//            double op = suma * 0.19;
//            double total = suma + op;
//            regist.txtCambio.setText(String.valueOf(total));
//        } else {
//            JOptionPane.showMessageDialog(null, " entro al else!", "Alerta", JOptionPane.WARNING_MESSAGE);
//            int suma = Integer.parseInt(regist.txtSubtotal.getText());
//            suma += calculartotalBrutoEntradas() + calculartotalUnidadCentral() + calculartotalBrutoSalida();
//            regist.txtSubtotal.setText(String.valueOf(suma));
//            double iva = 0.19;
//            double op = suma * 0.19;
//            double total = suma + op;
//            regist.txtCambio.setText(String.valueOf(total));
//        }

    //  }
    public double calcularCambio() {

        double resta = 0;
        double c = CalcularTotalPagar();

        double get = Double.parseDouble(regist.txtPago.getText());
        if (get < c || get == 0) {
            JOptionPane.showMessageDialog(null, "No se puede proceder al pago , por favor rectifique");
        } else {
            resta = get - c;
            regist.txtCambio.setText(String.valueOf(resta));
        }
        return resta;
    }

    public void iniciarcontrolregister(Register regist) {
        mostrarPanel(regist.Fondo());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        if (e.getSource() == regist.jbagregar) {
//            if (regist.txtCliente.getText().equalsIgnoreCase("") || regist.txtcedula.getText().equalsIgnoreCase("") || regist.txEmail.getText().equalsIgnoreCase("")
//                    || regist.txtCodigoventa.getText().equalsIgnoreCase("") || regist.txtVendedor.getText().equalsIgnoreCase("") || regist.jDateChooser1fecha.getDate() == null
//                    || regist.txtCodigounidadCentral.getText().equalsIgnoreCase("") || regist.txtUnidadCentralFabricamte.getText().equalsIgnoreCase("") || regist.txtUnidadCentral.getText().equalsIgnoreCase("")
//                    || regist.jComboBox1Entrada.getSelectedIndex() == 0 || regist.jComboBox2Salida.getSelectedIndex() == 0 || regist.txtCodigoentrada.getText().equalsIgnoreCase("") || regist.txtCodigoSalida.getText().equalsIgnoreCase("")
//                    || regist.txtConector.getText().equalsIgnoreCase("") || regist.txtPuertosEntrada.getText().equalsIgnoreCase("")) {
//                JOptionPane.showMessageDialog(null, " Por favor verifica!", "Alerta", JOptionPane.WARNING_MESSAGE);
////                regist.jTabla.setModel(modelo);
////                agregar();
//
//            } else {
////                String cliente = regist.txtCliente.getText();
////                int cedula = Integer.parseInt(regist.txtcedula.getText());
////                String email = regist.txEmail.getText();
////                int codigoventa = Integer.parseInt(regist.txtCodigoventa.getText());
////                String vendedor = regist.txtVendedor.getText();
////                Date fecha = regist.jDateChooser1fecha.getDate();
////                int codigocentral = Integer.parseInt(regist.txtCodigounidadCentral.getText());
////                String fabricante = regist.txtUnidadCentralFabricamte.getText();
////                String unidadcentral = regist.txtUnidadCentral.getText();
////                String conectoru = regist.txtConectorUCentral.getText();
////                int puertoUcentral = Integer.parseInt(regist.txtPuertoUCentral.getText());
////                String disposalida;
////                int precioUcentral = Integer.parseInt(regist.txtPrecioUCentral.getText());
////                int codentrada = Integer.parseInt(regist.txtCodigoentrada.getText());
////                int codsalida = Integer.parseInt(regist.txtCodigoSalida.getText());
////                int precioentrada = Integer.parseInt(regist.txtPrecioEntrada.getText());
////                int preciosalida = Integer.parseInt(regist.txtPrecioSalida.getText());
////                String conector = regist.txtConector.getText();
////                int puertos = Integer.parseInt(regist.txtPuertosEntrada.getText());
////
////                Centralunit computa = new Centralunit(codigocentral, fabricante, unidadcentral, precioUcentral, conectoru, puertoUcentral);
        // agregar();
//            }
//        }
        if (e.getSource() == regist.jbagregar) {
            regist.jTabla.setModel(modelo);
            agregar();

            if (!regist.txtPrecioEntrada.getText().equalsIgnoreCase("")) {
                inp = new Input(regist.jComboBox1Entrada.getSelectedItem().toString(), Integer.parseInt(regist.txtPrecioEntrada.getText()));
                inpt.add(inp);
            } else {

            }
            if (!regist.txtPrecioSalida.getText().equalsIgnoreCase("")) {
                out = new Outs(regist.jComboBox2Salida.getSelectedItem().toString(), Integer.parseInt(regist.txtPrecioSalida.getText()));
                ot.add(out);
            } else {

            }
            CalcularTotalPagar();
            // limpiarjcombo();
        }

        if (e.getSource() == regist.txtPago) {
            //  JOptionPane.showMessageDialog(null, "  presionastes el  txt");
            calcularCambio();
        }
        if (e.getSource() == regist.jbeliminar) {

            int fila = regist.jTabla.getSelectedRow();
            if (fila >= 0) {
                modelo.removeRow(fila);
            } else {

            }
            CalcularTotalPagar();

        }
        if (e.getSource() == regist.jbpdf) {
            if (regist.txtCliente.getText().equalsIgnoreCase("") || regist.txtcedula.getText().equalsIgnoreCase("") || regist.txtVendedor.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, " No se puede crear el reporte pdf , por favor rectifique ");
            } else {

                try {

                    pdf();

                } catch (FileNotFoundException | DocumentException ex) {
                    Logger.getLogger(ControlRegister.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("exep");
                } catch (IOException ex) {
                    Logger.getLogger(ControlRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        if (e.getSource() == regist.txtCambio) {
            limpiarTodo();
        }
    }

    public void limpiarTodo() {
        regist.txtUnidadCentral.setText("");
        regist.txtPrecioUCentral.setText("");
        regist.jComboBox1Entrada.setSelectedIndex(0);
        regist.txtCodigoentrada.setText("");
        regist.txtPrecioEntrada.setText("");
        regist.txtEntradaFabricamte.setText("");
        regist.txtentradalModelo.setText("");
        regist.jComboBox2Salida.setSelectedIndex(0);
        regist.txtCodigoSalida.setText("");
        regist.txtPrecioSalida.setText("");
        regist.txtSalidaFabricamte.setText("");
        regist.txtsalidaModelo.setText("");
        regist.txtCodigounidadCentral.setText("");
        regist.txtUnidadCentralFabricamte.setText("");
        regist.txtPuertosEntrada.setText("");
        regist.txtUnidadcentralModelo.setText("");
        regist.txtConectorEntrada.setText("");
        regist.txtPuertosEntrada.setText("");
        regist.txtConectorSalida.setText("");
        regist.txtPuertoSalida.setText("");
        regist.txtConectorUCentral.setText("");
        regist.txtPuertoUCentral.setText("");

        regist.txtcedula.setText("");
        regist.txtCliente.setText("");
        regist.txEmail.setText("");
        regist.txtCodigoventa.setText("");
        regist.txtVendedor.setText("");
        regist.jDateChooser1fecha.setDate(null);

        regist.txtSubtotal.setText("0");
        regist.txtotalpagar.setText("0");
        regist.txtPago.setText("0");
        regist.txtCambio.setText("0");
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
        }

    }

    public void pdf() throws FileNotFoundException, DocumentException, BadElementException, IOException {
        Document documento = new Document();
        //como voy a crear un documento entonces un try catch

        // creo la ruta de mi usuario
        String ruta = System.getProperty("users.home");
        // ahora le digo el nombre del documento y donde lo voy a guardar
        PdfWriter.getInstance(documento, new FileOutputStream("C:\\Users\\marti\\OneDrive\\Escritorio\\Reportes" + regist.txtCliente.getText().trim() + ".pdf"));
        // ahora abro el documento
//        com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/image/sof.png/");
//        header.scaleToFit(50, 400);
//        header.setAlignment(Chunk.ALIGN_CENTER);
        documento.open();
        Paragraph parrafo = new Paragraph("Informacion del Cliente");
        parrafo.setAlignment(1);
        Paragraph parrafo2 = new Paragraph();
//        parrafo.add("\n\n informacion del cliente \n");
        parrafo2.add("\n Nombre : " + regist.txtCliente.getText() + "\n");
        parrafo2.add(" \n  Cedula : " + regist.txtcedula.getText() + "\n");
        parrafo2.add("\n  Correo Electronico : " + regist.txEmail.getText() + "\n");
        parrafo2.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
        parrafo2.setAlignment(Chunk.ALIGN_LEFT);
        parrafo2.add("\n");

        Paragraph parrafo4 = new Paragraph("Informacion de la venta");
        parrafo4.setAlignment(1);
        Paragraph parrafo5 = new Paragraph();
        parrafo5.add(" Codigo :  " + regist.txtCodigoventa.getText() + "\n");
        parrafo5.add("\n Vendedor : " + regist.txtVendedor.getText() + "\n");
        parrafo5.add("\n Fecha :  " + String.valueOf(regist.jDateChooser1fecha.getDate()) + "\n");
        Paragraph nombretabla2 = new Paragraph("Dispositivos de entradas registrados");
        nombretabla2.setAlignment(1);
        PdfPTable tabla2 = new PdfPTable(2);
        tabla2.addCell("Dispositivos de entrada");
        tabla2.addCell("Precios ");
        tabla2.setHorizontalAlignment(25);
        for (Input i : inpt) {
            tabla2.addCell(i.getNombre());
            tabla2.addCell(String.valueOf(i.getPrecio()));
        }

        tabla2.setWidthPercentage(100);
//        documento.add(header);
        Paragraph nombretabla = new Paragraph("Dispositivos de Salidas registrados");
        nombretabla.setAlignment(1);
        //ahora creo la tabla dentro del documento
        PdfPTable tabla = new PdfPTable(2); // le mando las columnas de la tabla

        tabla.setWidthPercentage(100);
        tabla.addCell("Dispositivos Salida");
        tabla.addCell("Precios ");
        tabla.setHorizontalAlignment(25);
        // ahora le agrego la innfo
        for (Outs y : ot) {
            tabla.addCell(y.getNombre());
            tabla.addCell(String.valueOf(y.getPrecio()));
        }
//        for (Input i : inpt) {
//            tabla.addCell(i.getNombre());
//            tabla.addCell(String.valueOf(i.getPrecio()));
//        }

        Paragraph productos = new Paragraph();
        productos.add("\n  SubTotal :  " + regist.txtSubtotal.getText() + "\n");
        productos.add("\n Iva  : 19% \n");
        productos.add("\n Total a pagar :  " + regist.txtotalpagar.getText() + "\n");
        productos.add("\n Pago :  " + regist.txtPago.getText() + "\n");
        productos.add("\n Cambio :  " + regist.txtCambio.getText() + "\n");

        tabla.setHorizontalAlignment(25);

        documento.add(parrafo);
        documento.add(parrafo2);
        documento.add(Chunk.NEWLINE);
        documento.add(parrafo4);
        documento.add(Chunk.NEWLINE);
        documento.add(parrafo5);
        documento.add(Chunk.NEWLINE);
        documento.add(nombretabla2);
        documento.add(Chunk.NEWLINE);
        documento.add(tabla2);
        documento.add(Chunk.NEWLINE);
        documento.add(nombretabla);
        documento.add(Chunk.NEWLINE);
        documento.add(tabla);
        documento.add(Chunk.NEWLINE);
        documento.add(productos);
        JOptionPane.showMessageDialog(null, " Reporte Creado ");
        //ahora cierro el documento
        documento.close();

    }
}
