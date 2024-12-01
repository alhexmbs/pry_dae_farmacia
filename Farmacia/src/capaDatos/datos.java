package capaDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Katiad
 */
public class datos {

    private String driver, url, user, password;
    private Connection con;
    private Statement sent = null;

    public datos() {
        this.driver = "org.postgresql.Driver";
        //this.url = "jdbc:postgresql://25.59.118.186:5432/DAE_FARMACIA";
        this.url = "jdbc:postgresql://localhost:5432/DAE_FARMACIA";
        this.user = "postgres";
        //this.password = "visa2005";
        this.con = null;
    }

    public Connection getCon() {
        return con;
    }

    public void conectar() throws Exception {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception("Error al conectar la BD!");
        }
    }

    public void desconectar() throws Exception {
        try {
            con.close();
        } catch (SQLException ex) {
            throw new Exception("Error al desconectar la BD!");
        }
    }

    public ResultSet consultarBD(String strSQL) throws Exception {
        ResultSet rs = null;
        try {
            conectar();
            sent = con.createStatement();
            rs = sent.executeQuery(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al ejecutar consulta" + e.getMessage());
        } finally {
            if (con != null) {
                desconectar();
            }
        }
    }

    public void ejecutarBd(String strSQl) throws Exception {
        try {
            conectar();
            sent = con.createStatement();
            sent.executeUpdate(strSQl);
        } catch (Exception e) {
            throw new Exception("Error al ejecutar update-->" + e.getMessage());
        } finally {
            if (con != null) {
                desconectar();
            }
        }
    }
}
