package bo;

import clases.ReservaProfesor;
import dao.ReservaProfesorDao;
import java.util.List;

public class ReservaProfesorBo {
    
    private ReservaProfesorDao reservaProfesorDao;
    
    public ReservaProfesorBo(){
        reservaProfesorDao = new ReservaProfesorDao();        
    }
    
    public Integer insertarReservarProfesor(ReservaProfesor reservaProfesor){
        return reservaProfesorDao.insertarReversaProfesor(reservaProfesor);
    }
    
    public List<ReservaProfesor> consultaTodos(){
        return reservaProfesorDao.consultaTodos();
    }

    public ReservaProfesorDao getReservaProfesorDao() {
        return reservaProfesorDao;
    }

    public void setReservaProfesorDao(ReservaProfesorDao reservaProfesorDao) {
        this.reservaProfesorDao = reservaProfesorDao;
    }    
}
