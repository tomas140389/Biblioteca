package dao;

import clases.ReservaEstudiante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReservaEstudianteDao {

    private Conexion conexion;
    private PreparedStatement pst;

    public ReservaEstudianteDao() {
        conexion = new Conexion();
        pst = null;
    }

    public Integer insertar(ReservaEstudiante reservaEstudiante) {
        try {
            if (conexion.conectarse()) {
                pst = conexion.getConexion().prepareStatement("insert into biblioteca.reserva_estudiante values (?,?,?,?)");

                pst.setInt(1, reservaEstudiante.getCedula());
                pst.setInt(2, reservaEstudiante.getCodigo());
                pst.setTimestamp(3, new Timestamp(reservaEstudiante.getFechaReserva().getTime()));
                pst.setInt(4, reservaEstudiante.getDias());

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
                e.printStackTrace();
                return 3;
            }
        }
    }

    public List<ReservaEstudiante> consultaTodos() {
        try {
            if (conexion.conectarse()) {
                pst = conexion.getConexion().prepareStatement("select * from biblioteca.reserva_estudiante");

                ResultSet rs = pst.executeQuery();

                List listaReservaEstudiantes = new ArrayList();

                while (rs.next()) {
                    ReservaEstudiante reservaEstudiante = new ReservaEstudiante();
                    reservaEstudiante.setCedula(rs.getInt("cedula"));
                    reservaEstudiante.setCodigo(rs.getInt("codigo"));
                    reservaEstudiante.setFechaReserva(rs.getTimestamp("fecha"));
                    reservaEstudiante.setDias(rs.getInt("dias"));
                    listaReservaEstudiantes.add(reservaEstudiante);
                }
                conexion.desconectar();
                return listaReservaEstudiantes;
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
