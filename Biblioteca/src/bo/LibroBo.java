package bo;

import clases.Libro;
import dao.LibroDao;
import java.util.List;

public class LibroBo {
    
    private LibroDao libroDao;
    
    public LibroBo(){
        libroDao = new LibroDao();       
    }
    
    public Integer insertar(Libro libro){
        return libroDao.insertar(libro);
    }
    
    public Integer eliminar(Libro libro){
        return libroDao.eliminar(libro);
    }
    
    public Integer modificar(Libro libro){
        return libroDao.modificar(libro);
    }
    
    public List<Libro> consultaTodos(){
        return libroDao.consultaTodos();
    }
    
    public Libro consultaCodigo(int codigo){
        return libroDao.consultaCodigo(codigo);
    }
    
    public List<Libro> conulstaNombre(String nombre){
        return libroDao.consultaNombre(nombre);
    }
}
