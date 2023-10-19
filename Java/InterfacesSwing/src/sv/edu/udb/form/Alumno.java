package sv.edu.udb.form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import sv.edu.udb.datos.AlumnoDatos;
import sv.edu.udb.beans.AlumnoBeans;
import sv.edu.udb.datos.MateriasDatos;
import javax.swing.table.DefaultTableModel;

public class Alumno extends JFrame{
    private JPanel pnlAlumno;
    private JLabel lblAlumnos;
    private JLabel lblImagen;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblCarnet;
    private JLabel lblMateria;
    private JButton btnObtenerDatos;
    private JButton btnEliminar;
    private JButton btnLimpiar;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtCarnet;
    private JComboBox cmbMateria;
    private JTable tblDatosA;

    DefaultTableModel modelo = null;
    AlumnoBeans alumnoBeans = null;
    AlumnoDatos alumnoDatos = new AlumnoDatos();
    MateriasDatos materiasDatos = new MateriasDatos();

    public Alumno(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlAlumno);
        this.setMinimumSize(new Dimension(600,500));
        this.setLocationRelativeTo(getParent());

        modelo = alumnoDatos.selectAlumno();
        tblDatosA.setModel(modelo);
        cmbMateria.setModel(materiasDatos.selectMaterias());


        btnObtenerDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnObtenerDatosA();
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEliminarDatosA();
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLimpiarA();
            }
        });

        tblDatosA.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerDato(e);
            }
        });
    }
    private void btnObtenerDatosA(){
        int id;
        String nombre;
        String carnet;
        int id_materia;

        if(txtId.getText().isEmpty()){
            id = 0;
        }else {
            id = Integer.parseInt(txtId.getText());
        }

        nombre = txtNombre.getText();
        carnet = txtCarnet.getText();
        id_materia = materiasDatos.getIdMateria(cmbMateria.getSelectedItem().toString());

        alumnoBeans = new AlumnoBeans(id,nombre,carnet,id_materia);

        if(btnObtenerDatos.getText().equals("Guardar")){
            alumnoDatos.insert(alumnoBeans);
        } else if (btnObtenerDatos.getText().equals("Editar")) {
            alumnoDatos.update(alumnoBeans);
        }
        modelo=alumnoDatos.selectAlumno();
        tblDatosA.setModel(modelo);
    }

    private void btnLimpiarA(){
        txtId.setText("");
        txtNombre.setText("");
        txtCarnet.setText("");
        cmbMateria.setSelectedIndex(0);
        btnObtenerDatos.setText("Guardar");
    }

    private void btnEliminarDatosA(){
        alumnoDatos.delete(Integer.parseInt(txtId.getText()));
        btnLimpiarA();
        modelo=alumnoDatos.selectAlumno();
        tblDatosA.setModel(modelo);
    }

    private void tblObtenerDato(MouseEvent e){
        int fila = tblDatosA.rowAtPoint(e.getPoint());
        int columna = tblDatosA.columnAtPoint(e.getPoint());

        if ((fila > -1) && (columna > -1)){
            txtId.setText(modelo.getValueAt(fila,0).toString());
            txtNombre.setText(modelo.getValueAt(fila,1).toString());
            txtCarnet.setText(modelo.getValueAt(fila,2).toString());
            cmbMateria.setSelectedItem(modelo.getValueAt(fila,3).toString());
            btnObtenerDatos.setText("Editar");
        }

    }

    public static void main(String[] args) {
        JFrame frame = new Alumno("Ingreso de Datos Alumno");
        frame.setVisible(true);
    }
}
