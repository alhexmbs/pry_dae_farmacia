package Capa_principal;

public class appPrincipal {

    public static void main(String[] args) {
<<<<<<< HEAD
        //JdInicioSesion objm = new JdInicioSesion(null, true);
        //objm.setLocationRelativeTo(null);
       // objm.setVisible(true);
        /*...probando**/
=======
        /*
        JdInicioSesion objm = new JdInicioSesion(null, true);
        objm.setLocationRelativeTo(null);
        objm.setVisible(true);
        ...probando**/
>>>>>>> b0f9d70a4b5d6aa0f0c751e260d438252200a57d
       
        
        frmFarmacia farmacia = new frmFarmacia("Administrador", 1, 1);
        farmacia.setVisible(true);
        
        
        /*
            Ojito??
            Cada que se cree un nuevo usuario, la contraseña por default es "1234", se detecta si es nuevo y pedirá ingresar una nueva
        */
    }

}