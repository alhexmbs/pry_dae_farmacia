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
        strSQL = "INSERT INTO usuario (id_usuario, nombre, ape_paterno, ape_materno, nro_documento, fecha_nacimiento, direccion, nro_celular, sexo, sueldo, horario, username, email, contrasena, estado, id_rol, id_tipo_doc) "
                + "VALUES (" + idUsuario + ", '" + nombre + "', '" + apPaterno + "', '" + apMaterno + "', '" + numDoc + "', '" + fechaNac + "', '" + direccion + "', '" + numCelular + "', " + sexo + ", " + sueldo + ", '" + horario + "', '" + username + "', '" + email + "', '1234', " + estado + ", " + idRol + ", " + idTipoDoc + ");";

        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception ex) {
            throw new Exception("Error al registrar usuario --> " + ex.getMessage());
        }
    }

    public void insertarUsuarioMD5(int idUsuario, String nombre, String apPaterno, String apMaterno, String numDoc, String fechaNac, String direccion, String numCelular, boolean sexo, float sueldo, String horario, String username, String email, int idRol, int idTipoDoc) throws Exception {
        strSQL = "INSERT INTO usuario (id_usuario, nombre, ape_paterno, ape_materno, nro_documento, fecha_nacimiento, direccion, nro_celular, sexo, sueldo, horario, username, email, contrasena, estado, id_rol, id_tipo_doc) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, md5('1234' || ? || 'FIJO383'), true, ?, ?)";

        try {
            Connection micon = null;
            objConectar.conectar();
            micon = objConectar.getCon();
            PreparedStatement sp = micon.prepareStatement(strSQL);

            sp.setInt(1, idUsuario);
            sp.setString(2, nombre);
            sp.setString(3, apPaterno);
            sp.setString(4, apMaterno);
            sp.setString(5, numDoc);
            sp.setDate(6, Date.valueOf(fechaNac));
            sp.setString(7, direccion);
            sp.setString(8, numCelular);
            sp.setBoolean(9, sexo);
            sp.setFloat(10, sueldo);
            sp.setString(11, horario);
            sp.setString(12, username);
            sp.setString(13, email);
            sp.setString(14, username);
            //sp.setBoolean(15, true);
            sp.setInt(15, idRol);
            sp.setInt(16, idTipoDoc);

            sp.executeUpdate();
        } catch (Exception ex) {
            throw new Exception("Error al registrar usuario --> " + ex.getMessage());
        }
    }


    public void modificarUsuario(int idUsuario, String nombre, String apPaterno, String apMaterno, String numDoc, String fechaNac, String direccion, String numCelular, boolean sexo, float sueldo, String horario, String username, String email, int idRol, int idTipoDoc) throws Exception {
        strSQL = "UPDATE usuario SET nombre = '" + nombre + "', ape_paterno = '" + apPaterno + "', ape_materno = '" + apMaterno + "', nro_documento = '" + numDoc + "', fecha_nacimiento = '" + fechaNac + "', direccion = '" + direccion + "', nro_celular = '" + numCelular + "', sexo = " + sexo + ", sueldo = " + sueldo + ", horario = '" + horario + "', username = '" + username + "', email = '" + email + "', estado = true, id_rol = " + idRol + ", id_tipo_doc = " + idTipoDoc + " WHERE id_usuario = " + idUsuario;

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
        strSQL = "UPDATE usuario SET contrasena = '" + nuevaContrasena + "' WHERE username = '" + username + "'";

        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception ex) {
            throw new Exception("Error al modificar la contraseña --> " + ex.getMessage());
        }
    }

    public void actualizarContrasenaMD5(String username, String nuevaContrasena) throws Exception {
        strSQL = "UPDATE usuario SET contrasena = md5(? || ? || 'FIJO383') WHERE username = ?";

        try {
            Connection micon = null;
            objConectar.conectar();
            micon = objConectar.getCon();
            PreparedStatement sp = micon.prepareStatement(strSQL);

            sp.setString(1, nuevaContrasena);
            sp.setString(2, username);
            sp.setString(3, username);

            sp.executeUpdate();
        } catch (Exception ex) {
            throw new Exception("Error al modificar la contraseña --> " + ex.getMessage());
        }
    }

    public void actualizarUltimoLogin(String username) throws Exception {
        strSQL = "update usuario set ultimo_login = current_timestamp where username = '" + username + "'";

        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception ex) {
            throw new Exception("");
        }
    }

    public int obtenerIDUsuario(String username) throws Exception {
        strSQL = "select id_usuario from usuario where username = '" + username + "'";

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

    public boolean obtenerEstadoUsuario(int idUsuario) throws Exception {
        strSQL = "select * from usuario where id_usuario = " + idUsuario;

        try {
            rs = objConectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getBoolean("estado");
            }
        } catch (Exception ex) {
            throw new Exception("Error al obtener el estado del usuario --> " + ex.getMessage());
        }

        return false;
    }

    public boolean obtenerEstadoUsuarioMD5(int idUsuario) throws Exception {
        strSQL = "SELECT estado FROM usuario WHERE id_usuario = ?";

        try {
            Connection micon = null;
            objConectar.conectar();
            micon = objConectar.getCon();
            PreparedStatement sp = micon.prepareStatement(strSQL);
            sp.setInt(1, idUsuario);

            rs = sp.executeQuery();
            if (rs.next()) {
                return rs.getBoolean("estado");
            }

            objConectar.desconectar();
        } catch (Exception ex) {
            throw new Exception("Error al obtener el estado del usuario --> " + ex.getMessage());
        }

        return false;
    }

    public boolean obtenerEstadoUserStringMD5(String usuario) throws Exception {
        strSQL = "select estado from usuario where username = ?";

        try {
            Connection micon = null;
            objConectar.conectar();
            micon = objConectar.getCon();
            PreparedStatement sp = micon.prepareStatement(strSQL);
            sp.setString(1, usuario);

            rs = sp.executeQuery();
            if (rs.next()) {
                return rs.getBoolean("estado");
            }

            objConectar.desconectar();
        } catch (Exception ex) {
            throw new Exception("Error al obtener el estado del usuario --> " + ex.getMessage());
        }

        return false;
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

    public void loginMD5(String user, String password) throws Exception {
        strSQL = "SELECT username, id_usuario FROM usuario WHERE username = ? AND contrasena = md5(? || ? || 'FIJO383') AND estado = true";

        boolean acceso = false;

        try {
            Connection micon = null;
            objConectar.conectar();
            micon = objConectar.getCon();
            PreparedStatement sp = micon.prepareStatement(strSQL);
            sp.setString(1, user);
            sp.setString(2, password);
            sp.setString(3, user);

            rs = sp.executeQuery();
            if (rs.next()) {
                Funciones.USUARIO_INICIO_SESION = rs.getString("username");
                Funciones.ID_INICIO_SESION = rs.getInt("id_usuario");
                acceso = true;
            }

            objConectar.desconectar();
        } catch (Exception ex) {
            throw new Exception("Error al iniciar sesión: " + ex.getMessage());
        }

        if (!acceso) {
            Funciones.USUARIO_INICIO_SESION = "";
            Funciones.ID_INICIO_SESION = -1;
        }
    }

    public String cargo(int id_user) throws Exception {
        strSQL = "SELECT R.rol AS rol FROM usuario U INNER JOIN rol R ON U.id_rol = R.id_rol WHERE U.id_usuario = " + id_user;

        try {
            rs = objConectar.consultarBD(strSQL);

            if (rs.next()) {
                return rs.getString("rol");
            }

        } catch (Exception e) {
            throw new Exception("Error al iniciar sesión: " + e.getMessage());
        }

        return "";
    }
    
    
    public Timestamp ultimoLogin(String usuario, String contrasena) throws Exception {
        strSQL = "SELECT ultimo_login FROM usuario WHERE username = ? AND contrasena = md5(? || ? || 'FIJO383')";

        try {
            Connection micon = null;
            objConectar.conectar();
            micon = objConectar.getCon();
            PreparedStatement sp = micon.prepareStatement(strSQL);
            sp.setString(1, usuario);
            sp.setString(2, contrasena);
            sp.setString(3, usuario);

            rs = sp.executeQuery();
            if (rs.next()) {
                return rs.getTimestamp("ultimo_login");
            }
        } catch (Exception ex) {
            throw new Exception("Error al obtener el último login: " + ex.getMessage());
        }

        return null;
    }

    //prueba
}
