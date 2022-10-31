package model.interfaz;

import model.entities.Persona;
import model.seguridad.Usuario;

public class inter {
    
    public Usuario Registrarse(Persona persona, String nombreUsuario, String contrasenia, String nombreUsuarioAValidar, String contraseniaAValidar){
       return new Usuario(persona, nombreUsuario, contrasenia, nombreUsuarioAValidar,contraseniaAValidar);
    }
    
    public void CerarSesion(){
        
    }
            
}

