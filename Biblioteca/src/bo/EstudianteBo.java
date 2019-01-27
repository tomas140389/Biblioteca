package bo;

import clases.Estudiante;
import dao.EstudianteDao;
import java.util.List;

public class EstudianteBo {
    
    private EstudianteDao estudianteDao;
    
    public EstudianteBo(){
        this.estudianteDao = new EstudianteDao();
    }

    public Integer insertar(Estudiante estudiante){
        return estudianteDao.insertar(estudiante);
    }
    
    public Integer eliminar(Estudiante estudiante){
        return estudianteDao.eliminar(estudiante);
    }
    
    public Integer modificar(Estudiante estudiante){
        return estudianteDao.modificar(estudiante);
    }
    
    public List<Estudiante> consultaTodos(){
        return estudianteDao.consutaTodos();
    }
    
    public List<Estudiante> consultaNombre(String nombre){
        return estudianteDao.consultaNombre(nombre);
    }
    
    public Estudiante consultaCedula(int cedula){
        return estudianteDao.consultaCedula(cedula);
    }
        
    public EstudianteDao getEstudianteDao() {
        return estudianteDao;
    }

    public void setEstudianteDao(EstudianteDao estudianteDao) {
        this.estudianteDao = estudianteDao;
    }
    
    
    
}
