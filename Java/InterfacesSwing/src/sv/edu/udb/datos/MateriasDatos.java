package sv.edu.udb.datos;
import sv.edu.udb.util.Conexion2;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import java.sql.*;

public class MateriasDatos {
    private final String SQL_SELECT = "SELECT id_materia, materia FROM materias ORDER BY id_materia";
    private final String SQL_SELECT_IDMATERIA = "SELECT id_materia FROM materias where materia =?";

    public DefaultComboBoxModel selectMaterias(){
        DefaultComboBoxModel dtm = new DefaultComboBoxModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion2.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
//Creando las filas para el JTable
            while (rs.next()) {
                dtm.addElement(rs.getObject(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion2.close(rs);
            Conexion2.close(stmt);
            Conexion2.close(conn);
        }
        return dtm;
    }
    public int getIdMateria(String materia){
        int idMateria = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        System.out.println("materia " + materia);
        System.out.println("materia " + SQL_SELECT_IDMATERIA);
        try {
            conn = Conexion2.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_IDMATERIA);
            stmt.setString(1, materia);
            rs = stmt.executeQuery();
//Creando las filas para el JTable
            while (rs.next()) {
                idMateria = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion2.close(rs);
            Conexion2.close(stmt);
            Conexion2.close(conn);
        }
        return idMateria;
    }


}
