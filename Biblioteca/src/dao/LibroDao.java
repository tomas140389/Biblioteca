package dao;

import clases.Libro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDao {

    private Conexion conexion;
    private PreparedStatement pst;

    public LibroDao() {
        conexion = new Conexion();
        pst = null;
    }

    public Integer insertar(Libro libro) {
        try {
            if (conexion.conectarse()) {

                pst = conexion.getConexion().prepareStatement("insert into biblioteca.libro values (?,?,?,?,?)");

                pst.setInt(1, libro.getCodigo());
                pst.setString(2, libro.getNombre());
                pst.setString(3, libro.getAutor());
                pst.setInt(4, libro.getAno());
                pst.setDouble(5, libro.getPrecio());
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

    public Integer eliminar(Libro libro) {
        try {
            if (conexion.conectarse()) {

                pst = conexion.getConexion().prepareStatement("delete from biblioteca.libro where codigo = ?");

                pst.setInt(1, libro.getCodigo());
                int resultado = pst.executeUpdate();

                conexion.desconectar();

                if (resultado == 0) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 2;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 3;
        }
    }

    public Integer modificar(Libro libro) {
        try {
            if (conexion.conectarse()) {

                pst = conexion.getConexion().prepareStatement("update biblioteca.libro set nombre = ?, autor = ?, ano = ?, precio = ? where codigo = ?");

                pst.setString(1, libro.getNombre());
                pst.setString(2, libro.getAutor());
                pst.setInt(3, libro.getAno());
                pst.setDouble(4, libro.getPrecio());
                pst.setInt(5, libro.getCodigo());                
                conexion.desconectar();
                return 0;
            } else {
                return 1;
            }

        } catch (SQLException e) {
            return 2;
        }
    }

    public List<Libro> consultaTodos() {
        try {
            if (conexion.conectarse()) {

                pst = conexion.getConexion().prepareStatement("select * from biblioteca.libro");

                List listaLibros = new ArrayList();

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    Libro libro = new Libro();
                    libro.setCodigo(rs.getInt("codigo"));
                    libro.setNombre(rs.getString("nombre"));
                    libro.setAutor(rs.getString("autor"));
                    libro.setAno(rs.getInt("ano"));
                    libro.setPrecio(rs.getDouble("precio"));
                    listaLibros.add(libro);
                }
                conexion.desconectar();
                return listaLibros;
            } else {
                return null;
            }

        } catch (SQLException e) {
            return null;
        }
    }

    public Libro consultaCodigo(int codigo) {

        try {
            if (conexion.conectarse()) {

                pst = conexion.getConexion().prepareStatement("select * from biblioteca.libro where codigo = ?");

                pst.setInt(1, codigo);

                ResultSet rs = pst.executeQuery();

                Libro libro = new Libro();

                while (rs.next()) {
                    libro.setCodigo(rs.getInt("codigo"));
                    libro.setNombre(rs.getString("nombre"));
                    libro.setAutor(rs.getString("autor"));
                    libro.setAno(rs.getInt("ano"));
                    libro.setPrecio(rs.getDouble("precio"));
                }
                conexion.desconectar();
                return libro;

            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Libro> consultaNombre(String nombre) {
        try {
            if (conexion.conectarse()) {

                pst = conexion.getConexion().prepareStatement("select * from biblioteca.libro where nombre like ? ");

                pst.setString(1, "%" + nombre + "%");

                ResultSet rs = pst.executeQuery();

                List listaLibros = new ArrayList();

                while (rs.next()) {
                    Libro libro = new Libro();
                    libro.setCodigo(rs.getInt("codigo"));
                    libro.setNombre(rs.getString("nombre"));
                    libro.setAutor(rs.getString("autor"));
                    libro.setAno(rs.getInt("ano"));
                    libro.setPrecio(rs.getDouble("precio"));
                    listaLibros.add(libro);
                }
                conexion.desconectar();
                return listaLibros;

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


