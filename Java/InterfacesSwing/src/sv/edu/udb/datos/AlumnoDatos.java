package sv.edu.udb.datos;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import sv.edu.udb.util.Conexion2;
import sv.edu.udb.beans.AlumnoBeans;


public class AlumnoDatos {
    private final String SQL_INSERT
            = "INSERT INTO alumno(id_alumno,nombre,carnet,id_materia) VALUES(?,?,?,?)";
    private final String SQL_UPDATE
            = "UPDATE alumno SET nombre=?, carnet=?,id_materia=? WHERE id_alumno=?";
    private final String SQL_DELETE
            = "DELETE FROM alumno WHERE id_alumno = ?";
    private final String SQL_SELECT
            = "SELECT a.id_alumno, a.nombre a.carnet, m.materia FROM alumno a INNER JOIN materias m ON a.id_materia = m.id_materia ";

    public int insert (AlumnoBeans alumnoBeans) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try{
            conn = Conexion2.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setInt(index++, alumnoBeans.getIdAlumno());
            stmt.setString(index++, alumnoBeans.getNombreAlumno());
            stmt.setString(index++, alumnoBeans.getCarnetAlumno());
            stmt.setInt(index++, alumnoBeans.getIdMateria());
            System.out.println("Ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();//no. registros afectados
            System.out.println("Registros afectados:" + rows);

        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            Conexion2.close(stmt);
            Conexion2.close(conn);
        }
        return rows;
    }

    public int update (AlumnoBeans alumnoBeans) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion2.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setInt(index++, alumnoBeans.getIdAlumno());
            stmt.setString(index++, alumnoBeans.getNombreAlumno());
            stmt.setString(index++, alumnoBeans.getCarnetAlumno());
            stmt.setInt(index++, alumnoBeans.getIdMateria());
            rows = stmt.executeUpdate();//no. registros afectados
            System.out.println("Registros actualizados:" + rows);

        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            Conexion2.close(stmt);
            Conexion2.close(conn);
        }
        return rows;
    }

    public int delete (int idAlumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion2.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, idAlumno);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);

        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            Conexion2.close(stmt);
            Conexion2.close(conn);
        }
        return rows;
    }

    public DefaultTableModel selectAlumno(){
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion2.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            //Formando encabezado
            for (int i = 1; i <= numberOfColumns; i++) {
                dtm.addColumn(meta.getColumnLabel(i));
            }
//Creando las filas para el JTable
            while (rs.next()) {
                Object[] fila = new Object[numberOfColumns];
                for (int i = 0; i < numberOfColumns; i++) {
                    fila[i]=rs.getObject(i+1);
                }
                dtm.addRow(fila);
            }
        }catch (SQLException e){

        } finally {
            Conexion2.close(rs);
            Conexion2.close(stmt);
            Conexion2.close(conn);
        }
        return dtm;
    }
}
