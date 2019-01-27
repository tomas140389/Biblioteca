package dao;

import clases.Profesor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfesorDao {

    private Conexion conexion;
    private PreparedStatement pst;
    //private ResultSet rs;

    //Siempre inicializar desde el contructor
    public ProfesorDao() {
        this.conexion = new Conexion();
        this.pst = null;
    }

    public Integer insertar(Profesor profesor) {
        try {
            if (this.conexion.conectarse()) {
                pst = conexion.getConexion().prepareStatement("insert into biblioteca.profesor values (?,?,?,?)");

                pst.setInt(1, profesor.getCedula());
                pst.setString(2, profesor.getNombre());
                pst.setDouble(3, profesor.getSalario());
                pst.setString(4, profesor.getEscuela());
                pst.executeUpdate();
                conexion.desconectar();
                return 0;//Conecta a la BD

                /*
                -execute si utilizo metodo de tipo boolean returna true o false
                -executeQuery si necesito la busqueda del Resulset
                -excuteUpdate me devuelve un int 0,1
                 */
            } else {
                return 1;//No se pudo conectar a la BD
            }

        } catch (SQLException ex) {
            ex.printStackTrace();//Excepcion para q salga en consola el error
            if (ex.getSQLState().startsWith("23")) {//Si el error indica un 23 es llave duplicada
                return 2;//llave primaria duplicada
            } else {
                return 3;//error ejecutando el insert
            }

        }
    }

    public Integer Eliminar(Profesor profesor) {
        try {
            if (conexion.conectarse()) {
                pst = conexion.getConexion().prepareStatement("delete from biblioteca.profesor where cedula = ?");

                pst.setInt(1, profesor.getCedula());
                int respuesta = pst.executeUpdate();
                conexion.desconectar();

                if (respuesta == 0) {
                    return 0;//No se elimino nada
                } else {
                    return 1;//Se elimino
                }
            } else {
                return 2;//No se pudo conectar a la BD
            }
            //MySQLIntegrityConstraintViolationException paquete sql
            //Se puede agregar mas de un catch
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 3;
        }
    }

    public Integer modificar(Profesor profesor) {

        try {
            if (conexion.conectarse()) {
                pst = conexion.getConexion().prepareStatement("update biblioteca.profesor set nombre = ?, salario = ?, escuela = ? where cedula = ? ");
                pst.setString(1, profesor.getNombre());
                pst.setDouble(2, profesor.getSalario());
                pst.setString(3, profesor.getEscuela());
                pst.setInt(4, profesor.getCedula());
                pst.executeUpdate();
                conexion.desconectar();
                return 0;//Conecto

            } else {
                return 1;//No conecto
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 2;//Error a la hora de modificar
        }
    }

    public List<Profesor> consultaTodos() {

        try {
            if (conexion.conectarse()) {

                pst = conexion.getConexion().prepareStatement("select * from biblioteca.profesor");

                List listaProfesores = new ArrayList();

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    Profesor profe = new Profesor();
                    profe.setCedula(rs.getInt("cedula"));
                    profe.setNombre(rs.getString(2));//Sirve con el nombre de columna o numero de columna
                    profe.setSalario(rs.getDouble("salario"));
                    profe.setEscuela(rs.getString("escuela"));
                    listaProfesores.add(profe);
                }
                conexion.desconectar();
                return listaProfesores;

            } else {
                conexion.desconectar();
                return null;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Profesor> consultaNombre(String nombre) {

        try {
            if (conexion.conectarse()) {

                //El like se utiliza con strings, para que todos empiezen con letras en especifico, busqueda general
                pst = conexion.getConexion().prepareStatement("select * from biblioteca.profesor where nombre like ?");

                //Los porcentajes es para que busque al inicio o al final
                pst.setString(1, "%" + nombre + "%");

                List listaProfesores = new ArrayList();

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    Profesor profe = new Profesor();//Queda dentro del while ya q tiene q hacer un objeto nuevo por vez
                    profe.setCedula(rs.getInt("cedula"));
                    profe.setNombre(rs.getString("nombre"));//Sirve con el nombre de columna o numero de columna
                    profe.setSalario(rs.getDouble("salario"));
                    profe.setEscuela(rs.getString("escuela"));
                    listaProfesores.add(profe);
                }
                conexion.desconectar();
                return listaProfesores;

            } else {
                conexion.desconectar();
                return null;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Profesor consultaCedula(int cedula) {

        try {
            if (conexion.conectarse()) {

                //El like se utiliza con strings, para que todos empiezen con letras en especifico, busqueda general
                pst = conexion.getConexion().prepareStatement("select * from biblioteca.profesor where cedula = ?");

                //Los porcentajes es para que busque al inicio o al final
                pst.setInt(1, cedula);

                ResultSet rs = pst.executeQuery();

                Profesor profe = new Profesor();//Aca es solo un objeto y ademas debe retornar profe

                while (rs.next()) {
                    profe.setCedula(rs.getInt("cedula"));
                    profe.setNombre(rs.getString("nombre"));//Sirve con el nombre de columna o numero de columna
                    profe.setSalario(rs.getDouble("salario"));
                    profe.setEscuela(rs.getString("escuela"));
                }
                conexion.desconectar();
                return profe;
            } else {
                conexion.desconectar();
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion cn) {
        this.conexion = cn;
    }

    public PreparedStatement getPst() {
        return pst;
    }

    public void setPst(PreparedStatement pst) {
        this.pst = pst;
    }

}
