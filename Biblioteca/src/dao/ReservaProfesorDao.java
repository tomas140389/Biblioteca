package dao;

import clases.ReservaProfesor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReservaProfesorDao {

    private Conexion conexion;
    private PreparedStatement pst;

    public ReservaProfesorDao() {
        conexion = new Conexion();
        pst = null;
    }

    public Integer insertarReversaProfesor(ReservaProfesor reserva) {
        try {
            if (conexion.conectarse()) {
                pst = conexion.getConexion().prepareStatement("insert into biblioteca.reserva_profesor values (?,?,?,?)");

                pst.setInt(1, reserva.getCedulaProfesor());
                pst.setInt(2, reserva.getCodigoLibro());
                pst.setTimestamp(3, new Timestamp(reserva.getFechaReserva().getTime()));
                pst.setInt(4, reserva.getDiasReserva());
                pst.executeUpdate();
                conexion.desconectar();
                return 0;

            } else {
                return 1;
            }

        } catch (SQLException e) {
            if (e.getSQLState().startsWith("23")) {
                return 2;
            } else {
                return 3;
            }
        }
    }

    public List<ReservaProfesor> consultaTodos() {

        try {

            if (conexion.conectarse()) {
                pst = conexion.getConexion().prepareStatement("select * from biblioteca.reserva_profesor");

                ResultSet rs = pst.executeQuery();

                List listaReservasProfesor = new ArrayList();

                while (rs.next()) {
                    ReservaProfesor reservaProfesor = new ReservaProfesor();
                    reservaProfesor.setCedulaProfesor(rs.getInt("cedula"));
                    reservaProfesor.setCodigoLibro(rs.getInt("codigo"));
                    reservaProfesor.setFechaReserva(rs.getTimestamp("fecha"));
                    reservaProfesor.setDiasReserva(rs.getInt("dias"));
                    listaReservasProfesor.add(reservaProfesor);
                }
                conexion.desconectar();
                return listaReservasProfesor;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public PreparedStatement getPst() {
        return pst;
    }

    public void setPst(PreparedStatement pst) {
        this.pst = pst;
    }

    
    
}
