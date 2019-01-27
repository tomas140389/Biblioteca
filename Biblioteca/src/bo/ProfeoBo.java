package bo;

import clases.Profesor;
import dao.ProfesorDao;
import java.util.List;

public class ProfeoBo {
    private ProfesorDao profeDao;
    
    //Constructor
    public ProfeoBo(){
        this.profeDao = new ProfesorDao();
    }
    
    public Integer insertar(Profesor profesor){        
        return profeDao.insertar(profesor);
    }
    
    public Integer eliminar(Profesor profesor){
        return profeDao.Eliminar(profesor);
    }
    
    public Integer modificar(Profesor profesor){
        return profeDao.modificar(profesor);
    }
    
    public List<Profesor> consultaTodos(){
        return profeDao.consultaTodos();
    }
    
    public List<Profesor> consultaNombre(String nombre){
        return profeDao.consultaNombre(nombre);
    }
    
    public Profesor consultaCedula(int cedula){
        return profeDao.consultaCedula(cedula);
    }
    

    public ProfesorDao getProfeDao() {
        return profeDao;
    }

    public void setProfeDao(ProfesorDao profeDao) {
        this.profeDao = profeDao;
    }
    
    
    
}
