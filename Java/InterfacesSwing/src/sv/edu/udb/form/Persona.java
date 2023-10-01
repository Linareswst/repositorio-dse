package sv.edu.udb.form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Persona extends JFrame{
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtTelefono;
    private JComboBox cmbSexo;
    private JButton btnObtenerDatos;
    private JButton btnLimpiar;
    private JLabel lblId;
    private JPanel pnlPersona;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblTelefono;
    private JLabel lblSexo;
    private JTable tblDatos;
    DefaultTableModel modelo = null;

    public Persona(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlPersona);
        this.setMinimumSize(new Dimension(600,500));
        this.setLocationRelativeTo(getParent());

        //Arreglo de objeto, para inicializar con vacion la tabla
        Object [][] data = null;
        //Arreglo de String para crear los nombres de las columnas
        String[] columns = {
                "Id", "Nombres", "Edad", "Telefono", "Sexo"
        };
        //Instancia del modelo
        modelo = new DefaultTableModel(data, columns);
        //Seteo del modelo, el cual tendra la estructura que permitira a la tabla representar los datos
        tblDatos.setModel(modelo);

        //Cargar datos desde CSV al iniciar el programa
        cargarDatosCSV("/sv/edu/udb/util/datos.csv");

        btnObtenerDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnObtenerDatos();
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLimpiar();
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtnerDato(e);
            }
        });
    }

    private void btnObtenerDatos(){
        String id = txtId.getText();
        String nombres = txtNombre.getText();
        String edad = txtEdad.getText();
        String telefono = txtTelefono.getText();
        String sexo = cmbSexo.getSelectedItem().toString();

        JOptionPane.showMessageDialog(null,"Datos Obtenidos: \n ID: " +id+
                "\n nombres: "+ nombres+"\n Edad: "+edad+"\n Telefono: "+telefono+
                "\n Sexo: "+ sexo);

        Object[] newRow={
                id,
                nombres,
                edad,
                telefono,
                sexo
                };
        modelo.addRow(newRow);

        // Escribir los datos en el archivo CSV
        escribirDatosenCSV("/sv/edu/udb/util/datos.csv", id, nombres, edad, telefono, sexo);
    }

    private void btnLimpiar(){
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        cmbSexo.setSelectedIndex(0);
    }

    private void tblObtnerDato(MouseEvent e){
        int fila = tblDatos.rowAtPoint(e.getPoint());
        int columna = tblDatos.columnAtPoint(e.getPoint());

        if ((fila > -1) && (columna > -1)){
            txtId.setText(modelo.getValueAt(fila,0).toString());
            txtNombre.setText(modelo.getValueAt(fila,1).toString());
            txtEdad.setText(modelo.getValueAt(fila,2).toString());
            txtTelefono.setText(modelo.getValueAt(fila,3).toString());
            cmbSexo.setSelectedItem(modelo.getValueAt(fila,4).toString());
        }
    }

    private void cargarDatosCSV(String archivoCSV){
        try{
            InputStream inputStream = getClass().getResourceAsStream(archivoCSV);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String linea;

            //Limpia la tabla antes de cargar nuevos datos
            DefaultTableModel model = (DefaultTableModel) tblDatos.getModel();
            model.setRowCount(0);

            //Lee cada linea del archivo CSV y la agrega a la tabla
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                model.addRow(datos);
            }
            br.close();
        } catch (IOException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo CSV", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void escribirDatosenCSV(String archivoCSV, String id, String nombres, String edad, String telefono, String sexo){
        try {
            // Obtener la ubicación del archivo CSV dentro del paquete
            InputStream inputStream = getClass().getResourceAsStream(archivoCSV);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String linea;

            // Leyendo el contenido original
            List<String> lineasOriginales = new ArrayList<>();
            while ((linea = br.readLine()) != null) {
                lineasOriginales.add(linea);
            }
            br.close();

            // Abrir el archivo CSV en modo de escritura y posicionarte al final
            FileWriter fileWriter = new FileWriter(getClass().getResource(archivoCSV).getFile());
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Escribir las líneas originales
            for (String originalLine : lineasOriginales) {
                printWriter.println(originalLine);
            }

            // Escribir la nueva línea con los datos ingresados
            String nuevaLinea = id + "," + nombres + "," + edad + "," + telefono + "," + sexo;
            printWriter.println(nuevaLinea);

            // Cerrar el archivo
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo CSV", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new Persona("Ingreso de Datos");
        frame.setVisible(true);
    }

}
