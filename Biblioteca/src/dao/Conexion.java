package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection conexion;

    public boolean conectarse() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/biblioteca?useSSL=false&serverTimezone=UTC";
            String usuario = "root";
            String password = "12345678";

            this.conexion = (Connection) DriverManager.getConnection(url, usuario, password);
            return true;

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean desconectar() {

        try {
            conexion.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection cn) {
        this.conexion = cn;
    }

}
