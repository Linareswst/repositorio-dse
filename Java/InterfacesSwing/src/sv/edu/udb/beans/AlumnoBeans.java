package sv.edu.udb.beans;

public class AlumnoBeans {
    int idAlumno;
    String nombreAlumno;
    String carnetAlumno;
    int idMateria;

    public AlumnoBeans(int idAlumno, String nombreAlumno, String carnetAlumno, int idMateria){
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.carnetAlumno = carnetAlumno;
        this.idMateria = idMateria;
    }

    public int getIdAlumno(){
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno){
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno(){
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno){
        this.nombreAlumno = nombreAlumno;
    }

    public String getCarnetAlumno(){
        return  carnetAlumno;
    }

    public void setCarnetAlumno(String carnetAlumno){
        this.carnetAlumno = carnetAlumno;
    }

    public int getIdMateria(){
        return idMateria;
    }

    public void setIdMateria(int idMateria){
        this.idMateria = idMateria;
    }
}
