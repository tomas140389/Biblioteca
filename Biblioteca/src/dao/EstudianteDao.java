package dao;

import clases.Estudiante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EstudianteDao {

    private Conexion conexion;
    private PreparedStatement pst;

    public EstudianteDao() {
        conexion = new Conexion();
        pst = null;
    }

    public Integer insertar(Estudiante estudiante) {

        try {
            if (conexion.conectarse()) {
                pst = conexion.getConexion().prepareStatement("insert into biblioteca.estudiante values (?,?,?,?)");

                pst.setInt(1, estudiante.getCedula());
                pst.setString(2, estudiante.getNombre());
                pst.setString(3, estudiante.getCarrera());
                pst.setInt(4, estudiante.getCarnet());
                pst.executeUpdate();

                conexion.desconectar();
                return 0;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo conectar");
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

    public Integer eliminar(Estudiante estudiante) {

        try {
            if (conexion.conectarse()) {

                pst = conexion.getConexion().prepareStatement("delete from biblioteca.estudiante where cedula = ?");

                pst.setInt(1, estudiante.getCedula());
                int respuesta = pst.executeUpdate();
                conexion.desconectar();

                if (respuesta == 0) {
                    return 0;
                } else {
                    return 1;
                }

            } else {
                return 2;
            }

        } catch (SQLException e) {
            return 3;
        }
    }

    public Integer modificar(Estudiante estudiante) {

        try {
            if (conexion.conectarse()) {
                pst = conexion.getConexion().prepareStatement("update biblioteca.estudiante set nombre = ?, carrera = ?, carnet = ? where cedula = ?");
                pst.setString(1, estudiante.getNombre());
                pst.setString(2, estudiante.getCarrera());
                pst.setInt(3, estudiante.getCarnet());
                pst.setInt(4, estudiante.getCedula());
                pst.executeUpdate();

                conexion.desconectar();
                return 0;
            } else {
                return 1;
            }

        } catch (SQLException e) {
            return 2;
        }
    }

    public List<Estudiante> consutaTodos() {

        try {
            if (conexion.conectarse()) {

                pst = conexion.getConexion().prepareStatement("select * from biblioteca.estudiante");

                List listaEstudiantes = new ArrayList();

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    Estudiante estudiante = new Estudiante();
                    estudiante.setCedula(rs.getInt("cedula"));
                    estudiante.setNombre(rs.getString("nombre"));
                    estudiante.setCarrera(rs.getString("carrera"));
                    estudiante.setCarnet(rs.getInt("carnet"));
                    listaEstudiantes.add(estudiante);
                }
                conexion.desconectar();
                return listaEstudiantes;

            } else {
                conexion.desconectar();
                return null;
            }

        } catch (SQLException e) {
            return null;
        }
    }

    public List<Estudiante> consultaNombre(String nombre) {

        try {
            if (conexion.conectarse()) {
                pst = conexion.getConexion().prepareStatement("select * from biblioteca.estudiante where nombre like ?");

                pst.setString(1, "%" + nombre + "%");

                List listaEstudiantes = new ArrayList();

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    Estudiante estudiante = new Estudiante();
                    estudiante.setCedula(rs.getInt("cedula"));
                    estudiante.setNombre(rs.getString("nombre"));
                    estudiante.setCarrera(rs.getString("carrera"));
                    estudiante.setCarnet(rs.getInt("carnet"));
                    listaEstudiantes.add(estudiante);
                }
                conexion.desconectar();
                return listaEstudiantes;

            } else {
                conexion.desconectar();
                return null;
            }

        } catch (SQLException e) {
            return null;
        }
    }

    public Estudiante consultaCedula(int cedula) {

        try {
            if (conexion.conectarse()) {
                pst = conexion.getConexion().prepareStatement("select * from biblioteca.estudiante where cedula = ?");

                pst.setInt(1, cedula);

                ResultSet rs = pst.executeQuery();

                Estudiante estudiante = new Estudiante();

                while (rs.next()) {
                    estudiante.setCedula(rs.getInt("cedula"));
                    estudiante.setNombre(rs.getString("nombre"));
                    estudiante.setCarrera(rs.getString("carrera"));
                    estudiante.setCarnet(rs.getInt("carnet"));
                }
                conexion.desconectar();
                return estudiante;

            } else {
                conexion.desconectar();
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
