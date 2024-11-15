package capa_negocio;

import capaDatos.datos;
import java.math.*;
import java.sql.*;

/**
 *
 * @author Leonardo
 */
public class Usuario {

    datos objConectar = new datos();
    String strSQL;
    ResultSet rs = null;
    public String loggedInUsername = "";

    public ResultSet listarTodosUsuario() throws Exception {
        strSQL = "select * from usuario us inner join rol rl on us.id_rol = rl.id_rol\n"
                + "	inner join tipo_doc td on us.id_tipo_doc = td.id_tipo_doc";

        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception ex) {
            throw new Exception("Error al listar usuarios --> " + ex.getMessage());
        }
    }

    public ResultSet listarPorIDUsuario(int idUsuario) throws Exception {
        strSQL = "select * from usuario us inner join rol rl on us.id_rol = rl.id_rol\n"
                + "	inner join tipo_doc td on us.id_tipo_doc = td.id_tipo_doc\n"
                + "	where us.id_usuario = " + idUsuario;

        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception ex) {
            throw new Exception("Error al filtrar usuarios por ID --> " + ex.getMessage());
        }
    }

    public int genenrarIDUsuario() throws Exception {
        strSQL = "select coalesce(max(id_usuario),0)+1 as idUsuario from usuario";

        try {
            rs = objConectar.consultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("idUsuario");
            }
        } catch (Exception ex) {
            throw new Exception("Error al generar ID del usuario --> " + ex.getMessage());
        }

        return 0;
    }
    
    public void insertarUsuario(int idUsuario, String nombre, String apPaterno, String apMaterno, String numDoc, String fechaNac, String direccion, String numCelular, boolean sexo, float sueldo, String horario, String username, String email, int idRol, int idTipoDoc, boolean estado) throws Exception {
        //strSQL = "insert into usuario values (" + idUsuario + ", '" + nombre + "', '" + apPaterno + "', '" + apMaterno + "', '" + numDoc + "', '" + fechaNac + "', '" + direccion + "', '" + numCelular + "', " + sexo + ", " + sueldo + ", '" + horario + "', '" + username + "', '" + email + "', '" + contrasena + "', current_timestamp, " + estado + ", " + idRol + ", " + idTipoDoc + ", " + idCaja + ");";
        strSQL = "INSERT INTO usuario (id_usuario, nombre, ape_paterno, ape_materno, nro_documento, fecha_nacimiento, direccion, nro_celular, sexo, sueldo, horario, username, email, contrasena, estado, id_rol, id_tipo_doc) " +
             "VALUES (" + idUsuario + ", '" + nombre + "', '" + apPaterno + "', '" + apMaterno + "', '" + numDoc + "', '" + fechaNac + "', '" + direccion + "', '" + numCelular + "', " + sexo + ", " + sueldo + ", '" + horario + "', '" + username + "', '" + email + "', '1234', " + estado + ", " + idRol + ", " + idTipoDoc + ");";
        
        
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception ex) {
            throw new Exception("Error al registrar usuario --> " + ex.getMessage());
        }
    }

    public void modificarUsuario(int idUsuario, String nombre, String apPaterno, String apMaterno, String numDoc, String fechaNac, String direccion, String numCelular, boolean sexo, float sueldo, String horario, String username, String email, int idRol, int idTipoDoc, boolean estado) throws Exception {
        strSQL = "UPDATE usuario SET nombre = '" + nombre + "', ape_paterno = '" + apPaterno + "', ape_materno = '" + apMaterno + "', nro_documento = '" + numDoc + "', fecha_nacimiento = '" + fechaNac + "', direccion = '" + direccion + "', nro_celular = '" + numCelular + "', sexo = " + sexo + ", sueldo = " + sueldo + ", horario = '" + horario + "', username = '" + username + "', email = '" + email + "', estado = " + estado + ", id_rol = " + idRol + ", id_tipo_doc = " + idTipoDoc + " WHERE id_usuario = " + idUsuario;

        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception ex) {
            throw new Exception("Error al modificar usuario --> " + ex.getMessage());
        }
    }
    
    public void darBajaUsuario(int idUsuario) throws Exception {
        strSQL = "update usuario set estado = false where id_usuario = " + idUsuario;
        
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception ex) {
            throw new Exception("Error al dar de baja usuario --> " + ex.getMessage());
        }
    }
    
    public void eliminarUsuario(int idUsuario) throws Exception {
        strSQL = "delete from usuario where id_usuario = " + idUsuario;

        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception ex) {
            throw new Exception("Error al eliminar usuario --> " + ex.getMessage());
        }
    }
    
    public void actualizarContrasena(String username, String nuevaContrasena) throws Exception {
        strSQL = "UPDATE usuario SET contrasena = '" + nuevaContrasena + "' WHERE username = '"+username+"'";

        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception ex) {
            throw new Exception("Error al modificar la contraseña --> " + ex.getMessage());
        }
    }

    public void actualizarUltimoLogin(String username) throws Exception {
        strSQL = "update usuario set ultimo_login = current_timestamp where username = '"+username+"'";

        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception ex) {
            throw new Exception("");
        }
    }    
    
    public int obtenerIDUsuario(String numDoc) throws Exception {
        strSQL = "select id_usuario from usuario where nro_documento = '" + numDoc + "'";

        try {
            rs = objConectar.consultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("id_usuario");
            }
        } catch (Exception ex) {
            throw new Exception("Error al obtener ID del usuario --> " + ex.getMessage());
        }

        return 0;
    }

    public String login(String user, String password) throws Exception {
        strSQL = "SELECT username FROM usuario WHERE username = '" + user + "' AND contrasena = '" + password + "'";

        try {
            rs = objConectar.consultarBD(strSQL);

            if (rs.next()) {
                return rs.getString("username");  // Retorna el nombre de usuario
            }

        } catch (Exception e) {
            throw new Exception("Error al iniciar sesión: " + e.getMessage());
        }

        return "";
    }

    public String cargo(String user, String password) throws Exception {
        strSQL = "select R.rol as rol from usuario U inner join rol R on U.id_rol = R.id_rol WHERE U.username = '" + user + "' AND contrasena = '" + password + "'";

        try {
            rs = objConectar.consultarBD(strSQL);

            if (rs.next()) {
                return rs.getString("rol");  // Retorna el nombre de usuario
            }

        } catch (Exception e) {
            throw new Exception("Error al iniciar sesión: " + e.getMessage());
        }

        return "";
    }
    
    public Timestamp ultimoLogin(String usuario, String contrasena) throws Exception{
        strSQL = "select ultimo_login from usuario where username = '"+usuario+"' and contrasena = '"+contrasena+"'";
        
        try{
            rs = objConectar.consultarBD(strSQL);
            
            if(rs.next()){
                return rs.getTimestamp("ultimo_login");
            }
        }catch(Exception ex){
            throw new Exception("Error al obtener el último login: " + ex.getMessage());
        }
        
        return null;
    }

    //prueba
}
