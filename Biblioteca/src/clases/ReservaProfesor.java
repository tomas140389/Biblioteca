package clases;

import java.util.Date;

public class ReservaProfesor {
    
    private Integer cedulaProfesor;
    private Integer codigoLibro;
    private Integer diasReserva;
    private Date fechaReserva;

    public Integer getCedulaProfesor() {
        return cedulaProfesor;
    }

    public void setCedulaProfesor(Integer cedulaProfesor) {
        this.cedulaProfesor = cedulaProfesor;
    }

    public Integer getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(Integer codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public Integer getDiasReserva() {
        return diasReserva;
    }

    public void setDiasReserva(Integer diasReserva) {
        this.diasReserva = diasReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    
    
}
