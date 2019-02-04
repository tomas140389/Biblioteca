package bo;

import clases.ReservaEstudiante;
import dao.ReservaEstudianteDao;
import java.util.List;

public class ReservaEstudianteBo {

    private ReservaEstudianteDao reservaEstudianteDao;

    public ReservaEstudianteBo() {
        reservaEstudianteDao = new ReservaEstudianteDao();
    }

    public Integer insertar(ReservaEstudiante reservaEstudiante) {
        return reservaEstudianteDao.insertar(reservaEstudiante);
    }

    public List consultaTodos() {
        return reservaEstudianteDao.consultaTodos();
    }

    public ReservaEstudianteDao getReservaEstudianteDao() {
        return reservaEstudianteDao;
    }

    public void setReservaEstudianteDao(ReservaEstudianteDao reservaEstudianteDao) {
        this.reservaEstudianteDao = reservaEstudianteDao;
    }

}
